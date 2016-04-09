package concurrent_;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex6 {
	public static void main(String[] args) {
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exe.execute(new Pig());
		exe.shutdown();
	}
}

class Pig implements Runnable {
	
	private static Random ran = new Random(47);
	
	@Override
	public void run() {
		int sec = ran.nextInt(10);
		try {
			TimeUnit.SECONDS.sleep(sec);
			System.out.println("我睡了" + sec + "秒!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
