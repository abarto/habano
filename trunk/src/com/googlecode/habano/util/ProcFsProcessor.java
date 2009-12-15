package com.googlecode.habano.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	 * @param procFsLineHandler The object that will process each line of the entry.
	 * @throws IOException
	 */
	public void readProcFs(String path, ProcFsLineHandler procFsLineHandler)
			throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);

			for (String line = null; (line = bufferedReader.readLine()) != null
					&& procFsLineHandler.processLine(line);)
				;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// Close quietly
				}
			}
		}
	}
}
