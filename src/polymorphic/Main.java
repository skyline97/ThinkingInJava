package polymorphic;

public class Main {
	void play(Cycle c) {
		System.out.println(c.getClass().getName());
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		m.play(new Cycle());
		m.play(new Unicycle());
		m.play(new Bicycle());
		m.play(new Tricycle());
	}
}

class Cycle {
}

class Unicycle extends Cycle {
}

class Bicycle extends Cycle {
}

class Tricycle extends Cycle {
}