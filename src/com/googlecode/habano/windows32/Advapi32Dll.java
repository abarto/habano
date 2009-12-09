package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.ByteByReference;
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
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
	 */
	NativeLong RegOpenKeyExA(int hKey,
			String lpSubKey,
			int ulOptions,
			int samDesired,
			IntByReference phkResult
			);
	
	/**
	 * Closes a handle to the specified registry key.
	 * 
	 * <pre>
	 * LONG WINAPI RegCloseKey(
	 *   __in  HKEY hKey
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to the open key to be closed. The handle must have
	 * been opened by the RegCreateKeyEx, RegCreateKeyTransacted, RegOpenKeyEx,
	 * RegOpenKeyTransacted, or RegConnectRegistry function.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a nonzero error code defined in
	 * Winerror.h. You can use the FormatMessage function with the
	 * FORMAT_MESSAGE_FROM_SYSTEM flag to get a generic description of the
	 * error.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724837(VS.85).aspx">RegCloseKey Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
	 */
	NativeLong RegCloseKey(int hKey);
	
	/**
	 * Establishes a connection to a predefined registry key on another
	 * computer.
	 * 
	 * <pre>
	 * LONG WINAPI RegConnectRegistry(
	 *   __in_opt  LPCTSTR lpMachineName,
	 *   __in      HKEY hKey,
	 *   __out     PHKEY phkResult
	 * );
	 * </pre>
	 * 
	 * @param lpMachineName The name of the remote computer. The string has the
	 * following form: <code>\\computername</code>. The caller must have access
	 * to the remote computer or the function fails. If this parameter is NULL,
	 * the local computer name is used.
	 * @param hKey A predefined registry handle. This parameter can be one of
	 * the following predefined keys on the remote computer:
	 * HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA, or HKEY_USERS.
	 * @param phkResult A pointer to a variable that receives a key handle
	 * identifying the predefined handle on the remote computer.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a nonzero error code defined in
	 * Winerror.h. You can use the FormatMessage function with the
	 * FORMAT_MESSAGE_FROM_SYSTEM flag to get a generic description of the
	 * error.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724840(VS.85).aspx">RegConnectRegistry Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a> 
	 */
	NativeLong RegConnectRegistry(
			String lpMachineName,
			int hKey,
			IntByReference phkResult
			);

	/**
	 * Enumerates the subkeys of the specified open registry key. The function
	 * retrieves information about one subkey each time it is called.
	 *
	 * <pre>
	 * LONG WINAPI RegEnumKeyEx(
	 *   __in         HKEY hKey,
	 *   __in         DWORD dwIndex,
	 *   __out        LPTSTR lpName,
	 *   __inout      LPDWORD lpcName,
	 *   __reserved   LPDWORD lpReserved,
	 *   __inout      LPTSTR lpClass,
	 *   __inout_opt  LPDWORD lpcClass,
	 *   __out_opt    PFILETIME lpftLastWriteTime
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to an open registry key. The key must have been
	 * opened with the KEY_ENUMERATE_SUB_KEYS access right. For more
	 * information, see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights.</a>
	 * This handle is returned by the RegCreateKeyEx, RegCreateKeyTransacted,
	 * RegOpenKeyEx, or RegOpenKeyTransacted function. It can also be one of
	 * the following predefined keys: HKEY_CLASSES_ROOT,  HKEY_CURRENT_CONFIG,
	 * HKEY_CURRENT_USER, HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA, 
	 * HKEY_USERS.
	 * @param dwIndex The index of the subkey to retrieve. This parameter
	 * should be zero for the first call to the RegEnumKeyEx function and then
	 * incremented for subsequent calls. Because subkeys are not ordered, any
	 * new subkey will have an arbitrary index. This means that the function
	 * may return subkeys in any order.
	 * @param lpName A pointer to a buffer that receives the name of the
	 * subkey, including the terminating null character. The function copies
	 * only the name of the subkey, not the full key hierarchy, to the buffer.
	 * If the function fails, no information is copied to this buffer. For more
	 * information, see Registry Element Size Limits.
	 * @param lpcName A pointer to a variable that specifies the size of the
	 * buffer specified by the lpName parameter, in characters. This size
	 * should include the terminating null character. If the function succeeds,
	 * the variable pointed to by lpcName contains the number of characters
	 * stored in the buffer, not including the terminating null character. To
	 * determine the required buffer size, use the RegQueryInfoKey function to
	 * determine the size of the largest subkey for the key identified by the
	 * hKey parameter.
	 * @param lpReserved This parameter is reserved and must be NULL.
	 * @param lpClass A pointer to a buffer that receives the user-defined
	 * class of the enumerated subkey. This parameter can be NULL.
	 * @param lpcClass A pointer to a variable that specifies the size of the
	 * buffer specified by the lpClass parameter, in characters. The size
	 * should include the terminating null character. If the function succeeds,
	 * lpcClass contains the number of characters stored in the buffer, not
	 * including the terminating null character. This parameter can be NULL
	 * only if lpClass is NULL.
	 * @param lpftLastWriteTime A pointer to {@link FILETIME} structure that
	 * receives the time at which the enumerated subkey was last written. This
	 * parameter can be NULL.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a system error code. If there
	 * are no more subkeys available, the function returns ERROR_NO_MORE_ITEMS.
	 * If the lpName buffer is too small to receive the name of the key, the
	 * function returns ERROR_MORE_DATA.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724862(VS.85).aspx">RegEnumKeyEx Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>  
	 */
	NativeLong RegEnumKeyExA(
			int hKey,
			int dwIndex,
			String lpName,
			IntByReference lpcName,
			IntByReference lpReserved,
			String lpClass,
			IntByReference lpcClass,
			FILETIME lpftLastWriteTime
			);	
	
	/**
	 * Enumerates the values for the specified open registry key. The function
	 * copies one indexed value name and data block for the key each time it is
	 * called.
	 * 
	 * <pre>
	 * LONG WINAPI RegEnumValue(
	 *   __in         HKEY hKey,
	 *   __in         DWORD dwIndex,
	 *   __out        LPTSTR lpValueName,
	 *   __inout      LPDWORD lpcchValueName,
	 *   __reserved   LPDWORD lpReserved,
	 *   __out_opt    LPDWORD lpType,
	 *   __out_opt    LPBYTE lpData,
	 *   __inout_opt  LPDWORD lpcbData
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to an open registry key. The key must have been
	 * opened with the KEY_QUERY_VALUE access right. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>.
	 * This handle is returned by the RegCreateKeyEx, RegCreateKeyTransacted,
	 * RegOpenKeyEx, or RegOpenKeyTransacted function. It can also be one of
	 * the following predefined keys: HKEY_CLASSES_ROOT, HKEY_CURRENT_CONFIG,
	 * HKEY_CURRENT_USER, HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA,
	 * HKEY_USERS.
	 * @param dwIndex The index of the value to be retrieved. This parameter
	 * should be zero for the first call to the RegEnumValue function and then
	 * be incremented for subsequent calls. Because values are not ordered, any
	 * new value will have an arbitrary index. This means that the function may
	 * return values in any order.
	 * @param lpValueName A pointer to a buffer that receives the name of the
	 * value as a null-terminated string. This buffer must be large enough to
	 * include the terminating null character. For more information, see
	 * Registry Element Size Limits.
	 * @param lpcchValueName A pointer to a variable that specifies the size of
	 * the buffer pointed to by the lpValueName parameter, in characters. When
	 * the function returns, the variable receives the number of characters
	 * stored in the buffer, not including the terminating null character.
	 * @param lpReserved This parameter is reserved and must be NULL.
	 * @param lpType A pointer to a variable that receives a code indicating
	 * the type of data stored in the specified value. For a list of the
	 * possible type codes, see <a href="http://msdn.microsoft.com/en-us/library/ms724884(VS.85).aspx">Registry Value Types</a>.
	 * The lpType parameter can be NULL if the type code is not required.
	 * @param lpData A pointer to a buffer that receives the data for the value
	 * entry. This parameter can be NULL if the data is not required. If lpData
	 * is NULL and lpcbData is non-NULL, the function stores the size of the
	 * data, in bytes, in the variable pointed to by lpcbData. This enables an
	 * application to determine the best way to allocate a buffer for the data.
	 * @param lpcbData A pointer to a variable that specifies the size of the
	 * buffer pointed to by the lpData parameter, in bytes. When the function
	 * returns, the variable reeives the number of bytes stored in the buffer.
	 * This parameter can be NULL only if lpData is NULL. If the data has the
	 * REG_SZ, REG_MULTI_SZ or REG_EXPAND_SZ type, this size includes any
	 * terminating null character or characters. For more information, see
	 * Remarks. If the buffer specified by lpData is not large enough to hold
	 * the data, the function returns ERROR_MORE_DATA and stores the required
	 * buffer size in the variable pointed to by lpcbData. In this case, the
	 * contents of lpData are undefined. Registry value names are limited to
	 * 32767 bytes. The ANSI version of this function treats this param as a
	 * USHORT value. Therefore, if you specify a value greater than 32767
	 * bytes, there is an overflow and the function may return ERROR_MORE_DATA.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a system error code. If there
	 * are no more values available, the function returns ERROR_NO_MORE_ITEMS.
	 * If the lpData buffer is too small to receive the value, the function
	 * returns ERROR_MORE_DATA.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724865(VS.85).aspx">RegEnumValue Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>   
	 */
	NativeLong RegEnumValue(
			int hKey,
			int dwIndex,
			String lpValueName,
			IntByReference lpcchValueName,
			IntByReference lpReserved,
			IntByReference lpType,
			ByteByReference lpData,
			IntByReference lpcbData
			);
}
