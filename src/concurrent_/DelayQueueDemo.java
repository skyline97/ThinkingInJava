package concurrent_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
	public static void main(String[] args) {
		Random ran = new Random(47);
		ExecutorService exe = Executors.newCachedThreadPool();
		DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
		
		for(int i=0;i<20;i++)
			queue.put(new DelayedTask(ran.nextInt(5000)));
		
		queue.add(new DelayedTask.EndSentinel(5000, exe));
		exe.execute(new DelayedTaskConsumer(queue));
	}
}

class DelayedTask implements Runnable,Delayed {
	private static int counter = 0;
	private final int id = counter++;
	private final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
	
	public DelayedTask(int delayInMilliseconds) {
		delta = delayInMilliseconds;
		trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		sequence.add(this);
	}
	
	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	}
	
	@Override
	public int compareTo(Delayed o) {
		DelayedTask d = (DelayedTask)o;
		if(trigger < d.trigger)
			return -1;
		if(trigger > d.trigger)
			return 1;
		return 0;
	}
	
	@Override
	public void run() {
		System.out.print(this + " ");
	}
	
	@Override
	public String toString() {
		return String.format("[%1$-4d]", delta) + " Task " + id;
	}
	
	public String summary() {
		return "(" + id + ":" + delta + ")";
	}
	
	public static class EndSentinel extends DelayedTask {
		private ExecutorService exe;
		
		public EndSentinel(int delay,ExecutorService e) {
			super(delay);
			exe = e;
		}
		
		@Override
		public void run() {
			for(DelayedTask pt : sequence) {
				System.out.print(pt.summary() + " ");
			}
			System.out.println();
			System.out.println(this + " Calling shutdown()");
			exe.shutdownNow();
		}
	}
}

class DelayedTaskConsumer implements Runnable {
	private DelayQueue<DelayedTask> q;
	
	public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) 
				q.take().run();
		} catch (InterruptedException e) {
		}
		System.out.println("Finished DelayedTaskConsumer");
	}
}
