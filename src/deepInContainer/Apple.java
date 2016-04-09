package deepInContainer;

import java.util.HashMap;

public class Apple {
	private String color;
	static final int MAXIMUM_CAPACITY = 1 << 30;
	static int id;
 
	public Apple(String color) {
		this.color = color;
		id++;
	}
	
	@Override
	public int hashCode() {
		return color.hashCode();
	}
 
	public boolean equals(Object obj) {
		if (!(obj instanceof Apple))
			return false;	
		if (obj == this)
			return true;
		return this.color.equals(((Apple) obj).color);
	}
 
	public static void main(String[] args) {
		Apple a1 = new Apple("green");
		Apple a2 = new Apple("red");
 
		//hashMap stores apple type and its quantity
		HashMap<Apple, Integer> m = new HashMap<Apple, Integer>();
		m.put(a1, 10);
		m.put(a2, 20);
		System.out.println(m.get(new Apple("green")));
		
		System.out.println(MAXIMUM_CAPACITY);
		System.out.println(Math.pow(2, 30));
		
	}
}
