package com.googlecode.habano.windows32;

import com.sun.jna.Structure;

/**
 * 
 * Specifies a date and time, using individual members for the month, day,
 * year, weekday, hour, minute, second, and millisecond. The time is either in
 * coordinated universal time (UTC) or local time, depending on the function
 * that is being called.
 * 
 * <pre>
 * typedef struct _SYSTEMTIME {
 *   WORD wYear;
 *   WORD wMonth;
 *   WORD wDayOfWeek;
 *   WORD wDay;
 *   WORD wHour;
 *   WORD wMinute;
 *   WORD wSecond;
 *   WORD wMilliseconds;
 * } SYSTEMTIME, *PSYSTEMTIME;
 * </pre>
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/ms724950%28VS.85%29.aspx">SYSTEMTIME Structure (Windows)</a>
 * @see <a href="http://msdn.microsoft.com/en-us/library/aa505945.aspx">Common Data Types</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class SYSTEMTIME extends Structure {
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
	public static class ByValue extends SYSTEMTIME implements Structure.ByValue { }

	/**
	 * 
	 * Tagged inner class to indicate the value of an instance of the Structure
	 * type is to be used in function invocations rather than its address.
	 * 
	 * @see Structure.ByValue
	 * @author Agustin Barto <abarto@gmail.com>
	 *
	 */	
	public static class ByReference extends SYSTEMTIME implements Structure.ByReference { }	
	
	/**
	 * <p><code>WORD wYear</code></p>
	 * 
	 * The year. The valid values for this member are 1601 through 30827.
	 */
	public short wYear;
	
	/**
	 * <p><code>WORD wMonth</code></p>
	 * 
	 *  The month. This member can be one of the following values: 
	 *  { 1 : January, 2 : February, 3 : March, 4 : April, 5 : May, 6 : June,
	 *  7 : July, 8 : August, 9 : September, 10 : October, 11 : November,
	 *  12 : December }
	 */
	public short wMonth;

	/**
	 * <p><code>WORD wDayOfWeek</code></p>
	 * 
	 * The day of the week. This member can be one of the following values:
	 * { 0 : Sunday, 1 : Monday, 2 : Tuesday, 3 : Wednesday, 4 : Thursday,
	 * 5 : Friday, 6 : Saturday }
	 */
	public short wDayOfWeek;

	/**
	 * <p><code>WORD wDay</code></p>
	 * 
	 * The day of the month. The valid values for this member are 1 through 31.
	 */
	public short wDay;
	
	/**
	 * <p><code>WORD wHour</code></p>
	 * 
	 * The hour. The valid values for this member are 0 through 23.
	 */
	public short wHour;

	/**
	 * <p><code>WORD wMinute</code></p>
	 * 
	 * The minute. The valid values for this member are 0 through 59.
	 */
	public short wMinute;

	/**
	 * <p><code>WORD wSecond</code></p>
	 * 
	 * The second. The valid values for this member are 0 through 59.
	 */
	public short wSecond;

	/**
	 * <p><code>WORD wMilliseconds</code></p>
	 * 
	 * The millisecond. The valid values for this member are 0 through 999.
	 */
	public short wMilliseconds;
}
