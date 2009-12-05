package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

/**
 * 
 * A class that wraps native calls to <code>advapi32.dll</code> using JNA.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface Advapi32Dll  extends StdCallLibrary {
	/**
	 * The actual object on which to make the method calls.
	 */
	Advapi32Dll INSTANCE = (Advapi32Dll) Native.loadLibrary("advapi32",
			Advapi32Dll.class);
}
