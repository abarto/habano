package com.googlecode.habano.systeminfo.beans;

/**
 * 
 * A bean to represent the the status of the system memory, both physical and virtual.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class MemoryInfo {
	
	/** The total system memory. */
	private Long totalSystemMemory;
	
	/** The total virtual memory. */
	private Long totalVirtualMemory;
	
	/** The available system memory. */
	private Long availableSystemMemory;
	
	/** The available virtual memory. */
	private Long availableVirtualMemory;

	/**
	 * Instantiates a new memory info.
	 */
	public MemoryInfo() {
	}

	/**
	 * Property <code>totalSystemMemory</code>. The total physical memory of
	 * the system in bytes.
	 *
	 * @return the total system memory
	 */
	public Long getTotalSystemMemory() {
		return totalSystemMemory;
	}

	/**
	 * Setter for the <code>totalSystemMemory</code> property.
	 *
	 * @param totalSystemMemory the new total system memory
	 */
	public void setTotalSystemMemory(Long totalSystemMemory) {
		this.totalSystemMemory = totalSystemMemory;
	}

	/**
	 * Property <code>totalVirtualMemory</code>. The total virtual memory
	 * (swap) of the system in bytes.
	 *
	 * @return the total virtual memory
	 */
	public Long getTotalVirtualMemory() {
		return totalVirtualMemory;
	}

	/**
	 * Setter for the <code>totalVirtualMemory</code> property.
	 *
	 * @param totalVirtualMemory the new total virtual memory
	 */
	public void setTotalVirtualMemory(Long totalVirtualMemory) {
		this.totalVirtualMemory = totalVirtualMemory;
	}

	/**
	 * Property <code>availableSystemMemory</code>. The free physical memory
	 * of the system in bytes.
	 *
	 * @return the available system memory
	 */
	public Long getAvailableSystemMemory() {
		return availableSystemMemory;
	}

	/**
	 * Setter for the <code>availableSystemMemory</code> property.
	 *
	 * @param availableSystemMemory the new available system memory
	 */
	public void setAvailableSystemMemory(Long availableSystemMemory) {
		this.availableSystemMemory = availableSystemMemory;
	}

	/**
	 * Property <code>availableVirtualMemory</code>. The free virtual memory
	 * (swap) of the system in bytes.
	 *
	 * @return the available virtual memory
	 */
	public Long getAvailableVirtualMemory() {
		return availableVirtualMemory;
	}

	/**
	 * Setter for the <code>availableVirtualMemory</code> property.
	 *
	 * @param availableVirtualMemory the new available virtual memory
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
