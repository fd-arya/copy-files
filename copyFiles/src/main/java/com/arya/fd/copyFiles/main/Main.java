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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	/*
	 * fd_arya 12/04/2018
	 */

	public static void main(String[] args)  {
//		GetFileDirectory directory = new GetFileDirectory();
//		CopyingFiles copyFile = new CopyingFiles();
//		MovingFiles movingFiles = new MovingFiles();
//		DeleteFiles deleteFiles = new DeleteFiles();
//		RenameFiles renameFiles = new RenameFiles();
//		EncryptFile encryptFile = new EncryptFile();
//		DecryptFile decryptFile = new DecryptFile();
//
//		directory.setSource("E:\\1.txt");
//		directory.setDest("C:\\");
//
//		File fileSource = new File(directory.getSource());
//		File fileDestination = new File(directory.getDest() + fileSource.getName());
//
//		try {
			/*----------copy file-----------*/
			// copyFile.copyFileStream(fileSource, fileDestination);

			/*----------move file-----------*/
			// copyFile.copyFileStream(fileSource, fileDestination);
			// deleteFiles.deleteing(fileSource); //fix it!!!

			/*----------delete file-----------*/
//			 deleteFiles.deleteing(fileSource);

			/*----------rename file-----------*/
			// renameFiles.rename(fileSource);

			/*----------encryption file-----------*/
//			 encryptFile.encrypt(fileSource);

			/*----------dencryption file-----------*/
//			decryptFile.dencrypt(fileSource); // not working...
//
//		} catch (IOException e) {
//			log(e);
//		}
	
	
	launch(args);
	
	
	}

	private static void log(Object log) {
		System.out.println(String.valueOf(log));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/arya/fd/copyFiles/view/pages/MainFrom.fxml"));
		Scene scene = new Scene(fxmlLoader.<BorderPane>load());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
