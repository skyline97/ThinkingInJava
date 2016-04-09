package generic;

import java.util.Map;

public class LimitsOfInference {

	static void f(Map<Integer, String> map) {}
	
	public static void main(String[] args) {
		f(New.<Integer,String>map());
	}
}
