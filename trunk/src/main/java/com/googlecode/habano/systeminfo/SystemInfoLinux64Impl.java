/**
 * 
 */
package com.googlecode.habano.systeminfo;

import java.io.IOException;
import java.util.Arrays;

import com.googlecode.habano.libc64.CLibrary64;
import com.googlecode.habano.libc64.statvfs_64;
import com.googlecode.habano.libc64.timeval_64;
import com.googlecode.habano.libc64.tm_64;
import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemArchitectureInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.googlecode.habano.util.DefaultCpuInfoHandler;
import com.googlecode.habano.util.DefaultMemInfoHandler;
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
	private static final ProcFsProcessor PROC_FS_PROCESSOR = new ProcFsProcessor();

	/** The Constant LM. */
	private static final String LM = "lm";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getMemoryInfo()
	 */
	@Override
	public MemoryInfo getMemoryInfo() {
		final MemoryInfo memoryInfo = new MemoryInfo();
		
		try {
			PROC_FS_PROCESSOR.readMemInfo(new DefaultMemInfoHandler() {
				@Override
				public Boolean handleMemTotal(Long value) {
					memoryInfo.setTotalSystemMemory(value * 1000L);

					return (memoryInfo.getAvailableSystemMemory() == null)
						|| (memoryInfo.getAvailableVirtualMemory() == null)
						|| (memoryInfo.getTotalVirtualMemory() == null);
				}

				@Override
				public Boolean handleMemFree(Long value) {
					memoryInfo.setAvailableSystemMemory(value * 1000L);
					
					return (memoryInfo.getAvailableVirtualMemory() == null)
					|| (memoryInfo.getTotalSystemMemory() == null)
					|| (memoryInfo.getTotalVirtualMemory() == null);
				}

				@Override
				public Boolean handleSwapTotal(Long value) {
					memoryInfo.setTotalVirtualMemory(value * 1000L);
					
					return (memoryInfo.getAvailableSystemMemory() == null)
					|| (memoryInfo.getAvailableVirtualMemory() == null)
					|| (memoryInfo.getTotalSystemMemory() == null);
				}

				@Override
				public Boolean handleSwapFree(Long value) {
					memoryInfo.setAvailableVirtualMemory(value * 1000L);
					
					return (memoryInfo.getAvailableSystemMemory() == null)
					|| (memoryInfo.getTotalSystemMemory() == null)
					|| (memoryInfo.getTotalVirtualMemory() == null);
				}
			});
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
		final timeval_64 tv = this.callGetTimeOfDay();

		return tv.tv_sec * 1000L + tv.tv_usec / 1000L;
	}

	/**
	 * Call get time of day.
	 *
	 * @return the timeval_64
	 */
	private timeval_64 callGetTimeOfDay() {
		final timeval_64 tv = new timeval_64();

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
		final SystemTimeInfo systemTimeInfo = new SystemTimeInfo();
		
		final timeval_64 tv = this.callGetTimeOfDay();
		final tm_64 result = this.callGetLocaltime_r(new LongByReference(tv.tv_sec));
		
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

	/**
	 * Call get localtime_r.
	 *
	 * @param timep the timep
	 * @return the tm_64
	 */
	private tm_64 callGetLocaltime_r(final LongByReference timep) {
		final tm_64 resultp = new tm_64();
		
		CLibrary64.INSTANCE.localtime_r(timep, resultp);
		
		return resultp;
	} 
		
	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getFileSystemInfo(java.lang.String)
	 */
	@Override
	public FileSystemInfo getFileSystemInfo(final String path) {
		final statvfs_64 buf = this.callStatvfs(path);
		
		final FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(buf.f_blocks * buf.f_frsize);
		fileSystemInfo.setFreeSpace(buf.f_bavail * buf.f_frsize);

		return fileSystemInfo;
	}
	
	/**
	 * Call statvfs.
	 *
	 * @param path the path
	 * @return the statvfs_64
	 */
	private statvfs_64 callStatvfs(final String path) {
		final statvfs_64 buf = new statvfs_64();
		
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
			PROC_FS_PROCESSOR.readCpuInfo(new DefaultCpuInfoHandler() {
				@Override
				public Boolean handleVendorId(String value) {
					systemArchitectureInfo.setVendorIdentifier(value);
					
					return (systemArchitectureInfo.getCores() == null)
						|| (systemArchitectureInfo.getX8664() == null);
				}

				@Override
				public Boolean handleCpuCores(Integer value) {
					systemArchitectureInfo.setCores(value);
					
					return (systemArchitectureInfo.getVendorIdentifier() == null)
					|| (systemArchitectureInfo.getX8664() == null);
				}

				@Override
				public Boolean handleFlags(String[] value) {
					systemArchitectureInfo.setX8664(Arrays.asList(value).contains(LM));
					
					return (systemArchitectureInfo.getCores() == null)
					|| (systemArchitectureInfo.getVendorIdentifier() == null);
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
