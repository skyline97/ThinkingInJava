package interface_;

public class Sub extends Super {
	
	public static void main(String[] args) {
		Super s = new Sub();
		f();
	}
	
	public static void f() {
		System.out.println("ff");
	}

	@Override
	void talk() {
	}

	@Override
	public void g() {
	}
}
