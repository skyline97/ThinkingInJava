package string_;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BinaryFile {
	
	public static byte[] read(File f) {
		FileInputStream in = null;
		byte[] result = null;
		try {
			in = new FileInputStream(f);
			try {
				result = new byte[in.available()];
				in.read(result, 0, result.length);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static byte[] read(String filename) {
		return read(new File(filename));
	}
}
