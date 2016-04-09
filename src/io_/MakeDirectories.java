package io_;

import java.io.File;
import java.util.Date;

public class MakeDirectories {
	
	private static void fileData(File f) {
		System.out.println(
				"Absolute path:" + f.getAbsolutePath() +
				"\n Can read: " + f.canRead() +
				"\n Can write: " + f.canWrite() + 
				"\n getName: " + f.getName() +
				"\n getParent: " + f.getParent() +
				"\n getPath: " + f.getPath() + 
				"\n length: " + f.length() + 
				"\n lastModified: " + new Date(f.lastModified()));
		
		if(f.isFile())
			System.out.println("It's a file");
		else if(f.isDirectory())
			System.out.println("It's a directory");
	}
	
	public static void main(String[] args) {
		File old = new File("E:/temp/transaction2.txt");
		File rname = new File("E:/temp/transaction.txt");
		old.renameTo(rname);
		fileData(old);
		fileData(rname);
	}
}
