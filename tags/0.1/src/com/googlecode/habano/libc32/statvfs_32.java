package com.googlecode.habano.libc32;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * 
 * 32-bit implementation of a structure to contain information about a mounted filesystem.
 * 
 * <pre>
 * struct statvfs
 * {
 *   unsigned long int f_bsize;
 *   unsigned long int f_frsize;
 * #ifndef __USE_FILE_OFFSET64
 *   __fsblkcnt_t f_blocks;
 *   __fsblkcnt_t f_bfree;
 *   __fsblkcnt_t f_bavail;
 *   __fsfilcnt_t f_files;
 *   __fsfilcnt_t f_ffree;
 *   __fsfilcnt_t f_favail;
 * #else
 *   __fsblkcnt64_t f_blocks;
 *   __fsblkcnt64_t f_bfree;
 *   __fsblkcnt64_t f_bavail;
 *   __fsfilcnt64_t f_files;
 *   __fsfilcnt64_t f_ffree;
 *   __fsfilcnt64_t f_favail;
 * #endif
 *   unsigned long int f_fsid;
 * #ifdef _STATVFSBUF_F_UNUSED
 *   int __f_unused;
 * #endif
 *   unsigned long int f_flag;
 *   unsigned long int f_namemax;
 *   int __f_spare[6];
 * };
 * </pre>
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://www.opengroup.org/onlinepubs/009695399/basedefs/sys/statvfs.h.html">&lt;sys/statvfs.h&gt;</a>
 */
public class statvfs_32 extends Structure {
	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends statvfs_32 implements Structure.ByValue { }

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
	public static class ByReference extends statvfs_32 implements Structure.ByReference { }
	
	/**
	 * <p><code>unsigned long f_bsize</code></p>
	 * 
	 * file system block size
	 */
	public NativeLong f_bsize;

	/**
	 * <p><code>unsigned long f_frsize</code></p>
	 * 
	 * fragment size
	 */
	public NativeLong f_frsize;

	/**
	 * <p><code>fsblkcnt_t f_blocks</code></p>
	 * 
	 * size of fs in f_frsize units
	 */
	public NativeLong f_blocks;

	/**
	 * <p><code>fsblkcnt_t f_bfree</code></p>
	 * 
	 * # free blocks
	 */
	public NativeLong f_bfree;

	/**
	 * <p><code>fsblkcnt_t f_bavail</code></p>
	 * 
	 * # free blocks for non-root
	 */
	public NativeLong f_bavail;

	/**
	 * <p><code>fsfilcnt_t f_files</code></p>
	 * 
	 * # inodes
	 */
	public NativeLong f_files;

	/**
	 * <p><code>fsfilcnt_t f_ffree</code></p>
	 * 
	 * # free inodes
	 */
	public NativeLong f_ffree;

	/**
	 * <p><code>fsfilcnt_t f_favail</code></p>
	 * 
	 * # free inodes for non-root
	 */
	public NativeLong f_favail;

	/**
	 * <p><code>unsigned long f_fsidl</code></p>
	 * 
	 * file system ID 
	 */
	public NativeLong f_fsid;

	/**
	 * <p><code>unsigned long f_flag</code></p>
	 * 
	 * mount flags
	 */
	public NativeLong f_flag;
	
	/**
	 * <p><code>__f_unused</code></p>
	 */
	public int __f_unused;

	/**
	 * <p><code>unsigned long f_namemax</code></p>
	 * 
	 * maximum filename length
	 */
	public NativeLong f_namemax;
	
	/**
	 * <p><code>int __f_spare[6]</code></p>
	 */
	public int[] __f_spare = new int[6];
}