package exception_;

public class TestException {

	public void f() {
		g();
	}
	
	public void g() {
		try {
			throw new MyException2();
		} catch (MyException2 e) {
			e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestException te = new TestException();
		te.f();
	}
}
