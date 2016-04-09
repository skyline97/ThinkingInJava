package concurrent_;

import java.util.concurrent.TimeUnit;

public class TestSynchronized implements Runnable {

	public synchronized void say() {
		try {
			while (true) {
				Thread.sleep(100);
				System.out.println("haha");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void talk() {
		try {
			while (true) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("talk");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		say();
	}

	public static void main(String[] args) {
		TestSynchronized ts1 = new TestSynchronized();
		// TestSynchronized ts2 = new TestSynchronized();
		Thread t = new Thread(ts1);
		t.start();
		ts1.talk();
	}

}
