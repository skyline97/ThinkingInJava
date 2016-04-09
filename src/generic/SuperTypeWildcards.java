package generic;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {

	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
		//apples.add(new Fruit());
		System.out.println(apples);
	}
	
//	static void writeTo2(List<? extends Apple> apples) {
//		apples.add(new Apple());
//		apples.add(new Object());
//		apples.add(new Jonathan());
//	}
	
	public static void main(String[] args) {
		writeTo(new ArrayList<Fruit>());
	}
}
