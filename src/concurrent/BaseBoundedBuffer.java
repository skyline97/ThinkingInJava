package concurrent;

public abstract class BaseBoundedBuffer<V> {

	private final V[] buf;
	private int tail;
	private int head;
	private int count;
	
	protected BaseBoundedBuffer(int cap) {
		buf = (V[]) new Object[cap];
	}
	
	protected synchronized final void doput(V v) {
		buf[tail] = v;
		if(++tail == buf.length)
			tail = 0;
		++count;
	}
	
	protected synchronized final V dotake() {
		V v = buf[head];
		buf[head] = null;
		if(++head == buf.length)
			head = 0;
		--count;
		return v;
	}
	
	public synchronized final boolean isFull() {
		return count == buf.length;
	}
	
	public synchronized final boolean isEmpty() {
		return count == 0;
	}
	
}
