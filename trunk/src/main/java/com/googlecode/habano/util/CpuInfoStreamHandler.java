package com.googlecode.habano.util;

import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * A {@link ProcFsStreamHandler} to manage the /proc/cpuinfo contents
 */
public class CpuInfoStreamHandler implements ProcFsStreamHandler {
	
	/** The Constant POWER_MANAGEMENT. */
	private static final String POWER_MANAGEMENT = "power management";

	/** The Constant ADDRESS_SIZES. */
	private static final String ADDRESS_SIZES = "address sizes";

	/** The Constant CACHE_ALIGNMENT. */
	private static final String CACHE_ALIGNMENT = "cache_alignment";

	/** The Constant CLFLUSH_SIZE. */
	private static final String CLFLUSH_SIZE = "clflush size";

	/** The Constant BOGOMIPS. */
	private static final String BOGOMIPS = "bogomips";

	/** The Constant FLAGS. */
	private static final String FLAGS = "flags";

	/** The Constant WP. */
	private static final String WP = "wp";

	/** The Constant CPUID_LEVEL. */
	private static final String CPUID_LEVEL = "cpuid level";

	/** The Constant FPU_EXCEPTION. */
	private static final String FPU_EXCEPTION = "fpu_exception";

	/** The Constant FPU. */
	private static final String FPU = "fpu";

	/** The Constant F00F_BUG. */
	private static final String F00F_BUG = "f00f_bug";

	/** The Constant HLT_BUG. */
	private static final String HLT_BUG = "hlt_bug";

	/** The Constant FDIV_BUG. */
	private static final String FDIV_BUG = "fdiv_bug";

	/** The Constant INITIAL_ACPID. */
	private static final String INITIAL_ACPID = "initial acpid";

	/** The Constant ACPID. */
	private static final String ACPID = "acpid";

	/** The Constant CORE_ID. */
	private static final String CORE_ID = "core id";

	/** The Constant SIBLINGS. */
	private static final String SIBLINGS = "siblings";

	/** The Constant PHYSICAL_ID. */
	private static final String PHYSICAL_ID = "physical id";

	/** The Constant CACHE_SIZE. */
	private static final String CACHE_SIZE = "cache size";

	/** The Constant CPU_MHZ. */
	private static final String CPU_MHZ = "cpu MHz";

	/** The Constant STEPPING. */
	private static final String STEPPING = "stepping";

	/** The Constant MODEL_NAME. */
	private static final String MODEL_NAME = "model name";

	/** The Constant MODEL. */
	private static final String MODEL = "model";

	/** The Constant CPU_FAMILY. */
	private static final String CPU_FAMILY = "cpu family";

	/** The Constant VENDOR_ID. */
	private static final String VENDOR_ID = "vendor_id";

	/** The Constant PROCESSOR. */
	private static final String PROCESSOR = "processor";

	/** The Constant DELIMITER_PATTERN. */
	private static final Pattern DELIMITER_PATTERN = Pattern.compile("\\n|:");

	/** The cpu info handler. */
	private final CpuInfoHandler cpuInfoHandler;

