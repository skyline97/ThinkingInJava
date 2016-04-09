package concurrent_;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex3 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
			exec.execute(new Ex2(i));
		exec.shutdown();
	}
}
