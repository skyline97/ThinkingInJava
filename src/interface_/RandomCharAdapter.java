package interface_;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

public class RandomCharAdapter extends RandomChar implements Readable{
	
	private int count;
	
	public RandomCharAdapter(int count) {
		this.count = count;
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if(count-- == 0)
			return -1;
		char c = next();
		cb.append(c);
		return 1;
	}
	
	public static void main(String[] args) {
		RandomCharAdapter a = new RandomCharAdapter(3);
		Scanner s = new Scanner(a);
		while(s.hasNext())
			System.out.println(s.next());
	}

	
}
