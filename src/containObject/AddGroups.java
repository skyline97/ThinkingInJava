package containObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AddGroups {

	public static void main(String[] args) {
		Collection<Integer> collection = null;
		Integer[] moreInts = { 6, 7, 8, 9, 10 };
		long start = System.currentTimeMillis();
		collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		collection.addAll(Arrays.asList(moreInts));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		long start2 = System.currentTimeMillis();
		Collections.addAll(collection, 11, 12, 13, 14, 15);
		Collections.addAll(collection, moreInts);
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
		
		List<Integer> list = Arrays.asList(16,17,18,19,20);
		//runtime error
		list.add(21);
		
	}
}
