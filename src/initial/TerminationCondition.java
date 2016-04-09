package initial;

public class TerminationCondition {

	public static void main(String[] args) {
		Book novel = new Book(true);
		novel.checkIn();
		for(int i=0;i<100;i++)
			new Book(true);
		System.gc();
	}
}
