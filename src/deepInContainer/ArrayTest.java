package deepInContainer;

public class ArrayTest {

	public static void main(String[] args) {
		String[] ss = new String[10];
		Object[] os = ss;
		os[1] = new Object();
	}
	
	public static <T> T[] returnArray() {
		return (T[])new Object[10];
	}
}
