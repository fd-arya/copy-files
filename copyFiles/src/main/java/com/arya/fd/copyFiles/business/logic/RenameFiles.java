package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;

/*
 * fd_arya 12/04/2018
 */

public class RenameFiles {
	public String rename(File source, String newName) throws IOException {
		File oldfile = new File(source.toString());
		File newfile = new File(source.getParent() + "/" + newName);

		if (oldfile.renameTo(newfile)) {
			return ("File name changed succesful");
		} else {
			return ("Rename failed");
		}
	}
}
