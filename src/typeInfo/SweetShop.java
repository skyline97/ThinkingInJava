package typeInfo;

public class SweetShop {
	public static void main(String[] args) {
		new Candy();
		try {
			Class<?> c = Class.forName("fourteen.Gum");
			Object obj = c.newInstance();
			Gum g = (Gum)obj;
			System.out.println(obj);
			System.out.println(g);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		new Cookie();
	}
}

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}

