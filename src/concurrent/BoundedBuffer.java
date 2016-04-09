package concurrent;

public class BoundedBuffer<V> extends BaseBoundedBuffer<V>{

	protected BoundedBuffer(int cap) {
		super(cap);
	}
	
	public synchronized void put(V v) throws InterruptedException {
		while(isFull())
			wait();
		doput(v);
		notifyAll();
	}
	
	public synchronized V take() throws InterruptedException {
		while(isEmpty())
			wait();
		V v = dotake();
		notifyAll();
		return v;
	}

	
}
