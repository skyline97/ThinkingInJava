package interface_;

public abstract class Super {
	
	void say() {
		System.out.println("haha");
	}
	
	abstract void talk();
	
	static void f() {
		System.out.println("f");
	}
	
	public abstract void g();
	
	public static void main(String[] args) {
		f();
	}
}
