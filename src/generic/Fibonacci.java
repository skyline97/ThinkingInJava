package generic;

public class Fibonacci implements Generator<Integer> {
	
	private int count = 0;

	@Override
	public Integer next() {
		return fib(count++);
	}
	
	public Fibonacci() {
	}
	
	private int fib(int n) {
		if(2 > n) 
			return 1;
		return fib(n -2) + fib(n -1);
	}
	
	public static void main(String[] args) {
		Generator<Integer> g = new Fibonacci();
		for(int i=0;i<18;i++) {
			System.out.print(g.next() + " ");
		}
	}

}
