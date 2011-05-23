package com.googlecode.habano.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * A utility class to extract information from a proc fs entry.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 * 
 */
public class ProcFsProcessor {
	
	/**
	 * Process an entry in a mounted proc fs using the supplied handler. Each
	 * line read from the path is going to be fed to the handler which in its
	 * turn will return if the processing should continue or not.
	 *
	 * @param path The path to process
	 * @param procFsReaderHandler The object that will process the contents of the procfs entry
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void readProcFs(final String path, final ProcFsStreamHandler procFsReaderHandler)
			throws IOException {
		InputStream inputStream = null;

		try {
			if (procFsReaderHandler.start()) {
				inputStream = new FileInputStream(path);
				
				@SuppressWarnings("unused")
				Boolean result = procFsReaderHandler.handleContent(inputStream) && procFsReaderHandler.end();
			}			
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// Close quietly
				}
			}
		}
	}
	
	public void readCpuInfo(CpuInfoHandler cpuInfoHandler) throws IOException { 
		this.readProcFs("/proc/cpuinfo", new CpuInfoStreamHandler(cpuInfoHandler));
	}
	
	public void readMemInfo(MemInfoHandler memInfoHandler) throws IOException {
		this.readProcFs("/proc/meminfo", new MemInfoStreamHandler(memInfoHandler));
	}
}
