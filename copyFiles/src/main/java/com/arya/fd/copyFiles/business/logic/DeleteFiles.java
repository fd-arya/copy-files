package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;


/*
 * fd_arya 12/04/2018
 */

public class DeleteFiles {
	public void deleteing(File source) throws IOException{

		if (source.delete()) {
			System.out.println(source.getName() + " is deleted!");
		} else {
			System.out.println("Delete operation is failed.");
		}
	}
}
