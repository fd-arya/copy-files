package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.arya.fd.copyFiles.business.service.internal.security.Encryption;

/*
 * fd_arya 12/04/2018
 */

public class DecryptFile {
	public void dencrypt(File source) throws IOException {
		Encryption encryption = new Encryption();
		byte[] enc = null;
		byte[] b = new byte[(int) source.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(source);
			FileOutputStream fileOutputStream = new FileOutputStream(source);
			fileInputStream.read(b);
			for (int i = 0; i < b.length; i++) {
				enc = new byte[(char) b[i]];
			}
			try {
				fileOutputStream.write(encryption.decrypt(enc));
			} catch (Exception e) {
				e.printStackTrace();
			}
			fileOutputStream.close();
		} catch (IOException e1) {
			System.out.println("Error Reading The File.");
			e1.printStackTrace();
		}
	}
}
