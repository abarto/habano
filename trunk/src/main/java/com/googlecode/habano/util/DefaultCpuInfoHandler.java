package com.googlecode.habano.util;

/**
 * Default implementation of the {@link CpuInfoHandler}.
 */
public class DefaultCpuInfoHandler implements CpuInfoHandler {

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#start()
	 */
	@Override
	public Boolean start() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#end()
	 */
	@Override
	public Boolean end() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleProcessor(java.lang.String)
	 */
	@Override
	public Boolean handleProcessor(Integer value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleVendorId(java.lang.String)
	 */
	@Override
	public Boolean handleVendorId(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCpuFamily(java.lang.String)
	 */
	@Override
	public Boolean handleCpuFamily(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleModel(java.lang.String)
	 */
	@Override
	public Boolean handleModel(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleModelName(java.lang.String)
	 */
	@Override
	public Boolean handleModelName(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleStepping(java.lang.String)
	 */
	@Override
	public Boolean handleStepping(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCpuMhz(java.lang.String)
	 */
	@Override
	public Boolean handleCpuMhz(Float value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCacheSize(java.lang.String)
	 */
	@Override
	public Boolean handleCacheSize(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handlePhysicalId(java.lang.String)
	 */
	@Override
	public Boolean handlePhysicalId(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleSyblings(java.lang.String)
	 */
	@Override
	public Boolean handleSyblings(Integer value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCoreId(java.lang.String)
	 */
	@Override
	public Boolean handleCoreId(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCpuCores(java.lang.String)
	 */
	@Override
	public Boolean handleCpuCores(Integer value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleAcpiId(java.lang.String)
	 */
	@Override
	public Boolean handleAcpiId(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleInitialAcpiId(java.lang.String)
	 */
	@Override
	public Boolean handleInitialAcpiId(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleFdivBug(java.lang.String)
	 */
	@Override
	public Boolean handleFdivBug(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleHltBug(java.lang.String)
	 */
	@Override
	public Boolean handleHltBug(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleF00fBug(java.lang.String)
	 */
	@Override
	public Boolean handleF00fBug(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleComaBug(java.lang.String)
	 */
	@Override
	public Boolean handleComaBug(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleFpu(java.lang.String)
	 */
	@Override
	public Boolean handleFpu(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleFpuException(java.lang.String)
	 */
	@Override
	public Boolean handleFpuException(Boolean value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCpuidLevel(java.lang.String)
	 */
	@Override
	public Boolean handleCpuidLevel(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleWp(java.lang.String)
	 */
	@Override
	public Boolean handleWp(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleFlags(java.lang.String)
	 */
	@Override
	public Boolean handleFlags(String[] value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleBogomips(java.lang.String)
	 */
	@Override
	public Boolean handleBogomips(Float value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleClfushSize(java.lang.String)
	 */
	@Override
	public Boolean handleClfushSize(Integer value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleCacheAlignment(java.lang.String)
	 */
	@Override
	public Boolean handleCacheAlignment(Integer value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handleAddressSizes(java.lang.String)
	 */
	@Override
	public Boolean handleAddressSizes(String value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.CpuInfoHandler#handlePowerManagement(java.lang.String)
	 */
	@Override
	public Boolean handlePowerManagement(String value) {
		return true;
	}
}
