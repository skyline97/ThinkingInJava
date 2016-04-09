package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New {

	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	
	public static <K,V> Map<K,V> map() {
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
		Map<Integer,String> map = New.map();
	}
}
