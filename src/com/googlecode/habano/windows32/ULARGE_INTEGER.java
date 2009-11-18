package com.googlecode.habano.windows32;

import com.sun.jna.Structure;
import com.sun.jna.Union;

/**
 * 
 * The ULARGE_INTEGER structure is used to specify a 64-bit unsigned integer value.
 * 
 * <pre>
 * typedef union _ULARGE_INTEGER {
 *   struct {
 *     DWORD LowPart;
 *     DWORD HighPart;
 *   } ;
 *   struct {
 *     DWORD LowPart;
 *     DWORD HighPart;
 *   } u;
 *   ULONGLONG QuadPart;
 * } ULARGE_INTEGER, *PULARGE_INTEGER;
 * </pre>
 * 
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa383742%28VS.85%29.aspx">ULARGE_INTEGER Union (Windows)</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class ULARGE_INTEGER extends Union {
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
	public static class ByValue extends ULARGE_INTEGER implements Union.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByReference extends ULARGE_INTEGER implements Union.ByReference { }

	/**
	 * 
	 * A structure to represent a 64-bit integer as a double word, as defined
	 * within the _ULARGE_INTEGER union.
	 * 
     * @see <a href="http://msdn.microsoft.com/en-us/library/aa383742%28VS.85%29.aspx">ULARGE_INTEGER Union (Windows)</a>
     * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class DoubleWord extends Structure {
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
		public static class ByValue extends DoubleWord implements Structure.ByValue { }

		/**
		 * 
		 * Tagged inner class to indicate the value of an instance of the Structure
		 * type is to be used in function invocations rather than its address.
		 * 
		 * @see Structure.ByValue
		 * @author Agustin Barto <abarto@gmail.com>
		 *
		 */
		public static class ByReference extends DoubleWord implements Structure.ByReference { }
		
		
		/**
		 * <p><code>DWORD LowPart</code></p>
		 * 
		 * Low-order 32 bits.
		 */
		public int LowPart;
		
		/**
		 * <p><code>DWORD HighPart</code></p>
		 * 
		 * High-order 32 bits.
		 */
		public int HighPart;
		
		/**
		 * @return The 64-bit integer represented by the structure.
		 */
		public long asLong() {
			return (long) HighPart << 32 | (LowPart & 0xFFFFFFFFL);
		}
	}
	
	/**
	 * Unnamed structure defined within the _ULARGE_INTEGER union.
	 */
	public DoubleWord unnamedStruct = new DoubleWord.ByValue();
	
	/**
	 * u field within the _ULARGE_INTEGER union. I don't know what this field
	 * is used for.
	 */
	public DoubleWord u = new DoubleWord.ByValue();
	
	/**
	 * <p><code>ULONGLONG QuadPart</code></p>
	 * 
	 * Unsigned 64-bit integer.
	 */
	public Long QuadPart;
}
