package io_;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {

	public static void main(String[] args) throws IOException {
		DataInputStream in = new DataInputStream(new BufferedInputStream(
				new FileInputStream("src/eighteen/TestEOF.java")));
		while(in.available() != 0)
			System.out.print((char)in.readByte());
		in.close();
	}
}
