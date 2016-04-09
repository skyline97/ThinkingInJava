package initial;

public class P8 {
	
	void m1() {
		m2();
		this.m2();
	}
	
	void m2() {
		System.out.println("m2");
	}
	
	public static void main(String[] args) {
		P8 p = new P8();
		p.m1();
	}
}
