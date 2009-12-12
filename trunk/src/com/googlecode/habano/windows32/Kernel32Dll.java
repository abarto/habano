package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.WString;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * 
 * A class that wraps native calls to <code>kernel32.dll</code> using JNA.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public interface Kernel32Dll extends StdCallLibrary {
	/**
	 * The actual object on which to make the method calls.
	 */
	Kernel32Dll INSTANCE = (Kernel32Dll) Native.loadLibrary("kernel32",
			Kernel32Dll.class);

	/**
	 * Retrieves information about the system's current usage of both physical
	 * and virtual memory.
	 * 
	 * @param lpBuffer A pointer to a {@link MEMORYSTATUSEX} structure that
	 * receives information about current memory availability.
	 * @return If the function succeeds, the return value is nonzero. If the
	 * function fails, the return value is zero.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa366589%28VS.85%29.aspx">GlobalMemoryStatusEx Function (Windows)</a>
	 */
	boolean GlobalMemoryStatusEx(MEMORYSTATUSEX lpBuffer);

	/**
	 * Retrieves the current system date and time. The system time is expressed
	 * in Coordinated Universal Time (UTC).
	 * 
	 * @param lpSystemTime A pointer to a {@link SYSTEMTIME} structure to
	 * receive the current system date and time. The lpSystemTime parameter
	 * must not be NULL. Using NULL will result in an access violation.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724390%28VS.85%29.aspx">GetSystemTime Function (Windows)</a>
	 */
	void GetSystemTime(SYSTEMTIME lpSystemTime);

	/**
	 * Retrieves the current system date and time. The information is in
	 * Coordinated Universal Time (UTC) format.
	 * 
	 * @param lpSystemTimeAsFileTime A pointer to a {@link FILETIME} structure
	 * to receive the current system date and time in UTC format.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724397%28VS.85%29.aspx">GetSystemTimeAsFileTime Function (Windows)</a>
	 */
	void GetSystemTimeAsFileTime(FILETIME lpSystemTimeAsFileTime);

	/**
	 * Retrieves information about the amount of space that is available on a
	 * disk volume, which is the total amount of space, the total amount of
	 * free space, and the total amount of free space available to the user
	 * that is associated with the calling thread.
	 * 
	 * @param lpDirectoryName A directory on the disk.
	 * <ul>
     *   <li>If this parameter is NULL, the function uses the root of the
     *   current disk.</li>
     *   <li>If this parameter is a UNC name, it must include a trailing
     *   backslash, for example, "\\MyServer\MyShare\".</li>
     *   <li>This parameter does not have to specify the root directory on a
     *   disk. The function accepts any directory on a disk.</li>
     *   <li>The calling application must have FILE_LIST_DIRECTORY access
     *   rights for this directory.</li>
     * </ul>
	 * @param lpFreeBytesAvailable A pointer to a variable that receives the
	 * total number of free bytes on a disk that are available to the user who
	 * is associated with the calling thread.
     * <ul>
     *   <li>This parameter can be NULL.</li>
     *   <li>If per-user quotas are being used, this value may be less than the
     *   total number of free bytes on a disk.</li>
     * </ul>
	 * @param lpTotalNumberOfBytes A pointer to a variable that receives the
	 * total number of bytes on a disk that are available to the user who is
	 * associated with the calling thread.
	 * <ul>
	 *   <li>This parameter can be NULL.</li>
	 *   <li>If per-user quotas are being used, this value may be less than the
	 *   total number of bytes on a disk.</li>
	 *   <li>To determine the total number of bytes on a disk or volume, use
	 *   <a href="http://msdn.microsoft.com/en-us/library/aa365178%28VS.85%29.aspx">IOCTL_DISK_GET_LENGTH_INFO</a>.</li>
	 * </ul>
	 * @param lpTotalNumberOfFreeBytes A pointer to a variable that receives
	 * the total number of free bytes on a disk.
	 * <ul>
	 *   <li>This parameter can be NULL.</li>
	 * </ul>
	 * @return If the function succeeds, the return value is nonzero. If the
	 * function fails, the return value is zero (0).
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa364937%28VS.85%29.aspx">GetDiskFreeSpaceEx Function (Windows)</a>
	 */
	boolean GetDiskFreeSpaceExW(WString lpDirectoryName,
			ULARGE_INTEGER lpFreeBytesAvailable,
			ULARGE_INTEGER lpTotalNumberOfBytes,
			ULARGE_INTEGER lpTotalNumberOfFreeBytes);
	
	/**
	 * An alternative way to reference GetDiskFreeSpaceEx using __int64
	 * pointers.
	 * 
	 * @see #GetDiskFreeSpaceExW(WString, ULARGE_INTEGER, ULARGE_INTEGER, ULARGE_INTEGER)
	 */
	boolean GetDiskFreeSpaceExW(WString lpDirectoryName,
			LongByReference lpFreeBytesAvailable,
			LongByReference lpTotalNumberOfBytes,
			LongByReference lpTotalNumberOfFreeBytes);
	
	/**
	 * Retrieves information about the current system. To retrieve accurate
	 * information for an application running on WOW64, call the
	 * GetNativeSystemInfo function.
	 * 
	 * @param lpSystemInfo A pointer to a SYSTEM_INFO structure that receives
	 * the information.
	 */
	void GetSystemInfo(SYSTEM_INFO lpSystemInfo);
}
