/**
 * 
 */
package com.googlecode.habano.systeminfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.habano.libc32.CLibrary;
import com.googlecode.habano.libc32.statvfs;
import com.googlecode.habano.libc32.timeval;
import com.googlecode.habano.libc32.tm;
import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.sun.jna.ptr.IntByReference;

/**
 * 
 * An implementation of {@link SystemInfo} to be used when the JVM is running
 * on a 32-bit Linux platform. Most of the information is extracted calling
 * the standar c library (libc) functions that are accessed through
 * {@link CLibrary}. 
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public class SystemInfoLinux32Impl extends SystemInfo {
	/**
	 * A pattern to extract information from each line of /proc/meminfo
	 */
	private static final Pattern MEMINFO_PATTERN = Pattern.compile("^(.*):\\s*(\\d+)\\s*(.*)$");
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getMemoryInfo()
	 */
	@Override
	public MemoryInfo getMemoryInfo() {
		MemoryInfo memoryInfo = new MemoryInfo();
		
		try {
			Map<String, Integer> memInfo = this.readProcFsMemInfo();
			
			memoryInfo.setTotalSystemMemory(memInfo.get("MemTotal") * 1000L);
			memoryInfo.setAvailableSystemMemory(memInfo.get("MemFree") * 1000L);
			memoryInfo.setTotalVirtualMemory(memInfo.get("SwapTotal") * 1000L);
			memoryInfo.setAvailableVirtualMemory(memInfo.get("SwapFree") * 1000L);
		} catch (Exception e) {
			// TODO Handle /proc/meminfo access exception
			e.printStackTrace();
		}
		
		return memoryInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemTimeInMillis()
	 */
	@Override
	public long getSystemTimeInMillis() {
		timeval tv = this.callGetTimeOfDay();

		return tv.tv_sec * 1000L + tv.tv_usec / 1000L;
	}

	private timeval callGetTimeOfDay() {
		timeval tv = new timeval();

		// According to the manpage the timezone structure is obsolete and it
		// should always be NULL;
		CLibrary.INSTANCE.gettimeofday(tv, null);

		return tv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemTimeInfo()
	 */
	@Override
	public SystemTimeInfo getSystemTimeInfo() {
		SystemTimeInfo systemTimeInfo = new SystemTimeInfo();
		
		timeval tv = this.callGetTimeOfDay();
		tm result = this.callGetLocaltime_r(new IntByReference(tv.tv_sec));
		
		systemTimeInfo.setDayOfMonth(result.tm_mday);
		systemTimeInfo.setDayOfWeek(result.tm_wday);
		systemTimeInfo.setHour(result.tm_hour);
		systemTimeInfo.setMillisecond(tv.tv_usec / 1000);
		systemTimeInfo.setMinute(result.tm_min);
		systemTimeInfo.setMonth(result.tm_mon);
		systemTimeInfo.setSecond(result.tm_sec);
		systemTimeInfo.setYear(1900 + result.tm_year);

		return systemTimeInfo;
	}

	private tm callGetLocaltime_r(IntByReference timep) {
		tm resultp = new tm();
		
		CLibrary.INSTANCE.localtime_r(timep, resultp);
		
		return resultp;
	} 
	
	private Map<String, Integer> readProcFsMemInfo() throws NumberFormatException, IOException {
		final Map<String, Integer> procFsMemInfo = new HashMap<String, Integer>();

		this.readProcFs("/proc/meminfo", new ProcFsEntryHandler() {
			@Override
			public void handleEntry(String entry) {
				Matcher matcher = MEMINFO_PATTERN.matcher(entry);
				
				if (matcher.matches()) {
					procFsMemInfo.put(matcher.group(1), Integer.valueOf(matcher.group(2)));
				}
			}});
		
		return procFsMemInfo;
	}
	
	private void readProcFs(String path, ProcFsEntryHandler procFsEntryHandler) throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			
			while ((line = bufferedReader.readLine()) != null) {
				procFsEntryHandler.handleEntry(line);
			}
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// Close quietly
				}
			}
		}
	}
	
	private interface ProcFsEntryHandler {
		void handleEntry(String entry);
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getFileSystemInfo(java.lang.String)
	 */
	@Override
	public FileSystemInfo getFileSystemInfo(String path) {
		statvfs buf = this.callStatvfs(path);
		
		FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(buf.f_blocks * buf.f_frsize.longValue());
		fileSystemInfo.setFreeSpace(buf.f_bavail * buf.f_frsize.longValue());

		return fileSystemInfo;
	}
	
	private statvfs callStatvfs(String path) {
		statvfs buf = new statvfs();
		
		CLibrary.INSTANCE.statvfs(path, buf);
		
		return buf;
	}
}
