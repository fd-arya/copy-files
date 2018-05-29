package com.arya.fd.copyFiles.main;

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
		
//		EncryptFile encryptFile = new EncryptFile();
//		DecryptFile decryptFile = new DecryptFile();
			/*----------encryption file-----------*/
//			 encryptFile.encrypt(fileSource);
			/*----------dencryption file-----------*/
//			decryptFile.dencrypt(fileSource); // not working...
	
	launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/arya/fd/copyFiles/view/pages/MainFrom.fxml"));
		Scene scene = new Scene(fxmlLoader.<BorderPane>load());
		primaryStage.setScene(scene);
		primaryStage.setTitle("file manger");
		primaryStage.show();
	}
}
