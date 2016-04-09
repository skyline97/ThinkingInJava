package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{
	
	private IntGenerator gen;
	private final int id;

	public EvenChecker(IntGenerator g,int id) {
		gen = g;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(!gen.isCanceled()) {
			int val = gen.next();
			if(val % 2 != 0) {
				System.out.println(val + " not even!");
				gen.cancel();
			}
		}
	}
	
	public static void test(IntGenerator g,int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i=0;i<count;i++)
			exe.execute(new EvenChecker(g, i));
		exe.shutdown();
	}
	
	public static void test(IntGenerator g) {
		test(g,10);
	}
}
