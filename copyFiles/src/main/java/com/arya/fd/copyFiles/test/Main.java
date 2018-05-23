package com.arya.fd.copyFiles.test;

import java.io.File;
import java.io.IOException;

import com.arya.fd.copyFiles.business.logic.MovingFilesNew;
import com.arya.fd.copyFiles.model.GetFileDirectory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * fd_arya
 * 12/04/2018
 */

public class Main extends Application{

	public static void main(String[] args) {
		GetFileDirectory directory = new GetFileDirectory();

		MovingFilesNew files2 = new MovingFilesNew();
		
		directory.setSource("/home/arya/test/b/test.fd");
		directory.setDest("/home/arya/test/a/");
		
		File fileSource = new File(directory.getSource());
		File fileDestination = new File(directory.getDest() + fileSource.getName());
		
		try {
			files2.moveFileStream(fileSource, fileDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/arya/fd/copyFiles/view/pages/MainFrom.fxml"));
		Scene scene = new Scene(fxmlLoader.<BorderPane>load());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
