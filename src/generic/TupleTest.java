package generic;

public class TupleTest {

	public static TwoTuple<String, Integer> f() {
		return Tuple.tuple("hi", 47);
	}
	
	public static TwoTuple f2() {
		return Tuple.tuple("hi", 47);
	}
	
	public static void main(String[] args) {
		System.out.println(f2());
	}
}
