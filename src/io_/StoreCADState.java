package io_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoreCADState {

	public static void main(String[] args) throws Exception{
		List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		List<Shape> shapes = new ArrayList<Shape>();
		for(int i=0;i<10;i++) 
			shapes.add(Shape.randomFactory());
		for(int i=0;i<10;i++)
			shapes.get(i).setColor(Shape.GREEN);
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("CADState.out"));
		out.writeObject(shapeTypes);
		Line.serializeStaticState(out);
		out.writeObject(shapes);
		out.close();
		System.out.println(shapes);
	}
}

abstract class Shape implements Serializable {

	public static final int RED = 1,BLUE = 2,GREEN = 3;
	private int xPos,yPos,dimension;
	private static Random ran = new Random(47);
	private static int counter = 0;
	
	public abstract void setColor(int newColor);
	public abstract int getColor();
	
	public Shape(int xVal,int yVal,int dim) {
		xPos = xVal;
		yPos = yVal;
		dimension = dim;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " color[" + getColor() + "] xPos[" + xPos + "] yPos[" +
				yPos + "] dim[" + dimension + "]\n";
	}
	
	public static Shape randomFactory() {
		int xVal = ran.nextInt(100);
		int yVal = ran.nextInt(100);
		int dim = ran.nextInt(100);
		switch(counter++ % 3) {
			default:
			case 0:return new Circle(xVal,yVal,dim);
			case 1:return new Square(xVal, yVal, dim);
			case 2:return new Line(xVal,yVal,dim);
		}
	}
	
}

class Circle extends Shape {
	private static int color = RED;

	public Circle(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
	
//	private void writeObject(ObjectOutputStream os) throws IOException {
//		serializeStaticState(os);
//	}
//	
//	private void readObject(ObjectInputStream os) throws IOException {
//		deserializeStaticState(os);
//	}
//	
//	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
//		os.writeInt(color);
//	}
//	
//	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
//		color = os.readInt();
//	}
	
}

class Square extends Shape {
	private static int color;

	public Square(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
		color = RED;
	}

	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
	
	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
		os.writeInt(color);
	}
	
	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
		color = os.readInt();
	}
	
	private void writeObject(ObjectOutputStream os) throws IOException {
		serializeStaticState(os);
	}
	
	private void readObject(ObjectInputStream os) throws IOException {
		deserializeStaticState(os);
	}
}

class Line extends Shape {
	private static int color = RED;

	public Line(int xVal, int yVal, int dim) {
		super(xVal, yVal, dim);
	}

	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
	
	public static void serializeStaticState(ObjectOutputStream os) throws IOException {
		os.writeInt(color);
	}
	
	public static void deserializeStaticState(ObjectInputStream os) throws IOException {
		color = os.readInt();
	}
	
//	private void writeObject(ObjectOutputStream os) throws IOException {
//		serializeStaticState(os);
//	}
//	
//	private void readObject(ObjectInputStream os) throws IOException {
//		deserializeStaticState(os);
//	}
}
