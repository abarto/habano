package com.googlecode.habano.windows32;

import com.sun.jna.Structure;

/**
 * 
 * Contains information about the current state of both physical and virtual
 * memory, including extended memory. The GlobalMemoryStatusEx function stores
 * information in this structure.
 *
 * <pre>
 * typedef struct _MEMORYSTATUSEX {
 *   DWORD     dwLength;
 *   DWORD     dwMemoryLoad;
 *   DWORDLONG ullTotalPhys;
 *   DWORDLONG ullAvailPhys;
 *   DWORDLONG ullTotalPageFile;
 *   DWORDLONG ullAvailPageFile;
 *   DWORDLONG ullTotalVirtual;
 *   DWORDLONG ullAvailVirtual;
 *   DWORDLONG ullAvailExtendedVirtual;
 * } MEMORYSTATUSEX, *LPMEMORYSTATUSEX;
 * </pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa366770%28VS.85%29.aspx">MEMORYSTATUSEX Structure (Windows)</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class MEMORYSTATUSEX extends Structure {
	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends MEMORYSTATUSEX implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the address of an instance of the
	 * Structure type is to be used within a Structure definition rather than
	 * nesting the full Structure contents.
	 * 
	 * @see Structure.ByReference
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends MEMORYSTATUSEX implements Structure.ByReference { }
	
    /**
     * <p><code>DWORD dwLength</code></p>
     * 
     * The size of the structure, in bytes. You must set this member before
     * calling GlobalMemoryStatusEx.
     */
    public int dwLength;

    /**
     * <p><code>DWORD dwMemoryLoad</code></p>
     * 
     * A number between 0 and 100 that specifies the approximate percentage of
     * physical memory that is in use (0 indicates no memory use and 100
     * indicates full memory use).
     */
    public int dwMemoryLoad;

    /**
     * <p><code>DWORDLONG ullTotalPhys</code></p>
     * 
     * The amount of actual physical memory, in bytes.
     */
    public long ullTotalPhys;

    /**
     * <p><code>DWORDLONG ullAvailPhys</code></p>
     * 
     * The amount of physical memory currently available, in bytes. This is the
     * amount of physical memory that can be immediately reused without having
     * to write its contents to disk first. It is the sum of the size of the
     * standby, free, and zero lists.
     */
    public long ullAvailPhys;

    /**
     * <p><code>DWORDLONG ullTotalPageFile</code></p>
     * 
     * The current committed memory limit for the system or the current
     * process, whichever is smaller, in bytes.
     */
    public long ullTotalPageFile;

    /**
     * <p><code>DWORDLONG ullAvailPageFile</code></p>
     * 
     * The maximum amount of memory the current process can commit, in bytes.
     * This value is equal to or smaller than the system-wide available commit
     * value.
     */
    public long ullAvailPageFile;

    /**
     * <p><code>DWORDLONG ullTotalVirtual</code></p>
     * 
     * The size of the user-mode portion of the virtual address space of the
     * calling process, in bytes. This value depends on the type of process,
     * the type of processor, and the configuration of the operating system.
     * For example, this value is approximately 2 GB for most 32-bit processes
     * on an x86 processor and approximately 3 GB for 32-bit processes that are
     * large address aware running on a system with 4-gigabyte tuning enabled.
     */
    public long ullTotalVirtual;

    /**
     * <p><code>DWORDLONG ullAvailVirtual</code></p>
     * 
     * The amount of unreserved and uncommitted memory currently in the
     * user-mode portion of the virtual address space of the calling process,
     * in bytes.
     */
    public long ullAvailVirtual;

    /**
     * <p><code>DWORDLONG ullAvailExtendedVirtual</code></p>
     * 
     * Reserved. This value is always 0.
     */
    public long ullAvailExtendedVirtual;
}
