package concurrent_;

public class Ex1 implements Runnable{
	
	private static int counter = 0;
	private final int id = counter++;
	
	public Ex1() {
		System.out.println("start,id=" + id);
	}
	
	@Override
	public void run() {
		for(int i=0;i<3;i++) {
			System.out.println("hello");
			Thread.yield();
		}
		System.out.println("end,id=" + id);
		return;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<3;i++)
			new Thread(new Ex1()).start();
	}
}
