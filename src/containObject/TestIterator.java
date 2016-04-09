package containObject;

import java.util.Iterator;

public class TestIterator implements Iterable<Integer>{

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public Integer next() {
				return null;
			}

			@Override
			public void remove() {
				
			}
		};
	}
	
	public static void main(String[] args) {
		TestIterator tit = new TestIterator();
		Iterator<Integer> it = tit.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}

}
