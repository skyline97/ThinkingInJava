package initial;

public class TestFive {

	protected void gg() {
		System.out.println("gg");
	}
	
	void test() {
		new TestFive2().uu();
	}
	
}

class TestFive2 {
	
	void uu() {
		System.out.println("uu");
	}
}