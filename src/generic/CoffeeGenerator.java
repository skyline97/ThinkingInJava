package generic;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{
	
	private Class<?>[] types = {Latte.class,Mocha.class,Cappuccino.class,Americano.class,Breve.class};
	private static Random rand = new Random(47);
	
	private int size = 0;
	
	public CoffeeGenerator() {
	}
	
	public CoffeeGenerator(int size) {
		this.size = size;
	}
	
	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	@Override
	public Coffee next() {
		try {
			return (Coffee)types[rand.nextInt(types.length)].newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		CoffeeGenerator g = new CoffeeGenerator();
		for(int i=0;i<5;i++) {
			System.out.println(g.next());
		}
		for(Coffee c:new CoffeeGenerator(5)) {
			System.out.println(c);
		}
	}

	class CoffeeIterator implements Iterator<Coffee>{
		
		private int count = size;
		
		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
