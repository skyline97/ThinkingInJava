package generic;

public class SelfBoundedMethods {

	static <T extends SelfBounded<T>> T f(T arg) {
		return arg.set(arg).get();
	}
	
	public static void main(String[] args) {
		A a = f(new A());
		System.out.println(a);
	}
}
