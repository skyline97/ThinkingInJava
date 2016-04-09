package deepInContainer;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SpringDetector {
	
	public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
		Constructor<T> c = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		for(int i=0;i<10;i++) {
			T t = c.newInstance(i);
			if(i == 3) 
				System.out.println(t.hashCode());
			map.put(t, new Prediction());
		}
		System.out.println(map);
		
		Groundhog gh = c.newInstance(3);
		System.out.println(gh.hashCode());
		System.out.println("Looking up prediction for " + gh);
		if(map.containsKey(gh)) {
			System.out.println(map.get(gh));
		} else {
			System.out.println("key not found " + gh);
		}
	}
	
	public static void main(String[] args) throws Exception {
		detectSpring(Groundhog.class);
	}
}

class Groundhog {
	protected int number;
	public Groundhog(int n) {
		number = n;
	}
	@Override
	public String toString() {
		return "Groundhog #" + number;
	}
	
	@Override
	public int hashCode() {
		return number;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Groundhog && (number == ((Groundhog)obj).number);
	}
}

class Prediction {
	private static Random ran = new Random(47);
	private boolean shadow = ran.nextDouble() > 0.5;
	
	@Override
	public String toString() {
		if(shadow) 
			return "Six more weeks of Winter!";
		else
			return "Early Spring!";
	}
}
