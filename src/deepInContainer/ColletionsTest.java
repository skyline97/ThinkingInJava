package deepInContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class ColletionsTest {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Map<Integer,String> safeMap = Collections.checkedMap(map, Integer.class, String.class);
		safeMap.put(1, "qwe");
		System.out.println(safeMap);
		System.out.println(map);
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(23,546,443,224,6,34,34,5,346,23,42));
		System.out.println(Collections.max(list));
		
		List<Integer> umList = Collections.unmodifiableList(list);
		System.out.println(umList);
		list.add(10000);
		System.out.println(umList);
		
		List<Integer> l = new ArrayList<Integer>();
		ListIterator<Integer> it = l.listIterator();
		it.add(123);
	}
}
