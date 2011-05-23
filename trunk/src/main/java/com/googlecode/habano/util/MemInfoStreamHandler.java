package com.googlecode.habano.util;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * A handler for the contents of the meminfo procfs entry
 */
public class MemInfoStreamHandler implements ProcFsStreamHandler {
	
	/** The Constant DIRECT_MAP2M. */
	private static final String DIRECT_MAP2M = "DirectMap2M";

	/** The Constant DIRECT_MAP4K. */
	private static final String DIRECT_MAP4K = "DirectMap4k";

	/** The Constant HUGEPAGESIZE. */
	private static final String HUGEPAGESIZE = "Hugepagesize";

	/** The Constant HUGE_PAGES_SURP. */
	private static final String HUGE_PAGES_SURP = "HugePages_Surp";

	/** The Constant HUGE_PAGES_RSVD. */
	private static final String HUGE_PAGES_RSVD = "HugePages_Rsvd";

	/** The Constant HUGE_PAGES_FREE. */
	private static final String HUGE_PAGES_FREE = "HugePages_Free";

	/** The Constant HUGE_PAGES_TOTAL. */
	private static final String HUGE_PAGES_TOTAL = "HugePages_Total";

	/** The Constant HARDWARE_CORRUPTED. */
	private static final String HARDWARE_CORRUPTED = "HardwareCorrupted";

	/** The Constant VMALLOC_CHUNK. */
	private static final String VMALLOC_CHUNK = "VmallocChunk";

	/** The Constant VMALLOC_USED. */
	private static final String VMALLOC_USED = "VmallocUsed";

	/** The Constant VMALLOC_TOTAL. */
	private static final String VMALLOC_TOTAL = "VmallocTotal";

	/** The Constant COMMITTED_AS. */
	private static final String COMMITTED_AS = "Committed_AS";

	/** The Constant COMMIT_LIMIT. */
	private static final String COMMIT_LIMIT = "CommitLimit";

	/** The Constant WRITEBACK_TMP. */
	private static final String WRITEBACK_TMP = "WritebackTmp";

	/** The Constant BOUNCE. */
	private static final String BOUNCE = "Bounce";

	/** The Constant NFS_UNSTABLE. */
	private static final String NFS_UNSTABLE = "NFS_Unstable";

	/** The Constant PAGE_TABLES. */
	private static final String PAGE_TABLES = "PageTables";

	/** The Constant KERNEL_STACK. */
	private static final String KERNEL_STACK = "KernelStack";

	/** The Constant S_UNRECLAIM. */
	private static final String S_UNRECLAIM = "SUnreclaim";

	/** The Constant S_RECLAIMABLE. */
	private static final String S_RECLAIMABLE = "SReclaimable";

	/** The Constant SLAB. */
	private static final String SLAB = "Slab";

	/** The Constant SHMEM. */
	private static final String SHMEM = "Shmem";

	/** The Constant MAPPED. */
	private static final String MAPPED = "Mapped";

	/** The Constant ANON_PAGES. */
	private static final String ANON_PAGES = "AnonPages";

	/** The Constant WRITEBACK. */
	private static final String WRITEBACK = "Writeback";

	/** The Constant DIRTY. */
	private static final String DIRTY = "Dirty";

	/** The Constant SWAP_FREE. */
	private static final String SWAP_FREE = "SwapFree";

	/** The Constant SWAP_TOTAL. */
	private static final String SWAP_TOTAL = "SwapTotal";

	/** The Constant LOW_FREE. */
	private static final String LOW_FREE = "LowFree";

	/** The Constant LOW_TOTAL. */
	private static final String LOW_TOTAL = "LowTotal";

	/** The Constant HIGH_FREE. */
	private static final String HIGH_FREE = "HighFree";

	/** The Constant HIGH_TOTAL. */
	private static final String HIGH_TOTAL = "HighTotal";

	/** The Constant MLOCKED. */
	private static final String MLOCKED = "Mlocked";

	/** The Constant UNEVICTABLE. */
	private static final String UNEVICTABLE = "Unevictable";

	/** The Constant INACTIVE_FILE. */
	private static final String INACTIVE_FILE = "Inactive(file)";

	/** The Constant ACTIVE_FILE. */
	private static final String ACTIVE_FILE = "Active(file)";

	/** The Constant INACTIVE_ANON. */
	private static final String INACTIVE_ANON = "Inactive(anon)";

	/** The Constant ACTIVE_ANON. */
	private static final String ACTIVE_ANON = "Active(anon)";

	/** The Constant INACTIVE. */
	private static final String INACTIVE = "Inactive";

	/** The Constant ACTIVE. */
	private static final String ACTIVE = "Active";

	/** The Constant SWAP_CACHED. */
	private static final String SWAP_CACHED = "SwapCached";

	/** The Constant CACHED. */
	private static final String CACHED = "Cached";

	/** The Constant BUFFERS. */
	private static final String BUFFERS = "Buffers";

	/** The Constant MEM_FREE. */
	private static final String MEM_FREE = "MemFree";

	/** The Constant MEM_TOTAL. */
	private static final String MEM_TOTAL = "MemTotal";

	/** The Constant DELIMITER_PATTERN. */
	private static final Pattern DELIMITER_PATTERN = Pattern.compile("\\n|:");

	/** The mem info handler. */
	private final MemInfoHandler memInfoHandler;

