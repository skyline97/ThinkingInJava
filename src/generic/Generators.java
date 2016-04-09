package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Generators {

	public static <T> Collection<T> fill(Collection<T> c,Generator<T> g,int n) {
		for(int i=0;i<n;i++) {
			c.add(g.next());
		}
		return c;
	}
	
	public static <T> List<T> fill(List<T> c,Generator<T> g,int n) {
		for(int i=0;i<n;i++) {
			c.add(g.next());
		}
		return c;
	}
	
	public static <T> ArrayList<T> fill(ArrayList<T> c,Generator<T> g,int n) {
		for(int i=0;i<n;i++) {
			c.add(g.next());
		}
		return c;
	}
	
	public static void main(String[] args) {
		ArrayList<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 5);
		for(Coffee c : coffee) {
			System.out.println(c);
		}
	}
}
