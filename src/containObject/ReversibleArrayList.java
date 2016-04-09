package containObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<E> extends ArrayList<E> {
	
	private static final long serialVersionUID = 1L;
	public ReversibleArrayList(Collection<? extends E> c) {
		super(c);
	}
	
	public Iterable<E> randomized() {
		return new Iterable<E>() {
			@Override
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					@Override
					public boolean hasNext() {
						return false;
					}
					@Override
					public E next() {
						return null;
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
				};
			}
		};
	}
	
	public Iterable<E> reverse() {
		return new Iterable<E>() {
			public Iterator<E> iterator() {
				return new Iterator<E>() {
					int current = size() - 1;
					@Override
					public boolean hasNext() {
						return current > -1;
					}
					@Override
					public E next() {
						return get(current--);
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
