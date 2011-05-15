package com.googlecode.habano.systeminfo;

import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemArchitectureInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.googlecode.habano.windows32.Advapi32Dll;
import com.googlecode.habano.windows32.FILETIME;
import com.googlecode.habano.windows32.HKEY;
import com.googlecode.habano.windows32.Kernel32Dll;
import com.googlecode.habano.windows32.MEMORYSTATUSEX;
import com.googlecode.habano.windows32.REGSAM;
import com.googlecode.habano.windows32.SYSTEMTIME;
import com.googlecode.habano.windows32.SYSTEM_INFO;
import com.googlecode.habano.windows32.ULARGE_INTEGER;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;

/**
 * 
 * An implementation of {@link SystemInfo} to be used when the JVM is running
 * on a 32-bit Windows platform. Most of the information is extracted calling
 * kernel32.dll and advapi32.dll functions that are accessed through
 * {@link Kernel32Dll} and {@link Advapi32Dll}. 
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
class SystemInfoWindows32Impl extends SystemInfo {
	/**
	 * An error code for a successful call to a Windows function.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms681381%28VS.85%29.aspx">System Error Codes (Windows)</a>
	 */
	private static final NativeLong ERROR_SUCCESS = new NativeLong(0L);
	
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

		WString lpDirectoryName = new WString(path);
		
		Kernel32Dll.INSTANCE.GetDiskFreeSpaceExW(lpDirectoryName, lpFreeBytesAvailable, lpTotalNumberOfBytes, lpTotalNumberOfFreeBytes);
		
		FileSystemInfo fileSystemInfo = new FileSystemInfo();
		fileSystemInfo.setPath(path);
		fileSystemInfo.setSize(lpTotalNumberOfBytes.QuadPart);
		fileSystemInfo.setFreeSpace(lpTotalNumberOfFreeBytes.QuadPart);
		
		return fileSystemInfo;
	}
	
	/**
	 * Call global memory status ex.
	 *
	 * @return the mEMORYSTATUSEX
	 */
	private MEMORYSTATUSEX callGlobalMemoryStatusEx() {
		// Prepare the MEMORYSTATUSEX structure
		
		MEMORYSTATUSEX lpBuffer = new MEMORYSTATUSEX();

		// sizeof(MEMORYSTATUSEX)
		lpBuffer.dwLength = Native.getNativeSize(MEMORYSTATUSEX.ByValue.class);

		// Call GlobalMemoryStatusEx on kernel32.dll
		Kernel32Dll.INSTANCE.GlobalMemoryStatusEx(lpBuffer);
		
		return lpBuffer;
	}
	
	/**
	 * Call get system time.
	 *
	 * @return the sYSTEMTIME
	 */
	private SYSTEMTIME callGetSystemTime() {
		SYSTEMTIME lpSystemTime = new SYSTEMTIME();
		
		// Call GetSystemTime on kernel32.dll
		Kernel32Dll.INSTANCE.GetSystemTime(lpSystemTime);
		
		return lpSystemTime;
	}
	
	/**
	 * Call get system time as file time.
	 *
	 * @return the fILETIME
	 */
	private FILETIME callGetSystemTimeAsFileTime() {
		FILETIME lpSystemTimeAsFileTime = new FILETIME();
		
		Kernel32Dll.INSTANCE.GetSystemTimeAsFileTime(lpSystemTimeAsFileTime);
		
		return lpSystemTimeAsFileTime;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.systeminfo.SystemInfo#getSystemArchitectureInfo()
	 */
	@Override
	public SystemArchitectureInfo getSystemArchitectureInfo() {
		SystemArchitectureInfo systemArchitectureInfo = new SystemArchitectureInfo();
		
		SYSTEM_INFO lpSystemInfo = this.callGetSystenInfo();
		
		systemArchitectureInfo.setCores(lpSystemInfo.dwNumberOfProcessors);
		systemArchitectureInfo.setX86_64(lpSystemInfo.unnamedUnion.unnamedStructure.wProcessorArchitecture == 9);
		
		char[] lpSubKey = Native.toCharArray("HARDWARE\\DESCRIPTION\\System\\CentralProcessor\\0");
		int ulOptions = 0;
		int samDesired = REGSAM.KEY_READ;
		IntByReference phkResult = new IntByReference();

		NativeLong regOpenKeyExW = Advapi32Dll.INSTANCE.RegOpenKeyExW(
				HKEY.HKEY_LOCAL_MACHINE,
				lpSubKey,
				ulOptions,
				samDesired,
				phkResult);
		
		if (ERROR_SUCCESS.equals(regOpenKeyExW)) {
			char[] lpValueName = Native.toCharArray("VendorIdentifier");
			IntByReference lpType = new IntByReference();
			char[] lpData = new char[32768];
			IntByReference lpcbData = new IntByReference(lpData.length);
	
			NativeLong regQueryValueExW = Advapi32Dll.INSTANCE.RegQueryValueExW(
					phkResult.getValue(),
					lpValueName,
					null, // lpReserved
					lpType,
					lpData,
					lpcbData);
			
			if (ERROR_SUCCESS.equals(regQueryValueExW)) {
				String vendorIdentifier = Native.toString(lpData).trim();

				systemArchitectureInfo.setVendorIdentifier(vendorIdentifier);
			} else {
				// TODO Handle error enumerating a registry key value 
			}
			
			NativeLong regCloseKey = Advapi32Dll.INSTANCE.RegCloseKey(phkResult.getValue());
			
			if (!ERROR_SUCCESS.equals(regCloseKey)) {
				// TODO Handle error closing a registry key handle
			}
		} else {
			// TODO Handle error opening a registry key
		}
 
		return systemArchitectureInfo;
	}
	
	/**
	 * Call get systen info.
	 *
	 * @return the sYSTE m_ info
	 */
	private SYSTEM_INFO callGetSystenInfo() {
		SYSTEM_INFO lpSystemInfo = new SYSTEM_INFO();
		
		lpSystemInfo.unnamedUnion.setType(SYSTEM_INFO.UnnamedUnion.UnnamedStructure.class);
		
		Kernel32Dll.INSTANCE.GetSystemInfo(lpSystemInfo);
		
		return lpSystemInfo;
	}	
}
