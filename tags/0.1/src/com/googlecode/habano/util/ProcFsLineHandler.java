package com.googlecode.habano.util;

/**
 * 
 * An interface to describe the protocol of a proc fs entry handler.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public interface ProcFsLineHandler {
	/**
	 * Handles each line read from a proc fs path.
	 * 
	 * @param line The line read from a proc fs path.
	 * @return <code>true</code> if the processing should continue, or
	 * <code>false</code> otherwise.
	 */
	Boolean processLine(String line);
}
