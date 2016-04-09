package concurrent_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import enum_.Course;
import enum_.Food;

public class RestaurantWithQueues {
	public static void main(String[] args) throws Exception{
		ExecutorService exe = Executors.newCachedThreadPool();
		Restaurant restaurant = new Restaurant(exe, 5, 2);
		exe.execute(restaurant);
		
		System.out.println("Press 'Enter' to quit");
		System.in.read();
		
		exe.shutdownNow();
	}
}

class Order {
	private static int counter = 0;
	private final int id = counter++;
	private final Customer customer;
	private final Waiter waiter;
	private final Food food;
	
	public Order(Customer c,Waiter p,Food f) {
		customer = c;
		waiter = p;
		food = f;
	}
	
	public Food item() {
		return food;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Waiter getWaitPerson() {
		return waiter;
	}

	@Override
	public String toString() {
		return "Order: " + id + " item: " + food + " for: " + customer + " served by" + waiter;
	}
}

class Plate {
	private final Order order;
	private final Food food;
	
	public Plate(Order o,Food f) {
		order = o;
		food =  f;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public Food getFood() {
		return food;
	}
	
	@Override
	public String toString() {
		return food.toString();
	}
}

class Customer implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private final Waiter waiter;
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();
	
	public Customer(Waiter p) {
		waiter = p;
	}
	
	public void deliver(Plate p) throws InterruptedException {
		placeSetting.put(p);
	}
	
	@Override
	public void run() {
		for(Course course: Course.values()) {
			Food food = course.randomSelection();
			try {
				waiter.placeOrder(this,food);
				System.out.println(this + "eating " + placeSetting.take());
			} catch (InterruptedException e) {
				System.out.println(this + "waiting for " + course + " interrupted");
				break;
			}
		}
		System.out.println(this + "finished meal,leaving");
	}
	
	@Override
	public String toString() {
		return "Customer " + id + " ";
	}
}

class Waiter implements Runnable{
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();
	
	public Waiter(Restaurant r) {
		restaurant = r;
	}
	
	public void placeOrder(Customer cust,Food food) {
		try {
			restaurant.orders.put(new Order(cust, this, food));
		} catch (InterruptedException e) {
			System.out.println(this + " placeOrder interrupted");
		}
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Plate plate = filledOrders.take();
				System.out.println(this + "received " + plate + " delivering to" 
						+ plate.getOrder().getCustomer());
				plate.getOrder().getCustomer().deliver(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " off duty");
	}
	
	@Override
	public String toString() {
		return "Waiter " + id + " ";
	}
}

class Chef implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private Restaurant restaurant;
	private static Random ran = new Random(47);
	
	public Chef(Restaurant r) {
		restaurant = r;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Order order = restaurant.orders.take();
				Food requestedItem = order.item();
				TimeUnit.MILLISECONDS.sleep(ran.nextInt(500));
				Plate plate = new Plate(order, requestedItem);
				order.getWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted!");
		}
		System.out.println(this + " off duty");
	}
	
	@Override 
	public String toString() {
		return "Chef " + id + " ";
	}
}

class Restaurant implements Runnable {
	private List<Waiter> waiters = new ArrayList<Waiter>();
	private List<Chef> chefs = new ArrayList<Chef>();
	private ExecutorService exe;
	private static Random ran = new Random(47);
	BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();
	
	public Restaurant(ExecutorService e,int nWaiters,int nChefs) {
		exe = e;
		for(int i=0;i<nWaiters;i++) {
			Waiter waiter = new Waiter(this);
			waiters.add(waiter);
			exe.execute(waiter);
		}
		for(int i=0;i<nChefs;i++) {
			Chef chef = new Chef(this);
			chefs.add(chef);
			exe.execute(chef);
		}
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Waiter w = waiters.get(ran.nextInt(waiters.size()));
				Customer c = new Customer(w);
				exe.execute(c);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Restaurant interrupted");
		}
		
		System.out.println("Restaurant closing!");
	}
	
}

