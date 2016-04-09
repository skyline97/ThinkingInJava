package array;

import java.util.Random;

import generic.Generator;

public class RandomGenerator {

	private static Random ran = new Random(47);
	
	public static class Integer implements Generator<java.lang.Integer> {
		@Override
		public java.lang.Integer next() {
			return ran.nextInt();
		}
	}
	
	public static class Character implements Generator<java.lang.Character> {
		@Override
		public java.lang.Character next() {
			return CountingGenerator.chars[ran.nextInt(CountingGenerator.chars.length)];
		}
	}
	
	public static class String extends CountingGenerator.String {
		public String() {
		}
		public String(int length) {
			super(length);
		}
		{g = new Character();}
	}
}
