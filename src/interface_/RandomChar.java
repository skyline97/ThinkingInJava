package interface_;

import java.util.Random;

public class RandomChar {

	private static Random ran = new Random();
	
	private static final char[] CS = "pfw".toCharArray();
	
	public char next() {
		return CS[ran.nextInt(3)];
	}
	
	public static void main(String[] args) {
		RandomChar rc = new RandomChar();
		System.out.println(rc.next());
	}
}
