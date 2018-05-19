package com.arya.fd.copyFiles.view.controller;

import java.io.File;
import java.io.IOException;

//import javax.swing.JFileChooser;
//import javax.swing.filechooser.FileNameExtensionFilter;

import com.arya.fd.copyFiles.business.logic.CopyingFiles;
import com.arya.fd.copyFiles.business.logic.DeleteFiles;
import com.arya.fd.copyFiles.model.GetFileDirectory;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class MainController {

	CopyingFiles copyFile = new CopyingFiles();
	
	DeleteFiles deleteFiles = new DeleteFiles();
	
	GetFileDirectory directory = new GetFileDirectory();

//	 File fileSource = new File(directory.getSource());
//	 File fileDestination = new File(directory.getDest() + fileSource.getName());

	@FXML
	public TextField newName;

	@FXML
	public TextField input;

	@FXML
	public TextField output;

	@FXML
	public Text log;

	@FXML
	public void bunInputBrowas() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chooser File ...");
		File selectfile = fileChooser.showOpenDialog(null);
		if (selectfile != null) {
			input.setText(selectfile.getPath());
		} else {
			log.setText("Selecte file cancel .");
		}
	}

	@FXML
	public void bunOutputBrowas() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chooser Directory File ...");
		File selectfile = fileChooser.showSaveDialog(null);
		if (selectfile != null) {
			output.setText(selectfile.getPath());
		} else {
			log.setText("Directory file cancel .");
		}
	}

	@FXML
	public void bunRename() {

	}

	@FXML
	public void bunCopy() {

		if (input.getText().isEmpty() || output.getText().isEmpty()) {
				log.setText("Directory File is Empty !");
		} else {
			 try {
				 directory.setSource(input.getText());
				 directory.setDest(output.getText());
				 File fileSource = new File(directory.getSource());
				 File fileDestination = new File(directory.getDest());

			 copyFile.copyFileStream(fileSource, fileDestination);
			 log.setText("file copy .");
			 } catch (IOException e) {
			 log.setText(e.toString());
			 }
		}
	}

	@FXML
	public void bunMove() {

	}

	@FXML
	public void bunDelete() {
		if (input.getText().isEmpty()) {
			log.setText("Directory File is Empty !");
	} else {
		 try {
			 directory.setSource(input.getText());
			 File fileSource = new File(directory.getSource());

			 deleteFiles.deleteing(fileSource);
		 log.setText("delete file .");
		 } catch (IOException e) {
		 log.setText(e.toString());
		 }
	}
	}

	@FXML
	public void bunEncryption() {

	}

	@FXML
	public void bunDencryption() {

	}
	
	@FXML
	public void clear() {
		log.setText("");
	}

	@FXML
	public void bunQuit() {
		System.exit(0);
	}

	@FXML
	public void mnuClose() {
		System.exit(0);
	}
}
