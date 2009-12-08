package com.googlecode.habano.windows32;

import com.sun.jna.Structure;

/**
 * 
 * A structure to represent a registry key handle.
 * 
 * <pre>
 * DECLARE_HANDLE(HKEY);
 * 
 * typedef struct HKEY__{int i;}*HKEY
 * </pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa383751(VS.85).aspx">Windows Data Types (Windows)</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class HKEY extends Structure {
	/**
	 * <p><code>#define HKEY_CLASSES_ROOT ((HKEY)0x80000000)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_CLASSES_ROOT = new HKEY(0x80000000);

	/**
	 * <p><code>#define HKEY_CURRENT_USER ((HKEY)0x80000001)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_CURRENT_USER = new HKEY(0x80000001);

	/**
	 * <p><code>#define HKEY_LOCAL_MACHINE ((HKEY)0x80000002)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_LOCAL_MACHINE = new HKEY(0x80000002);

	/**
	 * <p><code>#define HKEY_USERS ((HKEY)0x80000003)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_USERS = new HKEY(0x80000003);

	/**
	 * <p><code>#define HKEY_PERFORMANCE_DATA ((HKEY)0x80000004)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_PERFORMANCE_DATA = new HKEY(0x80000004);

	/**
	 * <p><code>#define HKEY_CURRENT_CONFIG ((HKEY)0x80000005)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_CURRENT_CONFIG = new HKEY(0x80000005);

	/**
	 * <p><code>#define HKEY_DYN_DATA ((HKEY)0x80000006)</code></p>
	 * 
	 * Predefined HKEY handle.
	 */
	public static final HKEY HKEY_DYN_DATA = new HKEY(0x80000006);
	
	/**
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends HKEY implements Structure.ByValue {
		public ByValue(int i) {
			super(i);
		}
	}

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
	public static class ByReference extends HKEY implements Structure.ByReference {
		public ByReference(int i) {
			super(i);
		}
	}

	/**
	 * A registry key handle.
	 */
	public int i;

	/**
	 * Constructor.
	 * 
	 * @param i The registry key handle.
	 */
	public HKEY(int i) {
		super();
		this.i = i;
	}
}
