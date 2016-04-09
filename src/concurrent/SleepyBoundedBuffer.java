package concurrent;

import java.util.concurrent.TimeUnit;

public class SleepyBoundedBuffer<V> extends BaseBoundedBuffer<V>{

	protected SleepyBoundedBuffer(int cap) {
		super(cap);
	}
	
	public void put(V v) throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(!isFull()) {
					doput(v);
					return;
				}
			}
			TimeUnit.MILLISECONDS.sleep(10);
		}
	}
	
	public V take() throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(!isEmpty())
					return dotake();
			}
			TimeUnit.MILLISECONDS.sleep(10);
		}
	}

	
}
