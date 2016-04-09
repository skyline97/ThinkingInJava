package generic;

public class AClass {
	
	static  {
		System.out.println("aaa");
	}

	private int a;
	
	public AClass() {
		a = 0;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	@Override
	public String toString() {
		return String.valueOf(a);
	}
	
}
