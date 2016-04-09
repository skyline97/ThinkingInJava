package generic;

public class TwoTuple<A,B> {
	public final A first;
	public final B second;
	
	public TwoTuple(A a,B b) {
		this.first = a;
		this.second = b;
	}
	
	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
	
	public static void main(String[] args) {
		TwoTuple<AClass,BClass> tt = new TwoTuple<AClass, BClass>(new AClass(), new BClass());
		tt.first.setA(12);
		System.out.println(tt);
	}
}
