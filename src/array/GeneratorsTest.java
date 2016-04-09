package array;

import generic.Generator;

public class GeneratorsTest {

	public static int size =10;
	
	public static void test(Class<?> surroundingClass) {
		for(Class<?> c : surroundingClass.getClasses()) {
			System.out.println(c.getSimpleName() + ": ");
			try {
				Generator<?> g = (Generator<?>) c.newInstance();
				for(int i=0;i<size;i++) {
					System.out.println(g.next() + " ");
				}
				System.out.println();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		test(RandomGenerator.class);
	}
}
