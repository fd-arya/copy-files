package com.arya.fd.copyFiles.business.logic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * fd_arya 12/04/2018
 */

public class RenameFiles {
	public void rename(File source) throws IOException{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter new name:  ( sample: E:\\new_naame.* )");
		String newName = scanner.next();
		 File oldfile = new File(source.toString());
	      File newfile = new File(newName);

	      if(oldfile.renameTo(newfile)) {
	         System.out.println("File name changed succesful");
	      } else {
	         System.out.println("Rename failed");
	      } 
	}
}
