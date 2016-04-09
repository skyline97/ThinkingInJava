package concurrent_;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NotifyVsNotifyAll {
	public static void main(String[] args) throws Exception{
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new Task());
		exe.execute(new Task2());
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			boolean prod = true;
			@Override
			public void run() {
				if(prod) {
					System.out.print("\nnotify()");
					Task.blocker.prod();
					prod = false;
				} else {
					System.out.print("\nnotifyAll()");
					Task.blocker.prodAll();
					prod = true;
				}
			}
		}, 400,400);
		
		TimeUnit.SECONDS.sleep(5);
		timer.cancel();
		System.out.println("\nTimer canceled");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.print("Task2.blocker.prodAll()");
		Task2.blocker.prodAll();
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("\nShutting down");
		exe.shutdownNow();
	}
}

class Blocker {
	synchronized void waitingCall() {
		try {
			while(!Thread.interrupted()) {
				wait();
				System.out.print(Thread.currentThread() + " ");
			}
		} catch (InterruptedException e) {
			System.out.println("InterruptedException");
		}
	}
	
	synchronized void prod() {
		notify();
	}
	
	synchronized void prodAll() {
		notifyAll();
	}
}

class Task implements Runnable {
	static Blocker blocker = new Blocker();
	@Override
	public void run() {
		blocker.waitingCall();
	}
}

class Task2 implements Runnable {
	static Blocker blocker = new Blocker();
	@Override
	public void run() {
		blocker.waitingCall();
	}
}
