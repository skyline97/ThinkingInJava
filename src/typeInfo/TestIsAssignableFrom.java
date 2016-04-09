package typeInfo;

import java.util.HashMap;
import java.util.Map;

public class TestIsAssignableFrom {

	Class<?> c1 = HashMap.class;
	Class<?> c2 = Map.class;
	
	public void test() {
		System.out.println(c2.isAssignableFrom(c1));
	}
	
	public static void main(String[] args) {
		new TestIsAssignableFrom().test();
	}
}
