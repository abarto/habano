package com.googlecode.habano.systeminfo;

import com.googlecode.habano.systeminfo.beans.FileSystemInfo;
import com.googlecode.habano.systeminfo.beans.MemoryInfo;
import com.googlecode.habano.systeminfo.beans.SystemArchitectureInfo;
import com.googlecode.habano.systeminfo.beans.SystemTimeInfo;
import com.sun.jna.Platform;

/**
 * 
 * A class to access system information regarding date and time, file systems,
 * and memory usage.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public abstract class SystemInfo {
	/**
	 * Creates an instance appropriate for the architecture on which the JVM
	 * is running. It uses {@link com.sun.jna.Platform} services to detect
	 * which instance to create.
	 * 
	 * @return An instance of {@link SystemInfo} specific to the platform on
	 * which the JVM is running.
	 */
	public static SystemInfo newInstance() {
		SystemInfo instance = null;

		if (Platform.isWindows()) {
			if (Platform.is64Bit()) {
				// TODO Implement 64-bit Windows platform support
			} else {
				instance = new SystemInfoWindows32Impl();
			}
		} else if (Platform.isLinux()) {
			if (Platform.is64Bit()) {
				instance = new SystemInfoLinux64Impl();
			} else {
				instance = new SystemInfoLinux32Impl();
			}
		}

		return instance;
	}

	/**
	 * Retrieves memory usage information of the system, including both
	 * physical and virtual memory information.
	 * 
	 * @return {@link MemoryInfo} containing information about the memory of
	 * the system.
	 */
	public abstract MemoryInfo getMemoryInfo();

	/**
	 * Retrieves date and time information of the system, up to the
	 * millisecond.
	 * 
	 * @return @{link SystemTimeInfo} containing the current date and time of
	 * the system up to the millisecond.
	 */
	public abstract SystemTimeInfo getSystemTimeInfo();
	
	/**
	 * Returns the current system time as the number of milliseconds that
	 * passed since midnight, January 1, 1970 UTC (Java Epoch).
	 * 
	 * @return The milliseconds that passed since midnight, January 1, 1970 UTC.
	 * @see System#currentTimeMillis()
	 */
	public abstract long getSystemTimeInMillis();
	
	/**
	 * Retrieves usage information about a file system. 
	 * 
	 * @param path The path on which the filesystem can be accessed. It might
	 * be a mount point ("<code>/home</code>") in Linux/UNIX or a drive name in
	 * Windows ("<code>C:\</code>").
	 * @return {@link FileSystemInfo} containing usage information of the
	 * filesystem accessed through the parameter.
	 */
	public abstract FileSystemInfo getFileSystemInfo(String path);
	
	/**
	 * Retrieves information about the system architecture. This includes the
	 * vendor of the processor, the number of cores, available extensions, etc.
	 * 
	 * @return {@link SystemArchitectureInfo} containing information about
	 * the underlying system architecture.
	 */
	public abstract SystemArchitectureInfo getSystemArchitectureInfo();
}
