package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;

/*
 * fd_arya 12/04/2018
 */

public class MovingFilesNew {
	public String moveFileStream(File source, File dast) throws IOException {
		if (source.renameTo(dast)) {
			return ("The file was moved successfully to the new folder");
		} else {
			return ("The File was not moved.");
		}
	}
}
