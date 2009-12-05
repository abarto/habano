package com.googlecode.habano.libc64;

import com.sun.jna.Structure;

/**
 * 
 * 64-bit implementation of a structure to contain information about the system
 * timezone.
 * 
 * <em>THIS STRUCTURE IS OBSOLETE AND IT'S NOT INTENDED TO BE USED.</em>
 * 
 * <pre>
 * struct timezone {
 *   int tz_minuteswest;
 *   int tz_dsttime;
 * };
 * </pre>
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://www.gnu.org/s/libc/manual/html_node/High_002dResolution-Calendar.html">High-Resolution Calendar - The GNU C Library</a>
 *
 */
@Deprecated
public class timezone_64 {
	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends timezone_64 implements Structure.ByValue { }

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
	public static class ByReference extends timezone_64 implements Structure.ByReference { }
	
	/**
	 * <p><code>int tz_minuteswest</code></p>
	 * 
	 * Minutes west of Greenwich.
	 */
	public int tz_minuteswest;
	
	/**
	 * <p><code>int tz_dsttime</code></p>
	 * 
	 * Type of DST correction.
	 */
	public int tz_dsttime;
}
