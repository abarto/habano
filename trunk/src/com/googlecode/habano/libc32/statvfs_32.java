package com.googlecode.habano.libc32;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * 
 * 32-bit implementation of a structure to contain information about a mounted filesystem.
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
public class statvfs_32 extends Structure {
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
	public int f_blocks;

	/**
	 * <p><code>fsblkcnt_t f_bfree</code></p>
	 * 
	 * # free blocks
	 */
	public int f_bfree;

	/**
	 * <p><code>fsblkcnt_t f_bavail</code></p>
	 * 
	 * # free blocks for non-root
	 */
	public int f_bavail;

	/**
	 * <p><code>fsfilcnt_t f_files</code></p>
	 * 
	 * # inodes
	 */
	public int f_files;

	/**
	 * <p><code>fsfilcnt_t f_ffree</code></p>
	 * 
	 * # free inodes
	 */
	public int f_ffree;

	/**
	 * <p><code>fsfilcnt_t f_favail</code></p>
	 * 
	 * # free inodes for non-root
	 */
	public int f_favail;

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
	 * <p><code>unsigned long f_namemax</code></p>
	 * 
	 * maximum filename length
	 */
	public NativeLong f_namemax;
}
