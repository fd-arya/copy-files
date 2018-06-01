package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * fd_arya
 * 12/04/2018
 */

public class CopyingFiles {
	public String copyFileStream(File source, File dast) throws IOException {
		InputStream inputStream = new FileInputStream(source);
		OutputStream outputStream = new FileOutputStream(dast);

		byte[] buffer = new byte[1024];

		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		return source.getName()  + "Copy successfully";
	}
}
