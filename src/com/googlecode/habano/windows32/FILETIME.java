package com.googlecode.habano.windows32;

import com.sun.jna.Structure;

/**
 * 
 * Contains a 64-bit value representing the number of 100-nanosecond intervals
 * since January 1, 1601 (UTC).
 * 
 * <pre>
 * typedef struct _FILETIME {
 *   DWORD dwLowDateTime;
 *   DWORD dwHighDateTime;
 * } FILETIME, *PFILETIME;
 * </pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724284%28VS.85%29.aspx">FILETIME Structure (Windows)</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class FILETIME extends Structure {
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
	public static class ByValue extends FILETIME implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends FILETIME implements Structure.ByReference { }
	
	/**
	 * <p><code>DWORD dwLowDateTime</code></p>
	 * 
	 * The low-order part of the file time.
	 */
	public int dwLowDateTime;
	
	/**
	 * <p><code>DWORD dwHighDateTime</code></p>
	 * 
	 * The high-order part of the file time.
	 */
	public int dwHighDateTime;
}
