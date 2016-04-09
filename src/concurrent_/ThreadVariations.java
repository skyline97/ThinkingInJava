package concurrent_;

public class ThreadVariations {
	
	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new ThreadMethod("ThreadMethod").runTask();;
	}
}

class InnerThread1 {
	private int countDown = 5;
	private Inner inner;
	
	public InnerThread1(String name) {
		inner = new Inner(name);
	}
	
	private class Inner extends Thread {
		Inner(String name) {
			super(name);
			start();
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					System.out.println(inner);
					if(--countDown == 0)
						return;
					sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public String toString() {
			return getName() + ": " + countDown;
		}
	}
	
}

