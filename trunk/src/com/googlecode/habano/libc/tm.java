package com.googlecode.habano.libc;

import com.sun.jna.Structure;

/**
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class tm extends Structure {
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
	public static class ByValue extends tm implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends tm implements Structure.ByReference { }
	
	/**
	 * 
	 */
	public int tm_sec;

	/**
	 * 
	 */
	public int tm_min;

	/**
	 * 
	 */
	public int tm_hour;

	/**
	 * 
	 */
	public int tm_mday;

	/**
	 * 
	 */
	public int tm_mon;

	/**
	 * 
	 */
	public int tm_year;

	/**
	 * 
	 */
	public int tm_wday;

	/**
	 * 
	 */
	public int tm_yday;

	/**
	 * 
	 */
	public int tm_isdst;
}
