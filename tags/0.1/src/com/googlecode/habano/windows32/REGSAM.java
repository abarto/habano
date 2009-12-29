package com.googlecode.habano.windows32;

/**
 * 
 * Utility interface to hold REGSAM value constants.
 * 
 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface REGSAM {
	/**
	 * KEY_QUERY_VALUE (0x0001). Required to query the values of a registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_QUERY_VALUE = 0x0001;

	/**
	 * KEY_SET_VALUE (0x0002). Required to create, delete, or set a registry
	 * value.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_SET_VALUE = 0x0002;

	/**
	 * KEY_CREATE_SUB_KEY (0x0004). Required to create a subkey of a registry
	 * key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_CREATE_SUB_KEY = 0x0004;

	/**
	 * KEY_ENUMERATE_SUB_KEYS (0x0008). Required to enumerate the subkeys of a
	 * registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_ENUMERATE_SUB_KEYS = 0x0008;

	/**
	 * KEY_NOTIFY (0x0010). Required to request change notifications for a
	 * registry key or for subkeys of a registry key.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_NOTIFY = 0x0010;

	/**
	 * KEY_CREATE_LINK (0x0020). Reserved for system use.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_CREATE_LINK = 0x0020;

	/**
	 * KEY_WRITE (0x20006). Combines the STANDARD_RIGHTS_WRITE, KEY_SET_VALUE,
	 * and KEY_CREATE_SUB_KEY access rights.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_WRITE = 0x20006;

	/**
	 * KEY_EXECUTE (0x20019). Equivalent to KEY_READ.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_EXECUTE = 0x20019;

	/**
	 * KEY_READ (0x20019). Combines the STANDARD_RIGHTS_READ, KEY_QUERY_VALUE,
	 * KEY_ENUMERATE_SUB_KEYS, and KEY_NOTIFY values.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_READ = 0x20019;

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
	static final int KEY_WOW64_64KEY = 0x0100;

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
	static final int KEY_WOW64_32KEY = 0x0200;

	/**
	 * KEY_ALL_ACCESS (0xF003F). Combines the STANDARD_RIGHTS_REQUIRED,
	 * KEY_QUERY_VALUE, KEY_SET_VALUE, KEY_CREATE_SUB_KEY,
	 * KEY_ENUMERATE_SUB_KEYS, KEY_NOTIFY, and KEY_CREATE_LINK access rights.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724878(VS.85).aspx">Registry Key Security and Access Rights</a>
	 * @see <a href="http://msdn.microsoft.com/en-us/library/bb773480(VS.85).aspx">REGSAM</a>
	 */
	static final int KEY_ALL_ACCESS = 0xf003f;
}