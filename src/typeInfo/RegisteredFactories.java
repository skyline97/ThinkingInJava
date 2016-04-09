package typeInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RegisteredFactories {
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			System.out.println(Part.createRandom());
		}
	}
}

@SuppressWarnings("unchecked")
class Part {
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
	
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	
	static {
		Collections.addAll(partFactories, new FuelFilter.Factory(),new FanBelt.Facoty()
		,new NullPart.Factory());
	}
	
	private static Random ran = new Random(47);
	
	public static Part createRandom() {
		int n = ran.nextInt(partFactories.size());
		return partFactories.get(n).create();
	}
}

class Filter extends Part {}

class FuelFilter extends Filter {
	public static class Factory implements typeInfo.Factory<FuelFilter> {
		@Override
		public FuelFilter create() {
			return new FuelFilter();
		}
	}
}

class Belt extends Part {}

class FanBelt extends Belt {
	public static class Facoty implements typeInfo.Factory<FanBelt> {
		@Override
		public FanBelt create() {
			return new FanBelt();
		}
	}
}

class NullPart extends Part implements Null {
	public static final Part NULL = new NullPart();
	
	public static class Factory implements typeInfo.Factory<NullPart> {
		@Override
		public NullPart create() {
			return (NullPart)NULL;
		}
		
	}
}