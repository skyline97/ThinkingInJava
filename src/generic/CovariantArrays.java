package generic;

public class CovariantArrays {
	public static void main(String[] args) {
		Fruit[] fruit = new Apple[10];
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		try {
			fruit[0] = new Fruit();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			fruit[1] = new Orange();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
