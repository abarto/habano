package com.googlecode.habano.systeminfo.beans;

/**
 * 
 * A bean to represent the the status of the system memory, both physical and virtual.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class MemoryInfo {
	private Long totalSystemMemory;
	private Long totalVirtualMemory;
	private Long availableSystemMemory;
	private Long availableVirtualMemory;

	/**
	 * Default no-arguments constructor.
	 */
	public MemoryInfo() {
	}

	/**
	 * Property <code>totalSystemMemory</code>. The total physical memory of
	 * the system in bytes. 
	 */
	public Long getTotalSystemMemory() {
		return totalSystemMemory;
	}

	/**
	 * Setter for the <code>totalSystemMemory</code> property.
	 * 
	 * @param totalSystemMemory
	 */
	public void setTotalSystemMemory(Long totalSystemMemory) {
		this.totalSystemMemory = totalSystemMemory;
	}

	/**
	 * Property <code>totalVirtualMemory</code>. The total virtual memory
	 * (swap) of the system in bytes. 
	 */
	public Long getTotalVirtualMemory() {
		return totalVirtualMemory;
	}

	/**
	 * Setter for the <code>totalVirtualMemory</code> property.
	 * 
	 * @param totalVirtualMemory
	 */
	public void setTotalVirtualMemory(Long totalVirtualMemory) {
		this.totalVirtualMemory = totalVirtualMemory;
	}

	/**
	 * Property <code>availableSystemMemory</code>. The free physical memory
	 * of the system in bytes. 
	 */
	public Long getAvailableSystemMemory() {
		return availableSystemMemory;
	}

	/**
	 * Setter for the <code>availableSystemMemory</code> property.
	 * 
	 * @param availableSystemMemory
	 */
	public void setAvailableSystemMemory(Long availableSystemMemory) {
		this.availableSystemMemory = availableSystemMemory;
	}

	/**
	 * Property <code>availableVirtualMemory</code>. The free virtual memory
	 * (swap) of the system in bytes. 
	 */
	public Long getAvailableVirtualMemory() {
		return availableVirtualMemory;
	}

	/**
	 * Setter for the <code>availableVirtualMemory</code> property.
	 * 
	 * @param availableVirtualMemory
	 */
	public void setAvailableVirtualMemory(Long availableVirtualMemory) {
		this.availableVirtualMemory = availableVirtualMemory;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemoryInfo [availableSystemMemory=" + availableSystemMemory
				+ ", availableVirtualMemory=" + availableVirtualMemory
				+ ", totalSystemMemory=" + totalSystemMemory
				+ ", totalVirtualMemory=" + totalVirtualMemory + "]";
	}
}
