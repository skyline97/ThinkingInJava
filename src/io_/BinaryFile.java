package io_;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class BinaryFile {

	public static byte[] read(File bFile) throws IOException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(bFile));
		try {
			byte[] data = new byte[in.available()];
			in.read(data);
			return data;
		} finally {
			in.close();
		}
	}
	
	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile));
	}
	
	public static void write(String destFile,byte[] data) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream(new File(destFile),true));
		try {
			out.write(data);
		} finally {
			out.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		byte[] data = read("src/eighteen/BinaryFile.java");
		write("BinaryFile.java", data);
	}
}
