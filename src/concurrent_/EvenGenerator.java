package concurrent_;

public class EvenGenerator extends IntGenerator{

	private int currentEvenValue = 0;
	
	@Override
	public synchronized int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
