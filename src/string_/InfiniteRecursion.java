package string_;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

	@Override
	public String toString() {
		return "InfiniteResursion address: " + super.toString() + "\n";
	}
	
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for(int i=0;i<10;i++){
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
		String q = "qwe";
		String i = q.intern();
		System.out.println(i);
	}
}
