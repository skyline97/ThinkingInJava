package concurrent_;

public class SimplePriorities implements Runnable {

	private int countDown = 5;
	private volatile double d;
	
	public SimplePriorities() {
	}
	
	@Override
	public String toString() {
		return Thread.currentThread() + ": " + countDown;
	}
	
	@Override
	public void run() {
		while(true) {
			for(int i=1;i<100000;i++) {
				d += (Math.PI + Math.E) / (double)i;
				if(i % 1000 == 0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countDown == 0)
				return;
		}
	}
	
}
