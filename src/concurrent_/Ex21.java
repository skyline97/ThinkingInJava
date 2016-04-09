package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex21 {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		Run1 r = new Run1();
		exe.execute(r);
		exe.execute(new Run2(r));
		
		exe.shutdown();
	}
}

class Run1 implements Runnable {
	
	@Override
	public synchronized void run() {
		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
		
		System.out.println("I'm a hero");
	}
	
	public synchronized void wake() {
		notifyAll();
	}
}

class Run2 implements Runnable {
	private Run1 r;
	
	public Run2(Run1 r) {
		this.r = r;
	}
	
	@Override
	public synchronized void run() {
		try {
			TimeUnit.SECONDS.sleep(2);
			r.wake();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
	}
}