	/**
	 * Instantiates a new mem info stream handler.
	 *
	 * @param memInfoHandler the mem info handler
	 */
	public MemInfoStreamHandler(MemInfoHandler memInfoHandler) {
		super();
		this.memInfoHandler = memInfoHandler;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.ProcFsStreamHandler#handleContent(java.io.InputStream)
	 */
	@Override
	public Boolean handleContent(InputStream source) {
		Boolean keepProcessing = true;
		
		final Scanner scanner = new Scanner(source);
		scanner.useDelimiter(DELIMITER_PATTERN);
		
		String token = null;
		
		while (keepProcessing && scanner.hasNext()) {
			token = scanner.next().trim();
			
			if (MEM_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleMemTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (MEM_FREE.equals(token)) {
				keepProcessing = memInfoHandler.handleMemFree(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (BUFFERS.equals(token)) {
				keepProcessing = memInfoHandler.handleBuffers(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (CACHED.equals(token)) {
				keepProcessing = memInfoHandler.handleCached(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (SWAP_CACHED.equals(token)) {
				keepProcessing = memInfoHandler.handleSwapCached(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (ACTIVE.equals(token)) {
				keepProcessing = memInfoHandler.handleActive(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (INACTIVE.equals(token)) {
				keepProcessing = memInfoHandler.handleInactive(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (ACTIVE_ANON.equals(token)) {
				keepProcessing = memInfoHandler.handleActiveAnon(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (INACTIVE_ANON.equals(token)) {
				keepProcessing = memInfoHandler.handleInactiveAnon(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (ACTIVE_FILE.equals(token)) {
				keepProcessing = memInfoHandler.handleActiveFile(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (INACTIVE_FILE.equals(token)) {
				keepProcessing = memInfoHandler.handleInactiveFile(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (UNEVICTABLE.equals(token)) {
				keepProcessing = memInfoHandler.handleUnevictable(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (MLOCKED.equals(token)) {
				keepProcessing = memInfoHandler.handleMlocked(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HIGH_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleHighTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HIGH_FREE.equals(token)) {
				keepProcessing = memInfoHandler.handleHighFree(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (LOW_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleLowTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (LOW_FREE.equals(token)) {
				keepProcessing = memInfoHandler.handleLowFree(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (SWAP_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleSwapTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (SWAP_FREE.equals(token)) {
				keepProcessing = memInfoHandler.handleSwapFree(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (DIRTY.equals(token)) {
				keepProcessing = memInfoHandler.handleDirty(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (WRITEBACK.equals(token)) {
				keepProcessing = memInfoHandler.handleWriteback(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (ANON_PAGES.equals(token)) {
				keepProcessing = memInfoHandler.handleAnonPages(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (MAPPED.equals(token)) {
				keepProcessing = memInfoHandler.handleMapped(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (SHMEM.equals(token)) {
				keepProcessing = memInfoHandler.handleShmem(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (SLAB.equals(token)) {
				keepProcessing = memInfoHandler.handleSlab(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (S_RECLAIMABLE.equals(token)) {
				keepProcessing = memInfoHandler.handleSReclaimable(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (S_UNRECLAIM.equals(token)) {
				keepProcessing = memInfoHandler.handleSUnreclaim(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (KERNEL_STACK.equals(token)) {
				keepProcessing = memInfoHandler.handleKernelStack(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (PAGE_TABLES.equals(token)) {
				keepProcessing = memInfoHandler.handlePageTables(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (NFS_UNSTABLE.equals(token)) {
				keepProcessing = memInfoHandler.handleNfsUnstable(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (BOUNCE.equals(token)) {
				keepProcessing = memInfoHandler.handleBounce(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (WRITEBACK_TMP.equals(token)) {
				keepProcessing = memInfoHandler.handleWritebackTmp(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (COMMIT_LIMIT.equals(token)) {
				keepProcessing = memInfoHandler.handleCommitLimit(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (COMMITTED_AS.equals(token)) {
				keepProcessing = memInfoHandler.handleCommittedAS(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (VMALLOC_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleVmallocTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (VMALLOC_USED.equals(token)) {
				keepProcessing = memInfoHandler.handleVmallocUsed(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (VMALLOC_CHUNK.equals(token)) {
				keepProcessing = memInfoHandler.handleVmallocChunk(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HARDWARE_CORRUPTED.equals(token)) {
				keepProcessing = memInfoHandler.handleHardwareCorrupted(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HUGE_PAGES_TOTAL.equals(token)) {
				keepProcessing = memInfoHandler.handleHugePagesTotal(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HUGE_PAGES_FREE.equals(token)) {
				keepProcessing = memInfoHandler.handleHugePagesFree(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HUGE_PAGES_RSVD.equals(token)) {
				keepProcessing = memInfoHandler.handleHugePagesRsvd(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HUGE_PAGES_SURP.equals(token)) {
				keepProcessing = memInfoHandler.handleHugePagesSurp(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (HUGEPAGESIZE.equals(token)) {
				keepProcessing = memInfoHandler.handleHugepagesize(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (DIRECT_MAP4K.equals(token)) {
				keepProcessing = memInfoHandler.handleDirectMap4k(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (DIRECT_MAP2M.equals(token)) {
				keepProcessing = memInfoHandler.handleDirectMap2M(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			}
		}

		return keepProcessing;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.ProcFsStreamHandler#start()
	 */
	@Override
	public Boolean start() {
		return memInfoHandler.start();
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.ProcFsStreamHandler#end()
	 */
	@Override
	public Boolean end() {
		return memInfoHandler.end();
	}

}
