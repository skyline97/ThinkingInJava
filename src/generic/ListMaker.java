package generic;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {

	List<T> create(T t,int n) {
		List<T> result =  new ArrayList<T>();
		for(int i=0;i<n;i++) {
			result.add(t);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListMaker<String> maker = new ListMaker<String>();
		List<String> list = maker.create("Hello",5);
		System.out.println(list);
		System.out.println(Coffee.class.isInstance(new Latte()));
	}
}
