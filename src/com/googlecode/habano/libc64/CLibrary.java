package com.googlecode.habano.libc64;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

/**
 * 
 * A class that wraps calls to the standard C library (libc), accessible
 * linking "libc.so" dynamically. The code was mostly based on GNU libc, but it
 * should be compatible with any implementation of the standard library.
 * 
 * This is the 64-bit implementation.
 * 
 * @see libc (7) manpage
 * @see <a href="http://www.gnu.org/software/libc/manual/html_node/index.html">The GNU C Library</a>
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface CLibrary extends Library {
	/**
	 * The actual object on which to make the method calls.
	 */
	CLibrary INSTANCE = (CLibrary) Native.loadLibrary("c", CLibrary.class);
	
	/**
	 * The time function returns the current calendar time as a value of type
	 * time_t.
	 * 
	 * @param result If the argument result is not a null pointer, the calendar
	 * time value is also stored in *result.
	 * @return the current calendar time as a value of type time_t or
	 * (time_t)(-1) if the current calendar time is not available. 
	 * @see time (2) manpage
	 * @see <a href="http://www.gnu.org/software/libc/manual/html_node/Simple-Calendar-Time.html#Simple-Calendar-Time">Simple Calendar Time - The GNU C Library</a>
	 */
	int time(IntByReference result);
	
	/**
	 * The gettimeofday function returns the current calendar time as the
	 * elapsed time since the epoch in the struct timeval structure indicated
	 * by tp.
	 * 
	 * @param tv An output parameter to store the elapsed time since the epoch.
	 * @param tz Information about the time zone is returned in the structure
	 * pointed at tzp. If the tzp argument is a null pointer, time zone
	 * information is ignored. 
	 * @return The return value is 0 on success and -1 on failure.
	 * @see gettimeofday (2) manpage
	 * @see <a href="http://www.gnu.org/software/libc/manual/html_node/High_002dResolution-Calendar.html#High_002dResolution-Calendar">High-Resolution Calendar - The GNU C Library</a>
	 */
	@SuppressWarnings("deprecation")
	int gettimeofday(timeval tv, timezone tz);
	
	/**
	 * The localtime function converts the simple time pointed to by time to
	 * broken-down time representation, expressed relative to the user's
	 * specified time zone. 
	 * 
	 * @param timep The time_t pointer containing the time value to convert to
	 * a broken-down structure.
	 * @return The return value is a pointer to a static broken-down time
	 * structure, which might be overwritten by subsequent calls to ctime,
	 * gmtime, or localtime. (But no other library function overwrites the
	 * contents of this object.) The return value is the null pointer if time
	 * cannot be represented as a broken-down time; typically this is because
	 * the year cannot fit into an int. 
	 * @see ctime (3) manpage
	 * @see <a href="http://www.gnu.org/software/libc/manual/html_node/Broken_002ddown-Time.html#Broken_002ddown-Time">Broken-down Time - The GNU C Library</a> 
	 */
	tm localtime(IntByReference timep);
	
	/**
	 * The localtime_r function works just like the localtime function. It
	 * takes a pointer to a variable containing a simple time and converts it
	 * to the broken-down time format. But the result is not placed in a static
	 * buffer. Instead it is placed in the object of type struct tm to which
	 * the parameter resultp points. 
	 * 
	 * @param timep The time_t pointer containing the time value to convert to
	 * a broken-down structure.
	 * @param resultp An output parameter to contain the broken-down
	 * representation of timep.
	 * @return If the conversion is successful the function returns a pointer
	 * to the object the result was written into, i.e., it returns resultp. 
	 * @see ctime (3) manpage
	 * @see <a href="http://www.gnu.org/software/libc/manual/html_node/Broken_002ddown-Time.html#Broken_002ddown-Time">Broken-down Time - The GNU C Library</a>
	 */
	tm localtime_r(LongByReference timep, tm resultp);
	
	/**
	 * The  function statvfs() returns information about a mounted file system.
	 * 
	 * @param path The pathname of any file within the mounted file system.
	 * @param buf A pointer to a statvfs structure.
	 * @return On success, zero is returned. On error, -1 is returned.
	 * @see statvfs 2 manpage
	 * @see <a href="http://www.opengroup.org/onlinepubs/9699919799/functions/statvfs.html">fstatvfs.h</a>
	 */
	int statvfs(String path, statvfs buf);
}
