package com.googlecode.habano.systeminfo;

import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.googlecode.habano.windows32.FILETIME;
import com.googlecode.habano.windows32.Kernel32Dll;
import com.googlecode.habano.windows32.MEMORYSTATUSEX;
import com.googlecode.habano.windows32.SYSTEMTIME;
import com.googlecode.habano.windows32.ULARGE_INTEGER;
import com.sun.jna.Native;

/**
 * 
 * An implementation of {@link SystemInfo} to be used when the JVM is running
 * on a 32-bit Windows platform. Most of the information is extracted calling
 * kernel32.dll functions that are accessed through {@link Kernel32Dll}. 
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
class SystemInfoWindows32Impl extends SystemInfo {
	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getMemoryInfo()
	 */
	@Override
	public MemoryInfo getMemoryInfo() {
		MEMORYSTATUSEX lpBuffer = this.callGlobalMemoryStatusEx();

		MemoryInfo memoryInfo = new MemoryInfo();
		memoryInfo.setAvailableSystemMemory(lpBuffer.ullAvailPhys);
		memoryInfo.setAvailableVirtualMemory(lpBuffer.ullAvailVirtual);
		memoryInfo.setTotalSystemMemory(lpBuffer.ullTotalPhys);
		memoryInfo.setTotalVirtualMemory(lpBuffer.ullTotalVirtual);

		return memoryInfo;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemTimeInfo()
	 */
	@Override
	public SystemTimeInfo getSystemTimeInfo() {
		SYSTEMTIME lpSystemTime = this.callGetSystemTime();

		SystemTimeInfo systemTimeInfo = new SystemTimeInfo();
		systemTimeInfo.setDayOfMonth(Integer.valueOf(lpSystemTime.wDay));
		systemTimeInfo.setDayOfWeek(Integer.valueOf(lpSystemTime.wDayOfWeek));
		systemTimeInfo.setHour(Integer.valueOf(lpSystemTime.wHour));
		systemTimeInfo.setMillisecond(Integer.valueOf(lpSystemTime.wMilliseconds));
		systemTimeInfo.setMinute(Integer.valueOf(lpSystemTime.wMinute));
		systemTimeInfo.setMonth(Integer.valueOf(lpSystemTime.wMonth - 1));
		systemTimeInfo.setSecond(Integer.valueOf(lpSystemTime.wSecond));
		systemTimeInfo.setYear(Integer.valueOf(lpSystemTime.wYear));
		
		return systemTimeInfo;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemTimeInMillis()
	 */
	@Override
	public long getSystemTimeInMillis() {
		FILETIME lpSystemTimeAsFileTime = this.callGetSystemTimeAsFileTime();
		
		// convert the FILETIME structure into an 64-bit integer and substract
		// the difference between FILETIME's epoch and Java's epoch.
		return ((((long) lpSystemTimeAsFileTime.dwHighDateTime) << 32 | (lpSystemTimeAsFileTime.dwLowDateTime & 0xFFFFFFFFL)) / 10000L) - 11644473600000L;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getFileSystemInfo(java.lang.String)
	 */
	@Override
	public FileSystemInfo getFileSystemInfo(String path) {
		ULARGE_INTEGER lpFreeBytesAvailable = new ULARGE_INTEGER();
		lpFreeBytesAvailable.setType(Long.class); // select QuadPart
		
		ULARGE_INTEGER lpTotalNumberOfBytes = new ULARGE_INTEGER();
		lpTotalNumberOfBytes.setType(Long.class); // select QuadPart
		
		ULARGE_INTEGER lpTotalNumberOfFreeBytes = new ULARGE_INTEGER();
		lpTotalNumberOfBytes.setType(Long.class); // select QuadPart
		
		Kernel32Dll.INSTANCE.GetDiskFreeSpaceExA(path, lpFreeBytesAvailable, lpTotalNumberOfBytes, lpTotalNumberOfFreeBytes);
		
		FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(lpTotalNumberOfBytes.QuadPart);
		fileSystemInfo.setFreeSpace(lpTotalNumberOfFreeBytes.QuadPart);
		
		return fileSystemInfo;
	}
	
	private MEMORYSTATUSEX callGlobalMemoryStatusEx() {
		// Prepare the MEMORYSTATUSEX structure
		
		MEMORYSTATUSEX lpBuffer = new MEMORYSTATUSEX();

		// sizeof(MEMORYSTATUSEX)
		lpBuffer.dwLength = Native.getNativeSize(MEMORYSTATUSEX.ByValue.class);

		// Call GlobalMemoryStatusEx on kernel32.dll
		Kernel32Dll.INSTANCE.GlobalMemoryStatusEx(lpBuffer);
		
		return lpBuffer;
	}
	
	private SYSTEMTIME callGetSystemTime() {
		SYSTEMTIME lpSystemTime = new SYSTEMTIME();
		
		// Call GetSystemTime on kernel32.dll
		Kernel32Dll.INSTANCE.GetSystemTime(lpSystemTime);
		
		return lpSystemTime;
	}
	
	private FILETIME callGetSystemTimeAsFileTime() {
		FILETIME lpSystemTimeAsFileTime = new FILETIME();
		
		Kernel32Dll.INSTANCE.GetSystemTimeAsFileTime(lpSystemTimeAsFileTime);
		
		return lpSystemTimeAsFileTime;
	}
}
