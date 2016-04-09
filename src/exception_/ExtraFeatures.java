package exception_;

public class ExtraFeatures {

	public static void f() throws MyException2{
		System.out.println("Throwing MyException2 from f()");
		throw new MyException2();
	}
	
	public static void g() throws MyException2{
		System.out.println("Throwing MyException2 from g()");
		throw new MyException2("Originated in g()");
	}
	
	public static void h() throws MyException2{
		System.out.println("Throwing MyException2 from h()");
		throw new MyException2("Originated in h()",47);
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
		}
		try {
			h();
		} catch (MyException2 e) {
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
	}
}
