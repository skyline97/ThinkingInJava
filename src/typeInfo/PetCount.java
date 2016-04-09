package typeInfo;

import java.util.HashMap;
import java.util.Map;

public class PetCount {

	static class PetCounter extends HashMap<String, Integer> {
		private static final long serialVersionUID = 1L;
		Map<String,Integer> counter = new HashMap<String, Integer>();
		public void count(String type) {
			Integer quantity = counter.get(type);
			if(quantity == null)
				counter.put(type,1);
			else
				counter.put(type,quantity + 1);
		}
	}
	
	public static void countPets() {
		PetCounter pc = new PetCounter();
		pc.count(null);
	}
}
