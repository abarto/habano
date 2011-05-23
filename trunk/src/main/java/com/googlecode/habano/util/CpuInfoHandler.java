package com.googlecode.habano.util;

/**
 * A handler for the values of /proc/cpuinfo 
 */
public interface CpuInfoHandler {
	
	/**
	 * Start.
	 *
	 * @return whether to continue processing
	 */
	Boolean start();
	
	/**
	 * End.
	 *
	 * @return whether to continue processing
	 */
	Boolean end();
	
	/**
	 * Handle processor.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleProcessor(Integer value);
	
	/**
	 * Handle vendor id.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleVendorId(String value);
	
	/**
	 * Handle cpu family.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCpuFamily(String value);
	
	/**
	 * Handle model.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleModel(String value);
	
	/**
	 * Handle model name.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleModelName(String value);
	
	/**
	 * Handle stepping.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleStepping(String value);
	
	/**
	 * Handle cpu mhz.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCpuMhz(Float value);
	
	/**
	 * Handle cache size.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCacheSize(Long value);
	
	/**
	 * Handle physical id.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handlePhysicalId(String value);
	
	/**
	 * Handle syblings.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleSyblings(Integer value);
	
	/**
	 * Handle core id.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCoreId(String value);
	
	/**
	 * Handle cpu cores.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCpuCores(Integer value);
	
	/**
	 * Handle acpi id.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleAcpiId(String value);
	
	/**
	 * Handle initial acpi id.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleInitialAcpiId(String value);
	
	/**
	 * Handle fdiv bug.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleFdivBug(Boolean value);
	
	/**
	 * Handle hlt bug.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleHltBug(Boolean value);
	
	/**
	 * Handle f00f bug.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleF00fBug(Boolean value);
	
	/**
	 * Handle coma bug.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleComaBug(Boolean value);
	
	/**
	 * Handle fpu.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleFpu(Boolean value);
	
	/**
	 * Handle fpu exception.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleFpuException(Boolean value);
	
	/**
	 * Handle cpuid level.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCpuidLevel(String value);
	
	/**
	 * Handle wp.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleWp(String value);
	
	/**
	 * Handle flags.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleFlags(String[] value);
	
	/**
	 * Handle bogomips.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleBogomips(Float value);
	
	/**
	 * Handle clfush size.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleClfushSize(Integer value);
	
	/**
	 * Handle cache alignment.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleCacheAlignment(Integer value);
	
	/**
	 * Handle address sizes.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handleAddressSizes(String value);
	
	/**
	 * Handle power management.
	 *
	 * @param value the value
	 * @return whether to continue processing
	 */
	Boolean handlePowerManagement(String value);
}