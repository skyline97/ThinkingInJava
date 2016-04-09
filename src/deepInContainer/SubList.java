package deepInContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubList {
	

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		List<Integer> sublist = list.subList(0, 3);
		list.add(11);
		sublist.add(12);
	}
}
