package exception_;

public class InheritingExceptions {

	public void f() throws SimpleException  {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	
	public void g() throws SimpleException {
		System.out.println("Throw SimpleException from g()");
		throw new SimpleException("Originated in g()");
	}
	
	public static void main(String[] args) {
		try {
			throw new SimpleException();
		} catch (SimpleException e) {
			System.err.println("Caught:");
			e.printStackTrace();
		}
	}
}
