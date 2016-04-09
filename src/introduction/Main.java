package introduction;

public class Main {
	
	public static void main(String[] args) {
		Shape shape = new Shape();
		Circle circle = new Circle();
		doSomething(shape);
		doSomething(circle);
	}
	
	public static void doSomething(Shape shape) {
		shape.erase();
	}
}

class Shape {
	public void erase() {
		System.out.println("shape erase!");
	}
}

class Circle extends Shape {
	@Override
	public void erase() {
		System.out.println("circle erase!");
	}
}
