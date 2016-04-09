package generic;

public class Coffee {

	private static int counter = 0;
	private final int id = counter++;
	@Override
	public String toString() {
		return getClass().getSimpleName() + id;
	}
}

class Latte extends Coffee {}

class Mocha extends Coffee {}

class Cappuccino extends Coffee {}

class Americano extends Coffee {}

class Breve extends Coffee {}
