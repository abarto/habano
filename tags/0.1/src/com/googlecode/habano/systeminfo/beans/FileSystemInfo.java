package com.googlecode.habano.systeminfo.beans;

/**
 * 
 * A bean to represent the status of a file system.
 * 
 * @author Agustin Barto <abarto@gmail.com>
 *
 */
public class FileSystemInfo {
	private String path;
	private long size;
	private long freeSpace;
	
	/**
	 * Default no-arguments constructor.
	 */
	public FileSystemInfo() {
	}

	/**
	 * Property <code>path</code>. The path to the root of the filesystem. It
	 * might be a mount point ("<code>/home</code>") in Linux/UNIX or a drive
	 * name in Windows ("<code>C:\</code>"). 
	 */	
	public String getPath() {
		return path;
	}

	/**
	 * Setter for the <code>path</code> property.
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * Property <code>size</code>. The total size of the file system in
	 * bytes. 
	 */		
	public long getSize() {
		return size;
	}

	/**
	 * Setter for the <code>size</code> property.
	 * 
	 * @param size
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * Property <code>freeSpace</code>. The space available on the file system
	 * in bytes.
	 */
	public long getFreeSpace() {
		return freeSpace;
	}

	/**
	 * Setter for the <code>freeSpace</code> property.
	 * 
	 * @param freeSpace
	 */
	public void setFreeSpace(long freeSpace) {
		this.freeSpace = freeSpace;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileSystemInfo [freeSpace=" + freeSpace + ", path=" + path
				+ ", size=" + size + "]";
	}
}
