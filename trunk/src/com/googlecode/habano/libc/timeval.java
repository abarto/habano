package com.googlecode.habano.libc;

import com.sun.jna.Structure;

/**
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class timeval extends Structure {
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
	public static class ByValue extends timeval implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends timeval implements Structure.ByReference { }
	
	/**
	 * 
	 */
	public int tv_sec;
	
	/**
	 * 
	 */
	public int tv_usec;
}
