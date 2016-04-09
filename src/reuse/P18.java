package reuse;

import java.util.Random;

public class P18 {
	
	private static Random ran = new Random();

	private final int s1 = ran.nextInt(10);
	
	private static final int S2 = ran.nextInt(10);
	
	public static void main(String[] args) {
		System.out.println(new P18().s1);
		System.out.println(new P18().s1);
		System.out.println(S2);
		System.out.println(S2);
	}
}
