package interface_;

import java.util.Random;

public class RandomDoubles {
	private static Random ran = new Random(47);
	
	public double next() {
		return ran.nextDouble();
	}
	
}
