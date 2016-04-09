package concurrent_;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
	static final int SIZE = 100;
	
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(SIZE);
		
		for(int i=0;i<10;i++)
			exe.execute(new WaitingTask(latch));
		for(int i=0;i<SIZE;i++)
			exe.execute(new TaskPortion(latch));
		
		System.out.println("Launched all tasks");
		exe.shutdown();
	}
}

class TaskPortion implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private static Random ran = new Random(47);
	private final CountDownLatch latch;
	
	public TaskPortion(CountDownLatch l) {
		latch = l;
	}
	
	@Override
	public void run() {
		try {
			doWork();
			latch.countDown();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
	
	public void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(ran.nextInt(2000));
		System.out.println(this + "completed");
	}
	
	@Override
	public String toString() {
		return String.format("%1$-3d ", id);
	}
}

class WaitingTask implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;

	public WaitingTask(CountDownLatch l) {
		latch = l;
	}
	
	@Override
	public void run() {
		try {
			latch.await();
			System.out.println("Latch barrier passed for " + this);
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
	}
	
	@Override
	public String toString() {
		return String.format("WaitingTask %1$-3d ", id);
	}
}
