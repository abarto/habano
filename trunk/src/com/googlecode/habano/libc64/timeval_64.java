package com.googlecode.habano.libc64;

import com.sun.jna.Structure;

/**
 * 
 * 32-bit implementation of a structure to contain information about the system
 * time.
 * 
 * <pre>
 * struct timeval {
 *   time_t      tv_sec;
 *   suseconds_t tv_usec;
 * };
 * <pre>
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://www.gnu.org/s/libc/manual/html_node/Elapsed-Time.html">Elapsed Time - The GNU C Library</a>
 *
 */
public class timeval_64 extends Structure {
	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends timeval_64 implements Structure.ByValue { }

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
	public static class ByReference extends timeval_64 implements Structure.ByReference { }
	
	/**
	 * <p><code>time_t tv_sec</code></p>
	 * 
	 * seconds
	 */
	public long tv_sec;
	
	/**
	 * <p><code>suseconds_t tv_usec</code></p>
	 * 
	 * microseconds
	 */
	public long tv_usec;
}
