package concurrent_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex5 {

	public static void main(String[] args) {
		List<Future<Integer>> results = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			results.add(Fibonacci.runTask(i));
		}
		Fibonacci.shutdown();
		try {
			for (Future<Integer> f : results) {
				System.out.println(f.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

class Fibonacci {

	private static ExecutorService exe = Executors.newCachedThreadPool();

	private static int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public static synchronized void shutdown() {
		if (exe != null)
			exe.shutdown();
		exe = null;
	}

	public static Future<Integer> runTask(final int num) {
		return exe.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				int result = 0;
				for (int i = 0; i < num; i++)
					result += fib(i);
				return result;
			}
		});
	}

}
