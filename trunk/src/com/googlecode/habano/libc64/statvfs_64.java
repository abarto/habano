package com.googlecode.habano.libc64;

import com.sun.jna.Structure;

/**
 * 
 * 64-bit implementation of a structure to contain information about a mounted filesystem.
 * 
 * <pre>
 * struct statvfs {
 *   unsigned long f_bsize;
 *   unsigned long f_frsize;
 *   fsblkcnt_t    f_blocks;
 *   fsblkcnt_t    f_bfree;
 *   fsblkcnt_t    f_bavail;
 *   fsfilcnt_t    f_files;
 *   fsfilcnt_t    f_ffree;
 *   fsfilcnt_t    f_favail;
 *   unsigned long f_fsid;
 *   unsigned long f_flag;
 *   unsigned long f_namemax;
 * };
 * </pre>
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://www.opengroup.org/onlinepubs/009695399/basedefs/sys/statvfs.h.html">&lt;sys/statvfs.h&gt;</a>
 */
public class statvfs_64 extends Structure {
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
	public static class ByValue extends statvfs_64 implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends statvfs_64 implements Structure.ByReference { }
	
	/**
	 * <p><code>unsigned long f_bsize</code></p>
	 * 
	 * file system block size
	 */
	public long f_bsize;

	/**
	 * <p><code>unsigned long f_frsize</code></p>
	 * 
	 * fragment size
	 */
	public long f_frsize;

	/**
	 * <p><code>fsblkcnt_t f_blocks</code></p>
	 * 
	 * size of fs in f_frsize units
	 */
	public long f_blocks;

	/**
	 * <p><code>fsblkcnt_t f_bfree</code></p>
	 * 
	 * # free blocks
	 */
	public long f_bfree;

	/**
	 * <p><code>fsblkcnt_t f_bavail</code></p>
	 * 
	 * # free blocks for non-root
	 */
	public long f_bavail;

	/**
	 * <p><code>fsfilcnt_t f_files</code></p>
	 * 
	 * # inodes
	 */
	public long f_files;

	/**
	 * <p><code>fsfilcnt_t f_ffree</code></p>
	 * 
	 * # free inodes
	 */
	public long f_ffree;

	/**
	 * <p><code>fsfilcnt_t f_favail</code></p>
	 * 
	 * # free inodes for non-root
	 */
	public long f_favail;

	/**
	 * <p><code>unsigned long f_fsidl</code></p>
	 * 
	 * file system ID 
	 */
	public long f_fsid;

	/**
	 * <p><code>unsigned long f_flag</code></p>
	 * 
	 * mount flags
	 */
	public long f_flag;

	/**
	 * <p><code>unsigned long f_namemax</code></p>
	 * 
	 * maximum filename length
	 */
	public long f_namemax;
}
