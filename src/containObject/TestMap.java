package containObject;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "q");
		map.put(2, "w");
		map.put(3, null);
		System.out.println(map.get(1));
		System.out.println(map.size());
		System.out.println(map.get(3));
		System.out.println(map.get(4));
		
		Map<Integer,String> map2 = new Hashtable<Integer, String>();
		System.out.println(map2.get(1));
	}
}
