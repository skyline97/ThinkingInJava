package deepInContainer;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class TestWeakReference {

	public static void main(String[] args) {
		Object obj = new Object();
		ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
		WeakReference<Object> weakRef = new WeakReference<Object>(obj,refQueue);
		System.out.println(weakRef.get());
		System.out.println(refQueue.poll());
		obj = null;
		System.gc();
		System.out.println(weakRef.get());
		System.out.println(refQueue.poll());
	}
}
