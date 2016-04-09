package concurrent_;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class PreLoader {

	private static Random ran = new Random(47);
	private final FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>(){
		@Override
		public Integer call() throws Exception {
			return ran.nextInt(100);
		}
	} );
	
	public Integer get() {
		try {
			return future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		PreLoader pl = new PreLoader();
		ExecutorService exe = Executors.newCachedThreadPool();
		exe.execute(pl.future);
		System.out.println(pl.get());
		exe.shutdown();
	}
			
}
