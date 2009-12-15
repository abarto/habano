package com.googlecode.habano.systeminfo.beans;

/**
 * 
 * A bean to hold information about the system architecture.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class SystemArchitectureInfo {
	private Integer cores;
	private String vendorIdentifier;
	private Boolean x86_64;
	
	/**
	 * Default no-arguments constructor.
	 */
	public SystemArchitectureInfo() {
	}

	/**
	 * Property <code>vendorIdentifier</code>. The vendor identifier as it is
	 * reported by the system. 
	 */
	public String getVendorIdentifier() {
		return vendorIdentifier;
	}

	/**
	 * Setter for the <code>vendorIdentifier</code> property.
	 * 
	 * @param vendorIdentifier
	 */
	public void setVendorIdentifier(String vendorIdentifier) {
		this.vendorIdentifier = vendorIdentifier;
	}
	
	/**
	 * Property <code>cores</code>. The number of cores in the system. Notice
	 * that this value might not reflect the actual number of cores present. 
	 */
	public Integer getCores() {
		return cores;
	}

	/**
	 * Setter for the <code>cores</code> property.
	 * 
	 * @param cores
	 */
	public void setCores(Integer cores) {
		this.cores = cores;
	}

	/**
	 * Property <code>amd</code>. Indicates if the system processor was made by
	 * AMD. 
	 */
	public Boolean isAmd() {
		return "AuthenticAMD".equalsIgnoreCase(vendorIdentifier);
	}

	/**
	 * Property <code>intel</code>. Indicates if the system processor was made
	 * by Intel. 
	 */
	public Boolean isIntel() {
		return "GenuineIntel".equalsIgnoreCase(vendorIdentifier);
	}

	/**
	 * Property <code>x86_64</code>. Indicates if the system supports 64-bit
	 * extensions.
	 */
	public Boolean isX86_64() {
		return x86_64;
	}

	/**
	 * Setter for the <code>x86_64</code> property.
	 * 
	 * @param x86_64
	 */
	public void setX86_64(Boolean x86_64) {
		this.x86_64 = x86_64;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SystemArchitectureInfo [cores=" + cores + ", vendorIdentifier="
				+ vendorIdentifier + ", x86_64=" + x86_64 + ", isAmd()="
				+ isAmd() + ", isIntel()=" + isIntel() + "]";
	}
}
