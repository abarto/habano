package com.googlecode.habano.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcFsProcessor {
	public void readProcFs(String path, ProcFsEntryHandler procFsEntryHandler) throws IOException {
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			fileReader = new FileReader(path);
			bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			
			while ((line = bufferedReader.readLine()) != null) {
				procFsEntryHandler.handleEntry(line);
			}
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
