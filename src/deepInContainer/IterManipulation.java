package deepInContainer;

import java.util.List;
import java.util.ListIterator;

public class IterManipulation {

	public static void iterManipulation(List<String> a) {
		ListIterator<String> it = a.listIterator();
		it.add("qqq");
		it.next();
		it.remove();
		it.next();
		it.set("www");
	}
	
	public static void main(String[] args) {
		List<String> a = Countries.names();
		System.out.println(a);
		iterManipulation(a);
		System.out.println(a);
	}
}
