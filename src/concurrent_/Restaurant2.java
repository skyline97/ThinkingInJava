package concurrent_;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant2 {
	
	private BlockingQueue<Meal2> queue = new LinkedBlockingQueue<Meal2>();
	private WaitPerson2 wp2 = new WaitPerson2(queue);
	private Chef2 c2 = new Chef2(queue,this);
	ExecutorService exe = Executors.newCachedThreadPool();
	
	
	public static void main(String[] args) throws Exception {
		Restaurant2 r = new Restaurant2();
		r.exe.execute(r.wp2);
		r.exe.execute(r.c2);
		
	}
}

class Meal2 {
	private final int id = count++;
	private static int count = 0;
	
	@Override
	public String toString() {
		return "Meal " + id; 
	}
}

class WaitPerson2 implements Runnable {
	
	private BlockingQueue<Meal2> queue;
	
	public WaitPerson2(BlockingQueue<Meal2> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Meal2 m = queue.take();
				System.out.println("consume " + m);
			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson2 interrupted");
		}
	}
	
}

class Chef2 implements Runnable {
	
	private BlockingQueue<Meal2> queue;
	private Restaurant2 rest;
	private int count = 0;
	
	public Chef2(BlockingQueue<Meal2> queue,Restaurant2 r) {
		this.queue = queue;
		rest = r;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				if(count == 10) {
					System.out.println("Out of Food!");
					rest.exe.shutdownNow();
				}
				Meal2 m = new Meal2();
				queue.put(m);
				count++;
				System.out.println("produce " + m);
			}
		} catch (InterruptedException e) {
			System.out.println("chef interrupted");
		}
	}
	
}