package com.googlecode.habano.libc;

import com.sun.jna.Structure;

/**
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class timezone {
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
	public static class ByValue extends timezone implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends timezone implements Structure.ByReference { }
	
	/**
	 * 
	 */
	public int tz_minuteswest;
	
	/**
	 * 
	 */
	public int tz_dsttime;
}
