package generic;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {

	public static void main(String[] args) {
		List<? extends Fruit> flist = Arrays.asList(new Apple());
		//flist.add(e);
		Apple a = (Apple)flist.get(0);
		System.out.println(a);
		boolean b = flist.contains(new Apple());
		System.out.println(b);
		int index = flist.indexOf(new Apple());
		System.out.println(index);
	}
}
