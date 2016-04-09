package polymorphic;

public class One {
	static {
		System.out.println("static one");
	}
	
	public One() {
		System.out.println("before");
		a();
		System.out.println("after");
	}
	
	
	public Grain a() {
		System.out.println("one do");
		return new Grain();
	}
}
