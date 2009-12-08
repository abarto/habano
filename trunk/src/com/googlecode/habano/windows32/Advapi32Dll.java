package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
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
	/**
	 * KEY_QUERY_VALUE (0x0001). Required to query the values of a registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_QUERY_VALUE = 0x0001;

	/**
	 * KEY_SET_VALUE (0x0002). Required to create, delete, or set a registry
	 * value.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_SET_VALUE = 0x0002;

	/**
	 * KEY_CREATE_SUB_KEY (0x0004). Required to create a subkey of a registry
	 * key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_CREATE_SUB_KEY = 0x0004;

	/**
	 * KEY_ENUMERATE_SUB_KEYS (0x0008). Required to enumerate the subkeys of a
	 * registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_ENUMERATE_SUB_KEYS = 0x0008;

	/**
	 * KEY_NOTIFY (0x0010). Required to request change notifications for a
	 * registry key or for subkeys of a registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_NOTIFY = 0x0010;

	/**
	 * KEY_CREATE_LINK (0x0020). Reserved for system use.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_CREATE_LINK = 0x0020;

	/**
	 * KEY_WRITE (0x20006). Combines the STANDARD_RIGHTS_WRITE, KEY_SET_VALUE,
	 * and KEY_CREATE_SUB_KEY access rights.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_WRITE = 0x20006;

	/**
	 * KEY_EXECUTE (0x20019). Equivalent to KEY_READ.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_EXECUTE = 0x20019;

	/**
	 * KEY_READ (0x20019). Combines the STANDARD_RIGHTS_READ, KEY_QUERY_VALUE,
	 * KEY_ENUMERATE_SUB_KEYS, and KEY_NOTIFY values.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_READ = 0x20019;

	/**
	 * KEY_WOW64_64KEY (0x0100). Indicates that an application on 64-bit
	 * Windows should operate on the 64-bit registry view. For more
	 * information, see <a href="http://msdn.microsoft.com/en-us/library/aa384129(VS.85).aspx">Accessing an Alternate Registry View</a>.
	 * This flag must be combined using the OR operator with the other flags in
	 * this table that either query or access registry values. Windows 2000:
	 * This flag is not supported.

	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_WOW64_64KEY = 0x0100;

	/**
	 * KEY_WOW64_32KEY (0x0200). Indicates that an application on 64-bit
	 * Windows should operate on the 32-bit registry view. For more
	 * information, see <a href="http://msdn.microsoft.com/en-us/library/aa384129(VS.85).aspx">Accessing an Alternate Registry View</a>.
	 * This flag must be combined using the OR operator with the other flags in
	 * this table that either query or access registry values. Windows 2000:
	 * This flag is not supported.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_WOW64_32KEY = 0x0200;

	/**
	 * KEY_ALL_ACCESS (0xF003F). Combines the STANDARD_RIGHTS_REQUIRED,
	 * KEY_QUERY_VALUE, KEY_SET_VALUE, KEY_CREATE_SUB_KEY,
	 * KEY_ENUMERATE_SUB_KEYS, KEY_NOTIFY, and KEY_CREATE_LINK access rights.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_ALL_ACCESS = 0xf003f;
	
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
	 * @param phkResult
	 * @return
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724897(VS.85).aspx">RegOpenKeyEx Function (Windows)</a>
	 */
	NativeLong RegOpenKeyExA(HKEY hKey,
			String lpSubKey,
			int ulOptions,
			int samDesired,
			HKEY phkResult
			);
}
