package interface_;

import java.util.Random;

public class CoinGame implements Game {
	
	private static Random ran = new Random();

	public void doGame() {
		System.out.println(ran.nextInt(2));
	}
	
}
