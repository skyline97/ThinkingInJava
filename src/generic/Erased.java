package generic;

public class Erased<T> {

	private static final int SIZE = 100;
	
	public static void f(Object arg) {
		//全都无法编译通过
//		if(arg instanceof T) {}
//		T var = new T();
//		T[] array = new T[SIZE];
//		T[] array = (T)new Object[SIZE];
	}
}
