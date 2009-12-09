package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

/**
 * 
 * A class that wraps native calls to <code>advapi32.dll</code> using JNA.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa383751(VS.85).aspx">Windows Data Types (Windows)</a>
 *
 */
public interface Advapi32Dll  extends StdCallLibrary {
	// REGSAM values
	
	
	/**
	 * The actual object on which to make the method calls.
	 */
	Advapi32Dll INSTANCE = (Advapi32Dll) Native.loadLibrary("advapi32",
			Advapi32Dll.class);
	
	/**
	 * Opens the specified registry key. Note that key names are not case
	 * sensitive. To perform transacted registry operations on a key, call the
	 * RegOpenKeyTransacted function.
	 * 
	 * <pre>
	 * LONG WINAPI RegOpenKeyEx(
	 *   __in        HKEY hKey,
	 *   __in_opt    LPCTSTR lpSubKey,
	 *   __reserved  DWORD ulOptions,
	 *   __in        REGSAM samDesired,
	 *   __out       PHKEY phkResult
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to an open registry key. This handle is returned by
	 * the RegCreateKeyEx or RegOpenKeyEx function, or it can be one of the
	 * following predefined keys: HKEY_CLASSES_ROOT, HKEY_CURRENT_USER,
	 * HKEY_LOCAL_MACHINE, HKEY_USERS.
	 * @param lpSubKey The name of the registry subkey to be opened. Key names
	 * are not case sensitive. If this parameter is NULL or a pointer to an
	 * empty string, the function will open a new handle to the key identified
	 * by the hKey parameter. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724872(VS.85).aspx">Registry Element Size Limits.</a>
	 * @param ulOptions This parameter is reserved and must be zero.
	 * @param samDesired A mask that specifies the desired access rights to the
	 * key. The function fails if the security descriptor of the key does not
	 * permit the requested access for the calling process. For more
	 * information, see <a href="">Registry Key Security and Access Rights.</a>
	 * @param phkResult A pointer to a variable that receives a handle to the
	 * opened key. If the key is not one of the predefined registry keys, call
	 * the RegCloseKey function after you have finished using the handle.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a nonzero error code defined in
	 * Winerror.h. You can use the FormatMessage function with the
	 * FORMAT_MESSAGE_FROM_SYSTEM flag to get a generic description of the
	 * error.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724897(VS.85).aspx">RegOpenKeyEx Function (Windows)</a>
	 */
	NativeLong RegOpenKeyExA(int hKey,
			String lpSubKey,
			int ulOptions,
			int samDesired,
			IntByReference phkResult
			);
}
