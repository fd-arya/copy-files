package com.arya.fd.copyFiles.view.controller;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.NoSuchPaddingException;

import com.arya.fd.copyFiles.business.logic.CopyingFiles;
import com.arya.fd.copyFiles.business.logic.DeleteFiles;
import com.arya.fd.copyFiles.business.logic.MovingFilesNew;
import com.arya.fd.copyFiles.business.logic.RenameFiles;
import com.arya.fd.copyFiles.business.service.internal.security.EncryptDecryptService;
import com.arya.fd.copyFiles.model.GetFileDirectory;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

public class MainController {
	CopyingFiles copyFile = new CopyingFiles();
	MovingFilesNew movingFile = new MovingFilesNew();
	DeleteFiles deleteFiles = new DeleteFiles();
	RenameFiles renameFiles = new RenameFiles();
	GetFileDirectory directory = new GetFileDirectory();

	private List<File> selectedFiles;
	private File selectedFile;

	private EncryptDecryptService encryptDecryptService;

	private EncryptDecryptService getService() {

		if (encryptDecryptService == null) {
			encryptDecryptService = new EncryptDecryptService();
		}

		return encryptDecryptService;
	}

	private List<File> getSelectedFiles() {
		return selectedFiles;
	}

	private File getSelectedFile() {
		return selectedFile;
	}

	private void setSelectedFiles(List<File> selectedFiles) {
		this.selectedFiles = selectedFiles;
	}

	private void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	@FXML
	public TextField newName;

	@FXML
	public TextField input;

	@FXML
	public TextField output;

	@FXML
	public Text log;

	@FXML
	public PasswordField psfPassword;

	@FXML
	public PasswordField psfKey;

	@FXML
	public void bunInputBrowas() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chooser File ...");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		setSelectedFiles(fileChooser.showOpenMultipleDialog(null));
		String selectedFileName = " ";

		for (File file : getSelectedFiles()) {
			selectedFileName = selectedFileName.concat(" { " + file.getName() + " } ");
			input.setText(selectedFileName);
		}
	}

	@FXML
	public void bunOutputBrowas() {
		
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("JavaFX Projects");
		setSelectedFile(chooser.showDialog(null));
		output.setText(" { " + getSelectedFile().getPath() + " } ");
	}

	@FXML
	public void bunRename() {
		if (input.getText().isEmpty()) {
			log.setText("Directory File is Empty !");
		} else if (newName.getText().isEmpty()) {
			log.setText("plz enter new name .");
		} else {
			try {
				directory.setSource(input.getText());
				File fileSource = new File(directory.getSource());
				log.setText(renameFiles.rename(fileSource, newName.getText()));
			} catch (IOException e) {
				log.setText(e.toString());
			}
		}
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

		if (input.getText().isEmpty() || output.getText().isEmpty()) {
			log.setText("Directory File is Empty !");
		} else {
			try {
				directory.setSource(input.getText());
				directory.setDest(output.getText());
				File fileSource = new File(directory.getSource());
				File fileDestination = new File(directory.getDest() + fileSource.getName());
				log.setText(movingFile.moveFileStream(fileSource, fileDestination));
			} catch (IOException e) {
				log.setText(e.toString());
			}
		}

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
		if (checkValidation()) {

			try {
				log.setText("Start Encrypting Files.....");
				encryptedFile();
				log.setText("Successfully Encrypting Files.");
			} catch (Exception e) {

				log.setText("Sorry,can't Encrypting. Password or SecretKey wrong.");
			}
		}
	}

	private void encryptedFile() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
			InvalidKeyException, NoSuchPaddingException, IOException {

		getService().setPassword(this.psfPassword.getText());
		getService().setKey(this.psfKey.getText());

		Map<File, File> encryptedFiles = new HashMap<>();
		for (File file : getSelectedFiles()) {

			final String ENCRYPTED_FILE_NAME = file.getParent() + "/" + file.getName() + ".nit";
			encryptedFiles.put(file, new File(ENCRYPTED_FILE_NAME));
		}
		getService().encrypted(encryptedFiles);

	}

	@FXML
	public void bunDencryption() {

	}

	private String validation() {

		String tempValidation = "";

		if (psfPassword.getText() == null && psfPassword.getText().isEmpty() || psfPassword.getText().length() != 16) {

			tempValidation = tempValidation + "password length is wrong. Enter 16 Character only.\n";
		}

		if (psfKey.getText() == null && psfPassword.getText().isEmpty() || psfKey.getText().length() != 16) {

			tempValidation = tempValidation + "secretKey length is wrong. Enter 16 Character only.\n";
		}

		// if (directory.getSource() == null || (directory.getDest()) == null ) {
		//
		// tempValidation = tempValidation + "Please Selected Files ";
		// }

		return tempValidation;
	}

	private boolean checkValidation() {

		log.setText("");

		final String VALIDATION_TEMP = validation();

		if (VALIDATION_TEMP.isEmpty()) {
			return true;
		}

		log.setText(VALIDATION_TEMP);
		return false;
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
