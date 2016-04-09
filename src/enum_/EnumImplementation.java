package enum_;

import java.util.Random;

import generic.Generator;

public class EnumImplementation {
	
	public static <T> void printNext(Generator<T> rg) {
		System.out.println(rg.next());
	}
	
	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for(int i=0;i<10;i++)
			printNext(cc);
	}
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
	
	private Random ran = new Random(47);
	
	public CartoonCharacter next() {
		return values()[ran.nextInt(values().length)];
	}
	
}