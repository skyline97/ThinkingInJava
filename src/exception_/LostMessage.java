package exception_;

public class LostMessage {
	
	void f() throws Exception1 {
		throw new Exception1();
	}
	
	void g() throws Exception2 {
		throw new Exception2();
	}

	public static void main(String[] args) {
		LostMessage l = new LostMessage();
		try {
			try {
				l.f();
			} catch(Exception1 e) {
				e.printStackTrace();
			} finally {
				l.g();
			}
		} catch (Exception2 e) {
			e.printStackTrace();
		}
	}
}

class Exception1 extends Exception {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "exception1";
	}
}

class Exception2 extends Exception {

	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "exception2";
	}
}