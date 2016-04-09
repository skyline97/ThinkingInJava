package interface_;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class RandomDoublesAdapter extends RandomDoubles implements Readable {

	private int count;
	
	public RandomDoublesAdapter(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0)
			return -1;
		String d = String.valueOf(next()) + " ";
		cb.append(d);
		return d.length();
	}
	
	public static void main(String[] args) {
		RandomDoublesAdapter adapter = new RandomDoublesAdapter(7);
		Scanner s = new Scanner(adapter);
		while(s.hasNextDouble())
			System.out.println(s.nextDouble());
	}
}
