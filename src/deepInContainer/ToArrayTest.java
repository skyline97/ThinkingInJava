package deepInContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArrayTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString(arr));
		
		Integer[] intArr = list.toArray(new Integer[10]);
		System.out.println(Arrays.toString(intArr));
	}
}
