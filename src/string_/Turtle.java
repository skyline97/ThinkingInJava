package string_;

import java.util.Formatter;

public class Turtle {

	private String name;
	private Formatter f;
	
	public Turtle(String name,Formatter f) {
		this.name = name;
		this.f = f;
	}
	
	public void move(int x,int y) {
		f.format("%s The turtle is at (%d,%d)\n",name, x,y);
	}
	
	public static void main(String[] args) {
		Turtle t = new Turtle("ww", new Formatter(System.err));
		t.move(1, 2);
	}
}
