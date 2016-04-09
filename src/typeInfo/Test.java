package typeInfo;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		System.out.println("qwe" instanceof String);
		System.out.println(String.class.isInstance("qwe"));
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al instanceof List);
		System.out.println(List.class.isInstance(al));
	}
}
