package interface_;

import java.util.Random;

public class DiceGame implements Game {

	private static Random ran = new Random();
	
	public void doGame() {
		System.out.println(ran.nextInt(6) + 1);
	}
	
}
