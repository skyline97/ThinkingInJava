package array;

import generic.Generator;

public class CountingGenerator {

	static char[] chars = ("abcdefghijklmnopqrstuvwxyz"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
	public static class Character implements Generator<java.lang.Character> {
		int index = -1;
		@Override
		public java.lang.Character next() {
			index = (index + 1) % chars.length;
			return chars[index];
		}
	}
	
	public static class Integer implements Generator<java.lang.Integer> {
		private int value = 0;
		@Override
		public java.lang.Integer next() {
			return value++;
		}
	}
	
	public static class String implements Generator<java.lang.String> {
		private int length = 7;
		Generator<java.lang.Character> g = new Character();
		public String() {
		}
		public String(int length) {
			this.length = length;
		}
		@Override
		public java.lang.String next() {
			char[] result = new char[length];
			for(int i=0;i<length;i++) {
				result[i] = g.next();
			}
			return new java.lang.String(result);
		}
	}
}
