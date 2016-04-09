package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Ex9 {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool(new PriorityThreadFactory(
				Thread.MIN_PRIORITY));
		
		for(int i=0;i<5;i++)
			exe.execute(new SimplePriorities());
		exe.shutdown();
	}
}

class PriorityThreadFactory implements ThreadFactory {
	
	private int priority;
	
	PriorityThreadFactory(int p) {
		priority = p;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(priority);
		return t;
	}
	
}

