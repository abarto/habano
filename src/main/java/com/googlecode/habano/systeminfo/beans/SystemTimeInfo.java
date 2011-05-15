package com.googlecode.habano.systeminfo.beans;

import java.util.Calendar;

/**
 * 
 * A bean to represent the current system time up to the millisecond. The month
 * and day of week fields follow the {@link Calendar} definitions.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class SystemTimeInfo {
	
	/** The year. */
	private Integer year;
	
	/** The month. */
	private Integer month;
	
	/** The day of month. */
	private Integer dayOfMonth;
	
	/** The day of week. */
	private Integer dayOfWeek;
	
	/** The hour. */
	private Integer hour;
	
	/** The minute. */
	private Integer minute;
	
	/** The second. */
	private Integer second;
	
	/** The millisecond. */
	private Integer millisecond;

	/**
	 * Instantiates a new system time info.
	 */
	public SystemTimeInfo() {
	}

	/**
	 * Property <code>year</code>. Represents the year of the system date/time.
	 *
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Setter for the <code>year</code> property.
	 *
	 * @param year the new year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Property <code>month</code>. Represents the month of the system
	 * date/time. The possible values for this field are those defined in
	 *
	 * @return the month
	 * {@link Calendar#MONTH}.
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * Setter for the <code>month</code> property.
	 *
	 * @param month the new month
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * Property <code>dayOfMonth</code>. Represents the day of the month
	 * of the system date/time.
	 *
	 * @return the day of month
	 */
	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	/**
	 * Setter for the <code>dayOfMonth</code> property.
	 *
	 * @param dayOfMonth the new day of month
	 */
	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	/**
	 * Property <code>dayOfWekk</code>. Represents the day of the week of the
	 * system date/time. The possible values for this field are those defined
	 * in {@link Calendar#DAY_OF_WEEK}.
	 *
	 * @return the day of week
	 */
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * Setter for the <code>dayOfWeek</code> property.
	 *
	 * @param dayOfWeek the new day of week
	 */
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * Property <code>hour</code>. Represents the hour of the system date/time.
	 * The possible values for this field are those defined in
	 *
	 * @return the hour
	 * {@link Calendar#HOUR_OF_DAY}.
	 */
	public Integer getHour() {
		return hour;
	}

	/**
	 * Setter for the <code>hour</code> property.
	 *
	 * @param hour the new hour
	 */
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	/**
	 * Property <code>minute</code>. Represents the minutes of the system
	 * date/time.
	 *
	 * @return the minute
	 */
	public Integer getMinute() {
		return minute;
	}

	/**
	 * Setter for the <code>minute</code> property.
	 *
	 * @param minute the new minute
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	/**
	 * Property <code>second</code>. Represents the seconds of the system
	 * date/time.
	 *
	 * @return the second
	 */
	public Integer getSecond() {
		return second;
	}

	/**
	 * Setter for the <code>minute</code> property.
	 *
	 * @param second the new second
	 */
	public void setSecond(Integer second) {
		this.second = second;
	}

	/**
	 * Property <code>millisecond</code>. Represents the milliseconds of the
	 * system date/time.
	 *
	 * @return the millisecond
	 */
	public Integer getMillisecond() {
		return millisecond;
	}

	/**
	 * Setter for the <code>millisecond</code> property.
	 *
	 * @param millisecond the new millisecond
	 */
	public void setMillisecond(Integer millisecond) {
		this.millisecond = millisecond;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemTimeInfo [dayOfMonth=" + dayOfMonth + ", dayOfWeek="
				+ dayOfWeek + ", hour=" + hour + ", millisecond=" + millisecond
				+ ", minute=" + minute + ", month=" + month + ", second="
				+ second + ", year=" + year + "]";
	}
}
