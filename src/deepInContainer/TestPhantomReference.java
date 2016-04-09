package deepInContainer;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TestPhantomReference {

	public static void main(String[] args) {
		Object obj = new Object();
		ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
		PhantomReference<Object> phantomRef = new PhantomReference<Object>(obj, refQueue);
		System.out.println(phantomRef.get());
		System.out.println(refQueue.poll());
		obj = null;
		System.gc();
		System.out.println(phantomRef.get());
		System.out.println(refQueue.poll());
	}
}
