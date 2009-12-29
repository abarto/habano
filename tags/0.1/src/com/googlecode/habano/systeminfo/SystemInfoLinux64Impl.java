/**
 * 
 */
package com.googlecode.habano.systeminfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.habano.libc64.CLibrary64;
import com.googlecode.habano.libc64.statvfs_64;
import com.googlecode.habano.libc64.timeval_64;
import com.googlecode.habano.libc64.tm_64;
import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemArchitectureInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.googlecode.habano.util.ProcFsLineHandler;
import com.googlecode.habano.util.ProcFsProcessor;
import com.sun.jna.ptr.LongByReference;

/**
 * 
 * An implementation of {@link SystemInfo} to be used when the JVM is running
 * on a 64-bit Linux platform. Most of the information is extracted calling
 * the standar c library (libc) functions that are accessed through
 * {@link CLibrary64}. 
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public class SystemInfoLinux64Impl extends SystemInfo {
	/**
	 * /proc entries processor.
	 */
	private static final ProcFsProcessor procFsProcessor = new ProcFsProcessor();

	/**
	 * A pattern to extract information from each line of /proc/meminfo
	 */
	private static final Pattern MEMINFO_PATTERN = Pattern.compile("^(.*):\\s*(\\d+)\\s*(.*)$");

	/**
	 * A pattern to extract information from /proc/cpuinfo
	 */
	private static final Pattern CPU_CORES_PATTERN = Pattern.compile("^cpu\\s+cores\\s+:\\s+(\\d+)$");	

	/**
	 * A pattern to extract information from /proc/cpuinfo
	 */
	private static final Pattern VENDOR_ID_PATTERN = Pattern.compile("^vendor_id\\s+:\\s+(\\w+)$");	

	/**
	 * A pattern to extract information from /proc/cpuinfo
	 */
	private static final Pattern LONG_MODE_FLAG_PATTERN = Pattern.compile("^flags\\s+:.*\\blm\\b?.*$");	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getMemoryInfo()
	 */
	@Override
	public MemoryInfo getMemoryInfo() {
		MemoryInfo memoryInfo = new MemoryInfo();
		
		try {
			Map<String, Long> memInfo = this.readProcFsMemInfo();
			
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
		timeval_64 tv = this.callGetTimeOfDay();

		return tv.tv_sec * 1000L + tv.tv_usec / 1000L;
	}

	private timeval_64 callGetTimeOfDay() {
		timeval_64 tv = new timeval_64();

		// According to the manpage the timezone structure is obsolete and it
		// should always be NULL;
		CLibrary64.INSTANCE.gettimeofday(tv, null);

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
		
		timeval_64 tv = this.callGetTimeOfDay();
		tm_64 result = this.callGetLocaltime_r(new LongByReference(tv.tv_sec));
		
		systemTimeInfo.setDayOfMonth(result.tm_mday);
		systemTimeInfo.setDayOfWeek(result.tm_wday);
		systemTimeInfo.setHour(result.tm_hour);
		systemTimeInfo.setMillisecond((int) (tv.tv_usec / 1000L));
		systemTimeInfo.setMinute(result.tm_min);
		systemTimeInfo.setMonth(result.tm_mon);
		systemTimeInfo.setSecond(result.tm_sec);
		systemTimeInfo.setYear(1900 + result.tm_year);

		return systemTimeInfo;
	}

	private tm_64 callGetLocaltime_r(LongByReference timep) {
		tm_64 resultp = new tm_64();
		
		CLibrary64.INSTANCE.localtime_r(timep, resultp);
		
		return resultp;
	} 
	
	private Map<String, Long> readProcFsMemInfo() throws NumberFormatException, IOException {
		final Map<String, Long> procFsMemInfo = new HashMap<String, Long>();

		procFsProcessor.readProcFs("/proc/meminfo", new ProcFsLineHandler() {
			@Override
			public Boolean processLine(String entry) {
				Matcher matcher = MEMINFO_PATTERN.matcher(entry);
				
				if (matcher.matches()) {
					procFsMemInfo.put(matcher.group(1), Long.valueOf(matcher.group(2)));
				}
				
				return true;
			}});
		
		return procFsMemInfo;
	}
	
	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getFileSystemInfo(java.lang.String)
	 */
	@Override
	public FileSystemInfo getFileSystemInfo(String path) {
		statvfs_64 buf = this.callStatvfs(path);
		
		FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(buf.f_blocks * buf.f_frsize);
		fileSystemInfo.setFreeSpace(buf.f_bavail * buf.f_frsize);

		return fileSystemInfo;
	}
	
	private statvfs_64 callStatvfs(String path) {
		statvfs_64 buf = new statvfs_64();
		
		CLibrary64.INSTANCE.statvfs(path, buf);
		
		return buf;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemArchitectureInfo()
	 */
	@Override
	public SystemArchitectureInfo getSystemArchitectureInfo() {
		final SystemArchitectureInfo systemArchitectureInfo = new SystemArchitectureInfo();
		
		try {
			procFsProcessor.readProcFs("/proc/cpuinfo", new ProcFsLineHandler() {
				@Override
				public Boolean processLine(String line) {
					if (systemArchitectureInfo.getCores() == null) {
						Matcher cpuCoresMatcher = CPU_CORES_PATTERN.matcher(line);
						
						if (cpuCoresMatcher.matches()) {
							systemArchitectureInfo.setCores(Integer.valueOf(cpuCoresMatcher.group(1)));
						}
					}
					
					if (systemArchitectureInfo.getVendorIdentifier() == null) {
						Matcher vendorIdMatcher = VENDOR_ID_PATTERN.matcher(line);
						
						if (vendorIdMatcher.matches()) {
							systemArchitectureInfo.setVendorIdentifier(vendorIdMatcher.group(1));
						}
					}
					
					if (systemArchitectureInfo.isX86_64() == null) {
						Matcher longModeFlagMatcher = LONG_MODE_FLAG_PATTERN.matcher(line);
						
						if (longModeFlagMatcher.matches()) {
							systemArchitectureInfo.setX86_64(true);
						}
					}
					
					return (systemArchitectureInfo.getCores() == null)
						|| (systemArchitectureInfo.getVendorIdentifier() == null)
						|| (systemArchitectureInfo.isX86_64() == null);
				}
			});
		} catch (IOException e) {
			// TODO Handle /proc/cpuinfo access exception
			e.printStackTrace();
		}
		
		if (systemArchitectureInfo.getCores() == null) {
			systemArchitectureInfo.setCores(1);
		}
		
		if (systemArchitectureInfo.isX86_64() == null) {
			systemArchitectureInfo.setX86_64(false);
		}
		
		return systemArchitectureInfo;
	}
}
