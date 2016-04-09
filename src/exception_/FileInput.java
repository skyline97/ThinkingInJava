package exception_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileInput {

	private BufferedReader in;
	
	public FileInput(String filename) throws FileNotFoundException {
		try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("Counld not open " + filename);
			throw e;
		}
	}
}
