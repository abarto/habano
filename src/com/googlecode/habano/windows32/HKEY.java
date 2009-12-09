package com.googlecode.habano.windows32;


/**
 * 
 * A utility interface to hold predefined registry key definitions.

 * @see @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface HKEY {
	/**
	 * HKEY_CLASSES_ROOT. Registry entries subordinate to this key define types
	 * (or classes) of documents and the properties associated with those
	 * types. Shell and COM applications use the information stored under this
	 * key. This key also provides backward compatibility with the Windows 3.1
	 * registration database by storing information for DDE and OLE support.
	 * File viewers and user interface extensions store their OLE class
	 * identifiers in HKEY_CLASSES_ROOT, and in-process servers are registered
	 * in this key. This handle should not be used in a service or an
	 * application that impersonates different users. For more information, see
	 * <a href="http://msdn.microsoft.com/en-us/library/ms724475(VS.85).aspx">HKEY_CLASSES_ROOT</a>.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_CLASSES_ROOT = 0x80000000;

	/**
	 * HKEY_CURRENT_CONFIG. Contains information about the current hardware
	 * profile of the local computer system. The information under
	 * HKEY_CURRENT_CONFIG describes only the differences between the current
	 * hardware configuration and the standard configuration. Information about
	 * the standard hardware configuration is stored under the Software and
	 * System keys of HKEY_LOCAL_MACHINE. HKEY_CURRENT_CONFIG is an alias for
	 * HKEY_LOCAL_MACHINE\System\CurrentControlSet\Hardware Profiles\Current.
	 * For more information, see <a href="http://go.microsoft.com/fwlink/?LinkId=114992">HKEY_CURRENT_CONFIG</a>.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a> 
	 */
	static final int HKEY_CURRENT_CONFIG = 0x80000005;

	/**
	 * HKEY_CURRENT_USER. Registry entries subordinate to this key define the
	 * preferences of the current user. These preferences include the settings
	 * of environment variables, data about program groups, colors, printers,
	 * network connections, and application preferences. This key makes it
	 * easier to establish the current user's settings; the key maps to the
	 * current user's branch in HKEY_USERS. In HKEY_CURRENT_USER, software
	 * vendors store the current user-specific preferences to be used within
	 * their applications. Microsoft, for example, creates the HKEY_CURRENT_USER\Software\Microsoft
	 * key for its applications to use, with each application creating its own
	 * subkey under the Microsoft key. The mapping between HKEY_CURRENT_USER
	 * and HKEY_USERS is per process and is established the first time the
	 * process references HKEY_CURRENT_USER. The mapping is based on the
	 * security context of the first thread to reference HKEY_CURRENT_USER. If
	 * this security context does not have a registry hive loaded in
	 * HKEY_USERS, the mapping is established with HKEY_USERS\.Default. After
	 * this mapping is established it persists, even if the security context of
	 * the thread changes. This handle should not be used in a service or an
	 * application that impersonates different users. Instead, call the
	 * RegOpenCurrentUser function. For more information, see
	 * <a href="http://go.microsoft.com/fwlink/?LinkId=114995">HKEY_CURRENT_USER</a>.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_CURRENT_USER = 0x80000001;

	/**
	 * HKEY_LOCAL_MACHINE. Registry entries subordinate to this key define the
	 * physical state of the computer, including data about the bus type,
	 * system memory, and installed hardware and software. It contains subkeys
	 * that hold current configuration data, including Plug and Play
	 * information (the Enum branch, which includes a complete list of all
	 * hardware that has ever been on the system), network logon preferences,
	 * network security information, software-related information (such as
	 * server names and the location of the server), and other system
	 * information. For more information, see
	 * <a href="http://go.microsoft.com/fwlink/?LinkId=114996">HKEY_LOCAL_MACHINE</a>.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_LOCAL_MACHINE = 0x80000002;

	/**
	 * HKEY_PERFORMANCE_DATA. Registry entries subordinate to this key allow
	 * you to access performance data. The data is not actually stored in the
	 * registry; the registry functions cause the system to collect the data
	 * from its source.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_PERFORMANCE_DATA = 0x80000004;

	/**
	 * HKEY_PERFORMANCE_NLSTEXT. Registry entries subordinate to this key
	 * reference the text strings that describe counters in the local language
	 * of the area in which the computer system is running. These entries are
	 * not available to Regedit.exe and Regedt32.exe. Windows 2000: This key is
	 * not supported.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_PERFORMANCE_NLSTEXT = 0x80000060;

	/**
	 * HKEY_PERFORMANCE_TEXT. Registry entries subordinate to this key
	 * reference the text strings that describe counters in US English. These
	 * entries are not available to Regedit.exe and Regedt32.exe. Windows 2000:
	 * This key is not supported.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_PERFORMANCE_TEXT = 0x80000050;

	/**
	 * HKEY_USERS. Registry entries subordinate to this key define the default
	 * user configuration for new users on the local computer and the user
	 * configuration for the current user.
	 * 
	 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724836(VS.85).aspx">Predefined Keys (Windows)</a>
	 */
	static final int HKEY_USERS = 0x80000003;
}
