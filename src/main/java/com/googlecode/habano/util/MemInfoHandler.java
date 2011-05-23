package com.googlecode.habano.util;

/**
 * The Interface MemInfoHandler.
 */
public interface MemInfoHandler {
	
	/**
	 * Start.
	 *
	 * @return the boolean
	 */
	Boolean start();
	
	/**
	 * End.
	 *
	 * @return the boolean
	 */
	Boolean end();
	
	/**
	 * Handle mem total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleMemTotal(Long value);
	
	/**
	 * Handle mem free.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleMemFree(Long value);
	
	/**
	 * Handle buffers.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleBuffers(Long value);
	
	/**
	 * Handle cached.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleCached(Long value);
	
	/**
	 * Handle swap cached.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSwapCached(Long value);
	
	/**
	 * Handle active.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleActive(Long value);
	
	/**
	 * Handle inactive.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleInactive(Long value);
	
	/**
	 * Handle active anon.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleActiveAnon(Long value);
	
	/**
	 * Handle inactive anon.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleInactiveAnon(Long value);
	
	/**
	 * Handle active file.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleActiveFile(Long value);
	
	/**
	 * Handle inactive file.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleInactiveFile(Long value);
	
	/**
	 * Handle unevictable.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleUnevictable(Long value);
	
	/**
	 * Handle mlocked.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleMlocked(Long value);
	
	/**
	 * Handle high total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHighTotal(Long value);
	
	/**
	 * Handle high free.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHighFree(Long value);
	
	/**
	 * Handle low total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleLowTotal(Long value);
	
	/**
	 * Handle low free.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleLowFree(Long value);
	
	/**
	 * Handle swap total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSwapTotal(Long value);
	
	/**
	 * Handle swap free.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSwapFree(Long value);
	
	/**
	 * Handle dirty.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleDirty(Long value);
	
	/**
	 * Handle writeback.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleWriteback(Long value);
	
	/**
	 * Handle anon pages.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleAnonPages(Long value);
	
	/**
	 * Handle mapped.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleMapped(Long value);
	
	/**
	 * Handle shmem.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleShmem(Long value);
	
	/**
	 * Handle slab.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSlab(Long value);
	
	/**
	 * Handle s reclaimable.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSReclaimable(Long value);
	
	/**
	 * Handle s unreclaim.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleSUnreclaim(Long value);
	
	/**
	 * Handle kernel stack.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleKernelStack(Long value);
	
	/**
	 * Handle page tables.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handlePageTables(Long value);
	
	/**
	 * Handle nfs unstable.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleNfsUnstable(Long value);
	
	/**
	 * Handle bounce.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleBounce(Long value);
	
	/**
	 * Handle writeback tmp.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleWritebackTmp(Long value);
	
	/**
	 * Handle commit limit.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleCommitLimit(Long value);
	
	/**
	 * Handle commit as.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleCommittedAS(Long value);
	
	/**
	 * Handle vmallock total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleVmallocTotal(Long value);
	
	/**
	 * Handle vmallock used.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleVmallocUsed(Long value);
	
	/**
	 * Handle vmallock chunk.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleVmallocChunk(Long value);
	
	/**
	 * Handle hardware corrupted.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHardwareCorrupted(Long value);
	
	/**
	 * Handle huge pages total.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHugePagesTotal(Long value);
	
	/**
	 * Handle huge pages free.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHugePagesFree(Long value);
	
	/**
	 * Handle huge pages rsvd.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHugePagesRsvd(Long value);
	
	/**
	 * Handle huge pages surp.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHugePagesSurp(Long value);
	
	/**
	 * Handle hugepagesize.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleHugepagesize(Long value);
	
	/**
	 * Handle direct map4k.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleDirectMap4k(Long value);
	
	/**
	 * Handle direct map2 m.
	 *
	 * @param value the value
	 * @return the boolean
	 */
	Boolean handleDirectMap2M(Long value);
}
