package object;

public class TestScope {

	public static void main(String[] args) {
		StringTest st = new StringTest();
		System.out.println(st);
		change(st);
		System.out.println(st.s);
	}
	
	public static void change(StringTest st) {
		st.s = "qwe";
		System.out.println(st);
	}
}

class StringTest {
	String s;
}