	/**
	 * Instantiates a new cpu info stream handler.
	 *
	 * @param cpuInfoHandler the cpu info handler
	 */
	public CpuInfoStreamHandler(CpuInfoHandler cpuInfoHandler) {
		super();
		this.cpuInfoHandler = cpuInfoHandler;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.ProcFsStreamHandler#start()
	 */
	@Override
	public Boolean start() {
		return cpuInfoHandler.start();
	}

	/* (non-Javadoc)
	 * @see com.googlecode.habano.util.ProcFsStreamHandler#end()
	 */
	@Override
	public Boolean end() {
		return cpuInfoHandler.end();
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
			
			if (PROCESSOR.equals(token)) {
				keepProcessing = cpuInfoHandler.handleProcessor(Integer.valueOf(scanner.next().trim()));
			} else if (VENDOR_ID.equals(token)) {
				keepProcessing = cpuInfoHandler.handleVendorId(scanner.next().trim());
			} else if (CPU_FAMILY.equals(token)) {
				keepProcessing = cpuInfoHandler.handleCpuFamily(scanner.next().trim());
			} else if (MODEL.equals(token)) {
				keepProcessing = cpuInfoHandler.handleModel(scanner.next().trim());
			} else if (MODEL_NAME.equals(token)) {
				keepProcessing = cpuInfoHandler.handleModelName(scanner.next().trim());
			} else if (STEPPING.equals(token)) {
				keepProcessing = cpuInfoHandler.handleStepping(scanner.next().trim());
			} else if (CPU_MHZ.equals(token)) {
				keepProcessing = cpuInfoHandler.handleCpuMhz(Float.valueOf(scanner.next().trim()));
			} else if (CACHE_SIZE.equals(token)) {
				keepProcessing = cpuInfoHandler.handleCacheSize(Long.valueOf(scanner.next().trim().split("\\s")[0]));
			} else if (PHYSICAL_ID.equals(token)) {
				keepProcessing = cpuInfoHandler.handlePhysicalId(scanner.next().trim());
			} else if (SIBLINGS.equals(token)) {
				keepProcessing = cpuInfoHandler.handleSyblings(Integer.valueOf(scanner.next().trim()));
			} else if (CORE_ID.equals(token)) {
				keepProcessing = cpuInfoHandler.handleCoreId(scanner.next().trim());
			} else if (ACPID.equals(token)) {
				keepProcessing = cpuInfoHandler.handleAcpiId(scanner.next().trim());
			} else if (INITIAL_ACPID.equals(token)) {
				keepProcessing = cpuInfoHandler.handleInitialAcpiId(scanner.next().trim());
			} else if (FDIV_BUG.equals(token)) {
				keepProcessing = cpuInfoHandler.handleFdivBug("yes".equals(scanner.next().trim()));
			} else if (HLT_BUG.equals(token)) {
				keepProcessing = cpuInfoHandler.handleHltBug("yes".equals(scanner.next().trim()));
			} else if (F00F_BUG.equals(token)) {
				keepProcessing = cpuInfoHandler.handleF00fBug("yes".equals(scanner.next().trim()));
			} else if (FPU.equals(token)) {
				keepProcessing = cpuInfoHandler.handleFpu("yes".equals(scanner.next().trim()));
			} else if (FPU_EXCEPTION.equals(token)) {
				keepProcessing = cpuInfoHandler.handleFpuException("yes".equals(scanner.next().trim()));
			} else if (CPUID_LEVEL.equals(token)) {
				keepProcessing = cpuInfoHandler.handleCpuidLevel(scanner.next().trim());
			} else if (WP.equals(token)) {
				keepProcessing = cpuInfoHandler.handleWp(scanner.next().trim());
			} else if (FLAGS.equals(token)) {
				keepProcessing = cpuInfoHandler.handleFlags(scanner.next().trim().split("\\s"));
			} else if (BOGOMIPS.equals(token)) {
				keepProcessing = cpuInfoHandler.handleBogomips(Float.valueOf(scanner.next().trim()));
			} else if (CLFLUSH_SIZE.equals(token)) {
				keepProcessing = cpuInfoHandler.handleClfushSize(Integer.valueOf(scanner.next().trim()));
			} else if (CACHE_ALIGNMENT.equals(token)) {
				keepProcessing = cpuInfoHandler.handleClfushSize(Integer.valueOf(scanner.next().trim()));
			} else if (ADDRESS_SIZES.equals(token)) {
				keepProcessing = cpuInfoHandler.handleAddressSizes(scanner.next().trim());
			} else if (POWER_MANAGEMENT.equals(token)) {
				keepProcessing = cpuInfoHandler.handlePowerManagement(scanner.next().trim());
			}
		}
		
		return keepProcessing;
	}
}
