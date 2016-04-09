package concurrent_;

import java.util.Arrays;

import generic.Generator;

public class Ex2 implements Generator<Integer>,Runnable{
	
	private int n;
	private int counter;
	
	public Ex2(int n) {
		this.n = n;
	}
	
	private int fib(int n) {
		if(n < 2)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
	
	@Override
	public Integer next() {
		return fib(counter++);
	}

	@Override
	public void run() {
		Integer[] ia = new Integer[n];
		for(int i=0;i<n;i++)
			ia[i] = next();
		System.out.println(Arrays.toString(ia));
	}
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++)
			new Thread(new Ex2(i)).start();
	}
}
