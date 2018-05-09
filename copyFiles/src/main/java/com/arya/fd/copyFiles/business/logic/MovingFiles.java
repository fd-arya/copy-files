package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;

/*
 * fd_arya 12/04/2018
 */

public class MovingFiles {
	public static void MoveFileStream(File source, File dast) throws IOException{
		CopyingFiles copyingFiles = new CopyingFiles();
		DeleteFiles deleteFiles = new DeleteFiles();
		
		copyingFiles.copyFileStream(source, dast);
		deleteFiles.deleteing(source);
	}
}
