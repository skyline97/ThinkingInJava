package generic;

import java.util.HashSet;
import java.util.Set;

public class Sets {

	public static <T> Set<T> union(Set<T> a,Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}
	
	public static <T> Set<T> difference(Set<T> a,Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.removeAll(b);
		return result;
	}
	
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<Integer>();
		a.add(1);
		Set<Integer> b = new HashSet<Integer>();
		b.add(2);
		Set<Integer> c = union(a,b);
		System.out.println(a);
		System.out.println(c);
	}
}
