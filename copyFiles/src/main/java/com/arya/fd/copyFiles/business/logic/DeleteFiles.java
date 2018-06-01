package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;


/*
 * fd_arya 12/04/2018
 */

public class DeleteFiles {
	public String deleteing(File source) throws IOException{

		if ((source).delete()) {
			return ((source).getName() + " is deleted!");
		} else {
			return ((source).getName() + "Delete operation is failed.");
		}
	}
}
