package com.arya.fd.copyFiles.main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import com.arya.fd.copyFiles.business.logic.CopyingFiles;
import com.arya.fd.copyFiles.business.logic.DecryptFile;
import com.arya.fd.copyFiles.business.logic.DeleteFiles;
import com.arya.fd.copyFiles.business.logic.EncryptFile;
import com.arya.fd.copyFiles.business.logic.MovingFiles;
import com.arya.fd.copyFiles.business.logic.RenameFiles;
import com.arya.fd.copyFiles.business.service.internal.security.Encryption;
import com.arya.fd.copyFiles.model.GetFileDirectory;

public class Main {

	/*
	 * fd_arya 12/04/2018
	 */

	public static void main(String[] args) {
		GetFileDirectory directory = new GetFileDirectory();
		CopyingFiles copyFile = new CopyingFiles();
		MovingFiles movingFiles = new MovingFiles();
		DeleteFiles deleteFiles = new DeleteFiles();
		RenameFiles renameFiles = new RenameFiles();
		EncryptFile encryptFile = new EncryptFile();
		DecryptFile decryptFile = new DecryptFile();

		directory.setSource("E:\\1.txt");
		directory.setDest("C:\\");

		File fileSource = new File(directory.getSource());
		File fileDestination = new File(directory.getDest() + fileSource.getName());

		try {
			/*----------copy file-----------*/
			// copyFile.copyFileStream(fileSource, fileDestination);

			/*----------move file-----------*/
			// copyFile.copyFileStream(fileSource, fileDestination);
			// deleteFiles.deleteing(fileSource); //fix it!!!

			/*----------delete file-----------*/
			// deleteFiles.deleteing(fileSource);

			/*----------rename file-----------*/
			// renameFiles.rename(fileSource);

			/*----------encryption file-----------*/
			// encryptFile.encrypt(fileSource);

			/*----------dencryption file-----------*/
			decryptFile.dencrypt(fileSource); // not working...

		} catch (IOException e) {
			log(e);
		}
	}

	private static void log(Object log) {
		System.out.println(String.valueOf(log));
	}
}
