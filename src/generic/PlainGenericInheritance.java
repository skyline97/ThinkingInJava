package generic;

public class PlainGenericInheritance {
	public static void main(String[] args) {
		Base base = new Base();
		Derived derived = new Derived();
		DerivedGs dgs = new DerivedGs();
		dgs.set(base);
		dgs.set(derived);
	}
}

class GenericSetter<T> {
	void set(T arg) {
		System.out.println("GenericSetter.set(Base)");
	}
}

class DerivedGs extends GenericSetter<Base> {
	void set(Derived derived) {
		System.out.println("DerivedGs.set(Derived)");
	}
}
