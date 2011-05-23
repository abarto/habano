package com.googlecode.habano.util;

/**
 * Default implementation of the {@link MemInfoHandler}.
 */
public class DefaultMemInfoHandler implements MemInfoHandler {
	
	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleMemTotal(java.lang.String)
	 */
	@Override
	public Boolean handleMemTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleMemFree(java.lang.String)
	 */
	@Override
	public Boolean handleMemFree(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleBuffers(java.lang.String)
	 */
	@Override
	public Boolean handleBuffers(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleCached(java.lang.String)
	 */
	@Override
	public Boolean handleCached(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSwapCached(java.lang.String)
	 */
	@Override
	public Boolean handleSwapCached(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleActive(java.lang.String)
	 */
	@Override
	public Boolean handleActive(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleInactive(java.lang.String)
	 */
	@Override
	public Boolean handleInactive(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleActiveAnon(java.lang.String)
	 */
	@Override
	public Boolean handleActiveAnon(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleInactiveAnon(java.lang.String)
	 */
	@Override
	public Boolean handleInactiveAnon(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleActiveFile(java.lang.String)
	 */
	@Override
	public Boolean handleActiveFile(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleInactiveFile(java.lang.String)
	 */
	@Override
	public Boolean handleInactiveFile(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleUnevictable(java.lang.String)
	 */
	@Override
	public Boolean handleUnevictable(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleMlocked(java.lang.String)
	 */
	@Override
	public Boolean handleMlocked(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHighTotal(java.lang.String)
	 */
	@Override
	public Boolean handleHighTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHighFree(java.lang.String)
	 */
	@Override
	public Boolean handleHighFree(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleLowTotal(java.lang.String)
	 */
	@Override
	public Boolean handleLowTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleLowFree(java.lang.String)
	 */
	@Override
	public Boolean handleLowFree(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSwapTotal(java.lang.String)
	 */
	@Override
	public Boolean handleSwapTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSwapFree(java.lang.String)
	 */
	@Override
	public Boolean handleSwapFree(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleDirty(java.lang.String)
	 */
	@Override
	public Boolean handleDirty(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleWriteback(java.lang.String)
	 */
	@Override
	public Boolean handleWriteback(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleAnonPages(java.lang.String)
	 */
	@Override
	public Boolean handleAnonPages(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleMapped(java.lang.String)
	 */
	@Override
	public Boolean handleMapped(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleShmem(java.lang.String)
	 */
	@Override
	public Boolean handleShmem(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSlab(java.lang.String)
	 */
	@Override
	public Boolean handleSlab(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSReclaimable(java.lang.String)
	 */
	@Override
	public Boolean handleSReclaimable(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleSUnreclaim(java.lang.String)
	 */
	@Override
	public Boolean handleSUnreclaim(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleKernelStack(java.lang.String)
	 */
	@Override
	public Boolean handleKernelStack(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handlePageTables(java.lang.String)
	 */
	@Override
	public Boolean handlePageTables(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleNfsUnstable(java.lang.String)
	 */
	@Override
	public Boolean handleNfsUnstable(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleBounce(java.lang.String)
	 */
	@Override
	public Boolean handleBounce(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleWritebackTmp(java.lang.String)
	 */
	@Override
	public Boolean handleWritebackTmp(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleCommitLimit(java.lang.String)
	 */
	@Override
	public Boolean handleCommitLimit(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleCommitAS(java.lang.String)
	 */
	@Override
	public Boolean handleCommittedAS(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleVmallockTotal(java.lang.String)
	 */
	@Override
	public Boolean handleVmallocTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleVmallockUsed(java.lang.String)
	 */
	@Override
	public Boolean handleVmallocUsed(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleVmallockChunk(java.lang.String)
	 */
	@Override
	public Boolean handleVmallocChunk(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHardwareCorrupted(java.lang.String)
	 */
	@Override
	public Boolean handleHardwareCorrupted(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHugePagesTotal(java.lang.String)
	 */
	@Override
	public Boolean handleHugePagesTotal(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHugePagesFree(java.lang.String)
	 */
	@Override
	public Boolean handleHugePagesFree(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHugePagesRsvd(java.lang.String)
	 */
	@Override
	public Boolean handleHugePagesRsvd(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHugePagesSurp(java.lang.String)
	 */
	@Override
	public Boolean handleHugePagesSurp(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleHugepagesize(java.lang.String)
	 */
	@Override
	public Boolean handleHugepagesize(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleDirectMap4k(java.lang.String)
	 */
	@Override
	public Boolean handleDirectMap4k(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#handleDirectMap2M(java.lang.String)
	 */
	@Override
	public Boolean handleDirectMap2M(Long value) {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#start()
	 */
	@Override
	public Boolean start() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.MemInfoHandler#end()
	 */
	@Override
	public Boolean end() {
		return true;
	}
}
