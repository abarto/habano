package com.googlecode.habano.libc64;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * 
 * 64-bit implementation of a structure to contain information about the system
 * time.
 * 
 * <pre>
 * struct tm
 * {
 *   int tm_sec;
 *   int tm_min;
 *   int tm_hour;
 *   int tm_mday;
 *   int tm_mon;
 *   int tm_year;
 *   int tm_wday;
 *   int tm_yday;
 *   int tm_isdst;
 * #ifdef	__USE_BSD
 *   long int tm_gmtoff;
 *   __const char *tm_zone;
 * #else
 *   long int __tm_gmtoff;
 *   __const char *__tm_zone;
 * #endif
 * };
 * </pre>
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * @see <a href="http://www.gnu.org/s/libc/manual/html_node/Broken_002ddown-Time.html">Broken-down Time - The GNU C Library</a>
 *
 */
public class tm_64 extends Structure {
	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */
	public static class ByValue extends tm_64 implements Structure.ByValue { }

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
	public static class ByReference extends tm_64 implements Structure.ByReference { }
	
	/**
	 * <p><code>int tm_sec</code></p>
	 * 
	 * The number of seconds after the minute, normally in the range 0 to 59,
	 * but can be up to 60 to allow for leap seconds.
	 */
	public int tm_sec;

	/**
	 * <p><code>int tm_min</code></p>
	 * 
	 * The number of minutes after the hour, in the range 0 to 59.
	 */
	public int tm_min;

	/**
	 * <p><code>int tm_hour</code></p>
	 * 
	 * The number of hours past midnight, in the range 0 to 23.
	 */
	public int tm_hour;

	/**
	 * <p><code>int tm_mday</code></p>
	 * 
	 * The day of the month, in the range 1 to 31.
	 */
	public int tm_mday;

	/**
	 * <p><code>int tm_mon</code></p>
	 * 
	 * The number of months since January, in the range 0 to 11.
	 */
	public int tm_mon;

	/**
	 * <p><code>int tm_year</code></p>
	 * 
	 * The number of years since 1900.
	 */
	public int tm_year;

	/**
	 * <p><code>int tm_wday</code></p>
	 * 
	 * The number of days since Sunday, in the range 0 to 6.
	 */
	public int tm_wday;

	/**
	 * <p><code>int tm_yday</code></p>
	 * 
	 * The number of days since January 1, in the range 0 to 365.
	 */
	public int tm_yday;

	/**
	 * <p><code>int tm_idst</code></p>
	 * 
	 * A flag that indicates whether daylight saving time is in effect at the
	 * time described. The value is positive if daylight saving time is in
	 * effect, zero if it is not, and negative if the information is not
	 * available.
	 */
	public int tm_isdst;

	/**
	 * <p><code>long int tm_gmtoff</code></p>
	 * 
	 * Seconds east of UTC.
	 */
	public NativeLong tm_gmtoff;
	
	/**
	 * <p><code>__const char *__tm_zone</code></p>
	 * 
	 * Timezone abbreviation.
	 */
	public String tm_zone; 
}
