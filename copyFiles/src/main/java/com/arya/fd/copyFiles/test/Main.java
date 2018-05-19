package com.arya.fd.copyFiles.test;

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

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/arya/fd/copyFiles/view/pages/MainFrom.fxml"));
		Scene scene = new Scene(fxmlLoader.<BorderPane>load());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
