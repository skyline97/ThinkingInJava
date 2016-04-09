package deepInContainer;

import java.util.LinkedList;
import java.util.List;

public class MySet<E> {

	private List<E> list = new LinkedList<E>();
	
	public MySet() {
	}
	
	public boolean add(E e) {
		if(contains(e))
			return false;
		
		return list.add(e);
	}
	
	public E remove(int index) {
		return list.remove(index);
	}
	
	public boolean contains(Object o) {
		return list.contains(o);
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	public static void main(String[] args) {
		MySet<Integer> set = new MySet<Integer>();
		set.add(1);
		set.add(2);
		set.add(1);
		System.out.println(set);
	}
}
