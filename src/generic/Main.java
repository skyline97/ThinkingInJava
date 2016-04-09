package generic;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("q");
		al.add("w");
		
		accept(al);
		System.out.println(List.class.isAssignableFrom(ArrayList.class));
	}
	
	public static void accept(ArrayList<?> al) {
		for(Object o:al) {
			System.out.println(o);
		}
	}
}

