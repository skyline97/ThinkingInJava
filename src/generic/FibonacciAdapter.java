package generic;

import java.util.Iterator;

public class FibonacciAdapter extends Fibonacci implements Iterable<Integer>{
	
	private int size;
	
	@Override
	public Integer next() {
		return super.next();
	}
	
	public FibonacciAdapter(int size) {
		this.size = size;
	}

	@Override
	public Iterator<Integer> iterator() {
		final int count = size;
		
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return count > 0;
			}
			@Override
			public Integer next() {
				size--;
				return FibonacciAdapter.this.next();
			}
			@Override
			public void remove() {
				
			}
		};
	}
	
}
