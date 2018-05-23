package com.arya.fd.copyFiles.model;

/*
 * fd_arya
 * 12/04/2018
 */

public class GetFileDirectory {

	private String source; // file directory input
	private String dest; // file directory output
	private String log;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
}
