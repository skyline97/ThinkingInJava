package containObject;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestListIterator {

	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> l1 = new LinkedList<Integer>(list);
		List<Integer> l2 = new LinkedList<Integer>(list);
		
		ListIterator<Integer> it1 = l1.listIterator(l1.size());
		
		while(it1.hasPrevious())
			l2.add(it1.previous());
		
		System.out.println(l2);
	}
}
