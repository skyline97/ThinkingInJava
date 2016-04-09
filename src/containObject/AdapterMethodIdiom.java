package containObject;

import java.util.Arrays;
import java.util.List;

public class AdapterMethodIdiom {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("To be or not to be that is a question".split(" "));
		ReversibleArrayList<String> ral = new ReversibleArrayList<String>(strings);
		for(String s : ral) {
			System.out.print(s + " ");
		}
		System.out.println();
		for(String s:ral.reverse()) {
			System.out.print(s + " ");
		}
		System.out.println();
		for(String s:ral.randomized()) {
			System.out.print(s + " ");
		}
	}
}
