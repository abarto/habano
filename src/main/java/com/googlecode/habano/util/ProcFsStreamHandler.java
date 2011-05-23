package com.googlecode.habano.util;

import java.io.InputStream;

/**
 * 
 * An interface to describe the protocol of a proc fs entry handler.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface ProcFsStreamHandler {
	
	/**
	 * Handles the contents of a procfs entry.
	 *
	 * @param source input stream that points to the procfs entry
	 * @return <code>true</code> if the processing should continue, or
	 * <code>false</code> otherwise.
	 */
	Boolean handleContent(InputStream source);
	
	/**
	 * Signals the handler that the process has started
	 *
	 * @return <code>true</code> if the processing should continue, or
	 * <code>false</code> otherwise.
	 */
	Boolean start();
	
	/**
	 * Signals the handler that the process has ended
	 *
	 * @return <code>true</code> if the processing should continue, or
	 * <code>false</code> otherwise.
	 */
	Boolean end();
}
