package deepInContainer;

import java.util.AbstractList;

import array.CountingGenerator;
import generic.Generator;

public class CountingStringList extends AbstractList<String>{

	private int size;
	private static Generator<String> gen = new CountingGenerator.String();
	
	public CountingStringList(int size) {
		this.size = size < 0 ? 0 : size;
	}

	@Override
	public String get(int index) {
		return gen.next();
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println(new CountingStringList(10));
		}
	}
}
