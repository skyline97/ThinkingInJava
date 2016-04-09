package concurrent;

public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {

	protected GrumpyBoundedBuffer(int cap) {
		super(cap);
	}
	
	public synchronized void put(V v) {
		if(isFull())
			//throw new BufferFullException();
			;
		doput(v);
	}
	
	public synchronized V take() {
		if(isEmpty())
			//throw new BufferEmptyException();
			;
		return dotake();
	}
	
}
