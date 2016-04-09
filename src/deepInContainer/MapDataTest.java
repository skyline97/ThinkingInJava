package deepInContainer;

import java.util.Iterator;

import array.CountingGenerator;
import array.RandomGenerator;
import generic.Generator;

public class MapDataTest {
	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		
		System.out.println(MapData.map(new CountingGenerator.Character(), 
				new RandomGenerator.String(7),11));
		
		System.out.println(MapData.map(new CountingGenerator.Character(),
				"value", 10));
		
		System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
		
		System.out.println(MapData.map(new Letters(), "Pop"));
	}
}

class Letters implements Generator<Pair<Integer, String>>,Iterable<Integer> {
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	
	@Override
	public Pair<Integer, String> next() {
		return new Pair<Integer, String>(number++, "" + letter++);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			@Override
			public boolean hasNext() {
				return number < size;
			}
			
			@Override
			public Integer next() {
				return number++;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
}
