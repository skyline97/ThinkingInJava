package typeInfo;

public abstract class Shape {
	
	void draw() {
		System.out.println(this + ".draw()");
	}

	public abstract String toString();
	
	public static void main(String[] args) {
		Shape s = new Circle();
		s.draw();
	}
}

class Circle extends Shape {

	@Override
	public String toString() {
		return "circle";
	}
	
}
