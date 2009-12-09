package com.googlecode.habano.windows32;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
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
	
	/**
	 * Retrieves the type and data for the specified value name associated with
	 * an open registry key. To ensure that any string values (REG_SZ,
	 * REG_MULTI_SZ, and REG_EXPAND_SZ) returned are null-terminated, use the
	 * RegGetValue function.
	 * 
	 * <pre>
	 * LONG WINAPI RegQueryValueEx(
	 *   __in         HKEY hKey,
	 *   __in_opt     LPCTSTR lpValueName,
	 *   __reserved   LPDWORD lpReserved,
	 *   __out_opt    LPDWORD lpType,
	 *   __out_opt    LPBYTE lpData,
	 *   __inout_opt  LPDWORD lpcbData
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to an open registry key. The key must have been
	 * opened with the KEY_QUERY_VALUE access right. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724911(VS.85).aspx">Registry Key Security and Access Rights</a>.
	 * This handle is returned by the RegCreateKeyEx, RegCreateKeyTransacted,
	 * RegOpenKeyEx, or RegOpenKeyTransacted function. It can also be one of
	 * the following predefined keys: HKEY_CLASSES_ROOT, HKEY_CURRENT_CONFIG,
	 * HKEY_CURRENT_USER, HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA,
	 * HKEY_PERFORMANCE_NLSTEXT, HKEY_PERFORMANCE_TEXT, HKEY_USERS.
	 * @param lpValueName The name of the registry value. If lpValueName is
	 * NULL or an empty string, "", the function retrieves the type and data
	 * for the key's unnamed or default value, if any. If lpValueName specifies
	 * a key that is not in the registry, the function returns
	 * ERROR_FILE_NOT_FOUND. Keys do not automatically have an unnamed or
	 * default value. Unnamed values can be of any type. For more information, see Registry Element Size Limits.
	 * @param lpReserved This parameter is reserved and must be NULL.
	 * @param lpType A pointer to a variable that receives a code indicating
	 * the type of data stored in the specified value. For a list of the
	 * possible type codes, see <a href="http://msdn.microsoft.com/en-us/library/ms724884(VS.85).aspx">Registry Value Types</a>.
	 * The lpType parameter can be NULL if the type code is not required.
	 * @param lpData A pointer to a buffer that receives the value's data. This
	 * parameter can be NULL if the data is not required.
	 * @param lpcbData A pointer to a variable that specifies the size of the
	 * buffer pointed to by the lpData parameter, in bytes. When the function
	 * returns, this variable contains the size of the data copied to lpData.
	 * The lpcbData parameter can be NULL only if lpData is NULL. If the data
	 * has the REG_SZ, REG_MULTI_SZ or REG_EXPAND_SZ type, this size includes
	 * any terminating null character or characters unless the data was stored
	 * without them. For more information, see Remarks. If the buffer specified
	 * by lpData parameter is not large enough to hold the data, the function
	 * returns ERROR_MORE_DATA and stores the required buffer size in the
	 * variable pointed to by lpcbData. In this case, the contents of the
	 * lpData buffer are undefined. If lpData is NULL, and lpcbData is
	 * non-NULL, the function returns ERROR_SUCCESS and stores the size of the
	 * data, in bytes, in the variable pointed to by lpcbData. This enables an
	 * application to determine the best way to allocate a buffer for the
	 * value's data. If hKey specifies HKEY_PERFORMANCE_DATA and the lpData
	 * buffer is not large enough to contain all of the returned data,
	 * RegQueryValueEx returns ERROR_MORE_DATA and the value returned through
	 * the lpcbData parameter is undefined. This is because the size of the
	 * performance data can change from one call to the next. In this case, you
	 * must increase the buffer size and call RegQueryValueEx again passing the
	 * updated buffer size in the lpcbData parameter. Repeat this until the
	 * function succeeds. You need to maintain a separate variable to keep
	 * track of the buffer size, because the value returned by lpcbData is
	 * unpredictable. If the lpValueName registry value does not exist,
	 * RegQueryValueEx returns ERROR_FILE_NOT_FOUND and the value returned
	 * through the lpcbData parameter is undefined.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a system error code. If the
	 * lpData buffer is too small to receive the data, the function returns
	 * ERROR_MORE_DATA. If the lpValueName registry value does not exist, the
	 * function returns ERROR_FILE_NOT_FOUND.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724911(VS.85).aspx">RegQueryValueEx Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>   
	 */
	NativeLong RegQueryValueExA(
			int hKey,
			String lpValueName,
			IntByReference lpReserved,
			IntByReference lpType,
			ByteByReference lpData,
			IntByReference lpcbData
			);
	
	/**
	 * Retrieves the type and data for the specified registry value.
	 * 
	 * <pre>
	 * LONG WINAPI RegGetValue(
	 *   __in         HKEY hkey,
	 *   __in_opt     LPCTSTR lpSubKey,
	 *   __in_opt     LPCTSTR lpValue,
	 *   __in_opt     DWORD dwFlags,
	 *   __out_opt    LPDWORD pdwType,
	 *   __out_opt    PVOID pvData,
	 *   __inout_opt  LPDWORD pcbData
	 * );
	 * </pre>
	 * 
	 * @param hkey A handle to an open registry key. The key must have been
	 * opened with the KEY_QUERY_VALUE access right. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>.
	 * This handle is returned by the RegCreateKeyEx, RegCreateKeyTransacted,
	 * RegOpenKeyEx, or RegOpenKeyTransacted function. It can also be one of
	 * the following predefined keys: HKEY_CLASSES_ROOT, HKEY_CURRENT_CONFIG,
	 * HKEY_CURRENT_USER, HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA,
	 * HKEY_PERFORMANCE_NLSTEXT, HKEY_PERFORMANCE_TEXT, HKEY_USERS.
	 * @param lpSubKey The name of the registry key. This key must be a subkey
	 * of the key specified by the hkey parameter. Key names are not case
	 * sensitive.
	 * @param lpValue The name of the registry value. If this parameter is NULL
	 * or an empty string, "", the function retrieves the type and data for the
	 * key's unnamed or default value, if any. For more information, see
	 * Registry Element Size Limits. Keys do not automatically have an unnamed
	 * or default value. Unnamed values can be of any type.
	 * @param dwFlags The flags that restrict the data type of value to be
	 * queried. If the data type of the value does not meet this criteria, the
	 * function fails. This parameter can be one or more of the following
	 * values.
	 * <table>
	 *   <tr>
	 *     <th>Value</th>
	 *     <th>Meaning</th>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_ANY 0x0000ffff</td>
	 *     <td>No type restriction.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_DWORD 0x00000018</td>
	 *     <td>Restrict type to 32-bit RRF_RT_REG_BINARY | RRF_RT_REG_DWORD.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_QWORD 0x00000048</td>
	 *     <td>Restrict type to 64-bit RRF_RT_REG_BINARY | RRF_RT_REG_DWORD.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_BINARY 0x00000008</td>
	 *     <td>Restrict type to REG_BINARY.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_DWORD 0x00000010</td>
	 *     <td>Restrict type to REG_DWORD.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_EXPAND_SZ 0x00000004</td>
	 *     <td>Restrict type to REG_EXPAND_SZ.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_MULTI_SZ 0x00000020</td>
	 *     <td>Restrict type to REG_MULTI_SZ.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_NONE 0x00000001</td>
	 *     <td>Restrict type to REG_NONE.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_QWORD 0x00000040</td>
	 *     <td>Restrict type to REG_QWORD.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_RT_REG_SZ 0x00000002</td>
	 *     <td>Restrict type to REG_SZ.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_NOEXPAND 0x10000000</td>
	 *     <td>Do not automatically expand environment strings if the value is of type REG_EXPAND_SZ.</td>
	 *   </tr>
	 *   <tr>
	 *     <td>RRF_ZEROONFAILURE 0x20000000</td>
	 *     <td>If pvData is not NULL, set the contents of the buffer to zeroes on failure.</td>
	 *   </tr>
	 * </table>
	 * @param pdwType A pointer to a variable that receives a code indicating
	 * the type of data stored in the specified value. For a list of the
	 * possible type codes, see Registry Value Types. This parameter can be
	 * NULL if the type is not required.
	 * @param pvData A pointer to a buffer that receives the value's data. This
	 * parameter can be NULL if the data is not required. If the data is a
	 * string, the function checks for a terminating null character. If one is
	 * not found, the string is stored with a null terminator if the buffer is
	 * large enough to accommodate the extra character. Otherwise, the function
	 * fails and returns ERROR_MORE_DATA.
	 * @param pcbData A pointer to a variable that specifies the size of the
	 * buffer pointed to by the pvData parameter, in bytes. When the function
	 * returns, this variable contains the size of the data copied to pvData.
	 * The pcbData parameter can be NULL only if pvData is NULL. If the data
	 * has the REG_SZ, REG_MULTI_SZ or REG_EXPAND_SZ type, this size includes
	 * any terminating null character or characters. For more information, see
	 * Remarks. If the buffer specified by pvData parameter is not large enough
	 * to hold the data, the function returns ERROR_MORE_DATA and stores the
	 * required buffer size in the variable pointed to by pcbData. In this
	 * case, the contents of the pvData buffer are undefined. If pvData is
	 * NULL, and pcbData is non-NULL, the function returns ERROR_SUCCESS and
	 * stores the size of the data, in bytes, in the variable pointed to by
	 * pcbData. This enables an application to determine the best way to
	 * allocate a buffer for the value's data. If hKey specifies
	 * HKEY_PERFORMANCE_DATA and the pvData buffer is not large enough to
	 * contain all of the returned data, the function returns ERROR_MORE_DATA
	 * and the value returned through the pcbData parameter is undefined. This
	 * is because the size of the performance data can change from one call to
	 * the next. In this case, you must increase the buffer size and call
	 * RegGetValue again passing the updated buffer size in the pcbData
	 * parameter. Repeat this until the function succeeds. You need to maintain
	 * a separate variable to keep track of the buffer size, because the value
	 * returned by pcbData is unpredictable.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a system error code. If the
	 * pvData buffer is too small to receive the value, the function returns
	 * ERROR_MORE_DATA.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724868(VS.85).aspx">RegGetValue Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>   
	 */
	NativeLong RegGetValueA(
			int hkey,
			String lpSubKey,
			String lpValue,
			int dwFlags,
			IntByReference pdwType,
			Pointer pvData,
			IntByReference pcbData
			);
	
	/**
	 * Retrieves information about the specified registry key.
	 * 
	 * <pre>
	 * LONG WINAPI RegQueryInfoKey(
	 *   __in         HKEY hKey,
	 *   __out        LPTSTR lpClass,
	 *   __inout_opt  LPDWORD lpcClass,
	 *   __reserved   LPDWORD lpReserved,
	 *   __out_opt    LPDWORD lpcSubKeys,
	 *   __out_opt    LPDWORD lpcMaxSubKeyLen,
	 *   __out_opt    LPDWORD lpcMaxClassLen,
	 *   __out_opt    LPDWORD lpcValues,
	 *   __out_opt    LPDWORD lpcMaxValueNameLen,
	 *   __out_opt    LPDWORD lpcMaxValueLen,
	 *   __out_opt    LPDWORD lpcbSecurityDescriptor,
	 *   __out_opt    PFILETIME lpftLastWriteTime
	 * );
	 * </pre>
	 * 
	 * @param hKey A handle to an open registry key. The key must have been
	 * opened with the KEY_QUERY_VALUE access right. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724902(VS.85).aspx">Registry Key Security and Access Rights</a>.
	 * This handle is returned by the RegCreateKeyEx, RegCreateKeyTransacted,
	 * RegOpenKeyEx, or RegOpenKeyTransacted function. It can also be one of
	 * the following predefined keys: HKEY_CLASSES_ROOT, HKEY_CURRENT_CONFIG,
	 * HKEY_CURRENT_USER, HKEY_LOCAL_MACHINE, HKEY_PERFORMANCE_DATA,
	 * HKEY_USERS.
	 * @param lpClass A pointer to a buffer that receives the user-defined
	 * class of the key. This parameter can be NULL.
	 * @param lpcClass A pointer to a variable that specifies the size of the
	 * buffer pointed to by the lpClass parameter, in characters. The size
	 * should include the terminating null character. When the function
	 * returns, this variable contains the size of the class string that is
	 * stored in the buffer. The count returned does not include the
	 * terminating null character. If the buffer is not big enough, the
	 * function returns ERROR_MORE_DATA, and the variable contains the size of
	 * the string, in characters, without counting the terminating null
	 * character. If lpClass is NULL, lpcClass can be NULL. If the lpClass
	 * parameter is a valid address, but the lpcClass parameter is not, for
	 * example, it is NULL, then the function returns ERROR_INVALID_PARAMETER.
	 * @param lpReserved This parameter is reserved and must be NULL.
	 * @param lpcSubKeys A pointer to a variable that receives the number of
	 * subkeys that are contained by the specified key. This parameter can be
	 * NULL.
	 * @param lpcMaxSubKeyLen A pointer to a variable that receives the size of
	 * the key's subkey with the longest name, in Unicode characters, not
	 * including the terminating null character. This parameter can be NULL.
	 * @param lpcMaxClassLen A pointer to a variable that receives the size of
	 * the longest string that specifies a subkey class, in Unicode characters.
	 * The count returned does not include the terminating null character. This
	 * parameter can be NULL.
	 * @param lpcValues A pointer to a variable that receives the number of
	 * values that are associated with the key. This parameter can be NULL.
	 * @param lpcMaxValueNameLen A pointer to a variable that receives the size
	 * of the key's longest value name, in Unicode characters. The size does
	 * not include the terminating null character. This parameter can be NULL.
	 * @param lpcMaxValueLen A pointer to a variable that receives the size of
	 * the longest data component among the key's values, in bytes. This
	 * parameter can be NULL.
	 * @param lpcbSecurityDescriptor A pointer to a variable that receives the
	 * size of the key's security descriptor, in bytes. This parameter can be
	 * NULL.
	 * @param lpftLastWriteTime A pointer to a {@link FILETIME}structure that
	 * receives the last write time. This parameter can be NULL. The function
	 * sets the members of the {@link FILETIME} structure to indicate the last
	 * time that the key or any of its value entries is modified.
	 * @return If the function succeeds, the return value is ERROR_SUCCESS. If
	 * the function fails, the return value is a system error code. If the
	 * lpClass buffer is too small to receive the name of the class, the
	 * function returns ERROR_MORE_DATA.
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724902(VS.85).aspx">RegQueryInfoKey Function (Windows)</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
	 */
	NativeLong RegQueryInfoKeyA(
			int hKey,
			String lpClass,
			IntByReference lpcClass,
			IntByReference lpReserved,
			IntByReference lpcSubKeys,
			IntByReference lpcMaxSubKeyLen,
			IntByReference lpcMaxClassLen,
			IntByReference lpcValues,
			IntByReference lpcMaxValueNameLen,
			IntByReference lpcMaxValueLen,
			IntByReference lpcbSecurityDescriptor,
			FILETIME lpftLastWriteTime
			);
}
