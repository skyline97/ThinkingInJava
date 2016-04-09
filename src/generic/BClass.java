package generic;

public class BClass<B> extends AClass{
	
	private int b;
	
	public BClass() {
		b = 0;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return String.valueOf(b);
	}
	
	public static void main(String[] args) {
		System.out.println("bbbb");
	}
	
}
