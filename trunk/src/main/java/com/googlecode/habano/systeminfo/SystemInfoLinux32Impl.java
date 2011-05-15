/**
 * 
 */
package com.googlecode.habano.systeminfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.googlecode.habano.libc32.CLibrary32;
import com.googlecode.habano.libc32.statvfs_32;
import com.googlecode.habano.libc32.timeval_32;
import com.googlecode.habano.libc32.tm_32;
import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemArchitectureInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.googlecode.habano.util.ProcFsLineHandler;
import com.googlecode.habano.util.ProcFsProcessor;
import com.sun.jna.ptr.IntByReference;

/**
 * 
 * An implementation of {@link SystemInfo} to be used when the JVM is running
 * on a 32-bit Linux platform. Most of the information is extracted calling
 * the standar c library (libc) functions that are accessed through
 * {@link CLibrary32}. 
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public class SystemInfoLinux32Impl extends SystemInfo {
	/**
	 * /proc entries processor.
	 */
	private static final ProcFsProcessor PROC_FS_PROCESSOR = new ProcFsProcessor();
	
	/** A pattern to extract information from each line of /proc/meminfo. */
	private static final Pattern MEMINFO_PATTERN = Pattern.compile("^(.*):\\s*(\\d+)\\s*(.*)$");
	
	/** A pattern to extract information from /proc/cpuinfo. */
	private static final Pattern CPU_CORES_PATTERN = Pattern.compile("^cpu\\s+cores\\s+:\\s+(\\d+)$");	

	/** A pattern to extract information from /proc/cpuinfo. */
	private static final Pattern VENDOR_ID_PATTERN = Pattern.compile("^vendor_id\\s+:\\s+(\\w+)$");	

	/** A pattern to extract information from /proc/cpuinfo. */
	private static final Pattern LONG_MODE_FLAG_PATTERN = Pattern.compile("^flags\\s+:.*\\blm\\b?.*$");	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getMemoryInfo()
	 */
	@Override
	public MemoryInfo getMemoryInfo() {
		final MemoryInfo memoryInfo = new MemoryInfo();
		
		try {
			final Map<String, Long> memInfo = this.readProcFsMemInfo();
			
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
		final timeval_32 tv = this.callGetTimeOfDay();

		return tv.tv_sec * 1000L + tv.tv_usec / 1000L;
	}

	/**
	 * Call get time of day.
	 *
	 * @return the timeval_32
	 */
	private timeval_32 callGetTimeOfDay() {
		final timeval_32 tv = new timeval_32();

		// According to the manpage the timezone structure is obsolete and it
		// should always be NULL;
		CLibrary32.INSTANCE.gettimeofday(tv, null);

		return tv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemTimeInfo()
	 */
	@Override
	public SystemTimeInfo getSystemTimeInfo() {
		final SystemTimeInfo systemTimeInfo = new SystemTimeInfo();
		
		final timeval_32 tv = this.callGetTimeOfDay();
		final tm_32 result = this.callGetLocaltime_r(new IntByReference(tv.tv_sec));
		
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

	/**
	 * Call get localtime_r.
	 *
	 * @param timep the timep
	 * @return the tm_32
	 */
	private tm_32 callGetLocaltime_r(final IntByReference timep) {
		final tm_32 resultp = new tm_32();
		
		CLibrary32.INSTANCE.localtime_r(timep, resultp);
		
		return resultp;
	} 
	
	/**
	 * Read proc fs mem info.
	 *
	 * @return the map
	 * @throws NumberFormatException the number format exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private Map<String, Long> readProcFsMemInfo() throws NumberFormatException, IOException {
		final Map<String, Long> procFsMemInfo = new HashMap<String, Long>();
		
		PROC_FS_PROCESSOR.readProcFs("/proc/meminfo", new ProcFsLineHandler() {
			@Override
			public Boolean processLine(final String entry) {
				final Matcher matcher = MEMINFO_PATTERN.matcher(entry);
				
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
	public FileSystemInfo getFileSystemInfo(final String path) {
		final statvfs_32 buf = this.callStatvfs(path);
		
		final FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(buf.f_blocks.longValue() * buf.f_frsize.longValue());
		fileSystemInfo.setFreeSpace(buf.f_bavail.longValue() * buf.f_frsize.longValue());

		return fileSystemInfo;
	}
	
	/**
	 * Call statvfs.
	 *
	 * @param path the path
	 * @return the statvfs_32
	 */
	private statvfs_32 callStatvfs(final String path) {
		final statvfs_32 buf = new statvfs_32();
		
		CLibrary32.INSTANCE.statvfs(path, buf);
		
		return buf;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemArchitectureInfo()
	 */
	@Override
	public SystemArchitectureInfo getSystemArchitectureInfo() {
		final SystemArchitectureInfo systemArchitectureInfo = new SystemArchitectureInfo();
		
		try {
			PROC_FS_PROCESSOR.readProcFs("/proc/cpuinfo", new ProcFsLineHandler() {
				@Override
				public Boolean processLine(final String line) {
					if (systemArchitectureInfo.getCores() == null) {
						final Matcher cpuCoresMatcher = CPU_CORES_PATTERN.matcher(line);
						
						if (cpuCoresMatcher.matches()) {
							systemArchitectureInfo.setCores(Integer.valueOf(cpuCoresMatcher.group(1)));
						}
					}
					
					if (systemArchitectureInfo.getVendorIdentifier() == null) {
						final Matcher vendorIdMatcher = VENDOR_ID_PATTERN.matcher(line);
						
						if (vendorIdMatcher.matches()) {
							systemArchitectureInfo.setVendorIdentifier(vendorIdMatcher.group(1));
						}
					}
					
					if (systemArchitectureInfo.getX8664() == null) {
						final Matcher longModeFlagMatcher = LONG_MODE_FLAG_PATTERN.matcher(line);
						
						if (longModeFlagMatcher.matches()) {
							systemArchitectureInfo.setX8664(true);
						}
					}
					
					return (systemArchitectureInfo.getCores() == null)
						|| (systemArchitectureInfo.getVendorIdentifier() == null)
						|| (systemArchitectureInfo.getX8664() == null);
				}
			});
		} catch (IOException e) {
			// TODO Handle /proc/cpuinfo access exception
			e.printStackTrace();
		}
		
		if (systemArchitectureInfo.getCores() == null) {
			systemArchitectureInfo.setCores(1);
		}
		
		if (systemArchitectureInfo.getX8664() == null) {
			systemArchitectureInfo.setX8664(false);
		}
		
		return systemArchitectureInfo;
	}
}
