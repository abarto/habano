package com.googlecode.habano.systeminfo.beans;

/**
 * 
 * A bean to hold information about the system architecture.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class SystemArchitectureInfo {
	
	/** The cores. */
	private Integer cores;
	
	/** The vendor identifier. */
	private String vendorIdentifier;
	
	/** The x8664. */
	private Boolean x8664;
	
	/**
	 * Property <code>vendorIdentifier</code>. The vendor identifier as it is
	 * reported by the system.
	 *
	 * @return the vendor identifier
	 */
	public String getVendorIdentifier() {
		return vendorIdentifier;
	}

	/**
	 * Setter for the <code>vendorIdentifier</code> property.
	 *
	 * @param vendorIdentifier the new vendor identifier
	 */
	public void setVendorIdentifier(final String vendorIdentifier) {
		this.vendorIdentifier = vendorIdentifier;
	}
	
	/**
	 * Property <code>cores</code>. The number of cores in the system. Notice
	 * that this value might not reflect the actual number of cores present.
	 *
	 * @return the cores
	 */
	public Integer getCores() {
		return cores;
	}

	/**
	 * Setter for the <code>cores</code> property.
	 *
	 * @param cores the new cores
	 */
	public void setCores(final Integer cores) {
		this.cores = cores;
	}

	/**
	 * Property <code>amd</code>. Indicates if the system processor was made by
	 * AMD.
	 *
	 * @return the boolean
	 */
	public Boolean isAmd() {
		return "AuthenticAMD".equalsIgnoreCase(vendorIdentifier);
	}

	/**
	 * Property <code>intel</code>. Indicates if the system processor was made
	 * by Intel.
	 *
	 * @return the boolean
	 */
	public Boolean isIntel() {
		return "GenuineIntel".equalsIgnoreCase(vendorIdentifier);
	}

	/**
	 * Property <code>x8664</code>. Indicates if the system supports 64-bit
	 * extensions.
	 *
	 * @return the boolean
	 */
	public Boolean getX8664() {
		return x8664;
	}

	/**
	 * Setter for the <code>x8664</code> property.
	 *
	 * @param x8664 the new x8664
	 */
	public void setX8664(final Boolean x8664) {
		this.x8664 = x8664;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemArchitectureInfo [cores=" + cores + ", vendorIdentifier="
				+ vendorIdentifier + ", x8664=" + x8664 + ", isAmd()="
				+ isAmd() + ", isIntel()=" + isIntel() + "]";
	}
}
