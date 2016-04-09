package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerAndConsumer {
	Meal meal;
	ExecutorService exe = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Cook chef = new Cook(this);
	
	public ProducerAndConsumer() {
		exe.execute(chef);
		exe.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		new ProducerAndConsumer();
	}
}

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}
	
	@Override
	public String toString() {
		return "Meal " + orderNum; 
	}
}

class WaitPerson implements Runnable {
	private ProducerAndConsumer rest;
	
	public WaitPerson(ProducerAndConsumer r) {
		rest = r;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(rest.meal == null)
						wait();
					System.out.println("Waitperson got " + rest.meal);
					synchronized(rest.chef) {
						rest.meal = null;
						rest.chef.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Cook implements Runnable {
	private ProducerAndConsumer rest;
	private int count = 0;
	
	public Cook(ProducerAndConsumer r) {
		rest = r;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (rest.meal != null)
						wait();
				}
				if (++count == 10) {
					System.out.println("Out of food,closing");
					rest.exe.shutdownNow();
				}
				System.out.print("Order up! ");
				
				synchronized (rest.waitPerson) {
					rest.meal = new Meal(count);
					rest.waitPerson.notifyAll();
				}
				
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

