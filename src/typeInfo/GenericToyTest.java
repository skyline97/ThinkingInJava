package typeInfo;

public class GenericToyTest {
	public static void main(String[] args) {
		try {
			Class<FancyToy> ftClass = FancyToy.class;
			FancyToy ft = ftClass.newInstance();
			Class<? super FancyToy> tClass = ftClass.getSuperclass();
			Object o = tClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Toy {
	Toy() {
	}
	
	Toy(int i) {
	}
}

class FancyToy extends Toy {
	public FancyToy() {
		super(1);
	}
}
