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
	private Integer year;
	private Integer month;
	private Integer dayOfMonth;
	private Integer dayOfWeek;
	private Integer hour;
	private Integer minute;
	private Integer second;
	private Integer millisecond;

	/**
	 * Default no-arguments constructor.
	 */
	public SystemTimeInfo() {
	}

	/**
	 * Property <code>year</code>. Represents the year of the system date/time. 
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * Setter for the <code>year</code> property.
	 * 
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Property <code>month</code>. Represents the month of the system
	 * date/time. The possible values for this field are those defined in
	 * {@link Calendar#MONTH}.
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * Setter for the <code>month</code> property.
	 * 
	 * @param month
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * Property <code>dayOfMonth</code>. Represents the day of the month
	 * of the system date/time.
	 */
	public Integer getDayOfMonth() {
		return dayOfMonth;
	}

	/**
	 * Setter for the <code>dayOfMonth</code> property.
	 * 
	 * @param dayOfMonth
	 */
	public void setDayOfMonth(Integer dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	/**
	 * Property <code>dayOfWekk</code>. Represents the day of the week of the
	 * system date/time. The possible values for this field are those defined
	 * in {@link Calendar#DAY_OF_WEEK}.
	 */
	public Integer getDayOfWeek() {
		return dayOfWeek;
	}

	/**
	 * Setter for the <code>dayOfWeek</code> property.
	 * 
	 * @param dayOfWeek
	 */
	public void setDayOfWeek(Integer dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * Property <code>hour</code>. Represents the hour of the system date/time.
	 * The possible values for this field are those defined in
	 * {@link Calendar#HOUR_OF_DAY}. 
	 */
	public Integer getHour() {
		return hour;
	}

	/**
	 * Setter for the <code>hour</code> property.
	 * 
	 * @param hour
	 */
	public void setHour(Integer hour) {
		this.hour = hour;
	}

	/**
	 * Property <code>minute</code>. Represents the minutes of the system
	 * date/time. 
	 */
	public Integer getMinute() {
		return minute;
	}

	/**
	 * Setter for the <code>minute</code> property.
	 * 
	 * @param minute
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	/**
	 * Property <code>second</code>. Represents the seconds of the system
	 * date/time. 
	 */
	public Integer getSecond() {
		return second;
	}

	/**
	 * Setter for the <code>minute</code> property.
	 * 
	 * @param second
	 */
	public void setSecond(Integer second) {
		this.second = second;
	}

	/**
	 * Property <code>millisecond</code>. Represents the milliseconds of the
	 * system date/time. 
	 */
	public Integer getMillisecond() {
		return millisecond;
	}

	/**
	 * Setter for the <code>millisecond</code> property.
	 * 
	 * @param millisecond
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
