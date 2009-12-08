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
	 * <p><code>#define KEY_QUERY_VALUE 1</code></p>
	 * 
	 * REGSAM value. Permission to query subkey data.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_QUERY_VALUE = 1;

	/**
	 * <p><code>#define KEY_SET_VALUE 2</code></p>
	 * 
	 * REGSAM value. Permission to set subkey data.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_SET_VALUE = 2;

	/**
	 * <p><code>#define KEY_CREATE_SUB_KEY 4</code></p>
	 * 
	 * REGSAM value. Permission to create subkeys.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_CREATE_SUB_KEY = 4;

	/**
	 * <p><code>#define KEY_ENUMERATE_SUB_KEYS 8</code></p>
	 * 
	 * REGSAM value. Permission to enumerate subkeys.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_ENUMERATE_SUB_KEYS = 8;

	/**
	 * <p><code>#define KEY_NOTIFY 16</code></p>
	 * 
	 * REGSAM value. Permission for change notification.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_NOTIFY = 16;

	/**
	 * <p><code>#define KEY_CREATE_LINK 32</code></p>
	 * 
	 * REGSAM value. ermission to create a symbolic link.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_CREATE_LINK = 32;

	/**
	 * <p><code>#define KEY_WRITE 0x20006</code></p>
	 * 
	 * REGSAM value. Combination of KEY_SET_VALUE and KEY_CREATE_SUB_KEY
	 * access.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_WRITE = 0x20006;

	/**
	 * <p><code>#define KEY_EXECUTE 0x20019</code></p>
	 * 
	 * REGSAM value. Permission to query subkey data.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_EXECUTE = 0x20019;

	/**
	 * <p><code>#define KEY_READ 0x20019</code></p>
	 * 
	 * REGSAM value. Permission for read access.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	public static final int KEY_READ = 0x20019;

	/**
	 * <p><code>#define KEY_WOW64_64KEY 0x0100</code></p>
	 * 
	 * REGSAM value.
	 */
	public static final int KEY_WOW64_64KEY = 0x0100;

	/**
	 * <p><code>#define KEY_WOW64_32KEY 0x0200</code></p>
	 * 
	 * REGSAM value.
	 */
	public static final int KEY_WOW64_32KEY = 0x0200;

	/**
	 * <p><code>#define KEY_ALL_ACCESS 0xf003f</code></p>
	 * 
	 * REGSAM value. Combination of {@link #KEY_QUERY_VALUE},
	 * {@link #KEY_ENUMERATE_SUB_KEYS}, {@link #KEY_NOTIFY},
	 * {@link #KEY_CREATE_SUB_KEY}, {@link #KEY_CREATE_LINK}, and
	 * {@link #KEY_SET_VALUE} access.
	 * 
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
	 * @param lpSubKey
	 * @param ulOptions
	 * @param samDesired
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
