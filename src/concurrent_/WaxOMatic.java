package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
	public static void main(String[] args) throws Exception{
		Car car = new Car();
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(new WaxOff(car));
		exe.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exe.shutdownNow();
	}
}

class Car {
	private boolean waxOn = false;
	
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while(waxOn == false)
			wait();
	}
	
	public synchronized void waitForBuffing() throws InterruptedException {
		while(waxOn == true)
			wait();
	}
}

class WaxOn implements Runnable {
	private Car car;
	
	public WaxOn(Car car) {
		this.car = car;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				System.out.println("Wax On!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		
		System.out.println("Ending Wax On task");
	}
}


class WaxOff implements Runnable {
	private Car car;
	
	public WaxOff(Car car) {
		this.car = car;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("Wax Off!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		
		System.out.println("Ending Wax Off task");
	}
}