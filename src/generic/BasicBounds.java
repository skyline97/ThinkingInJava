package generic;

import java.awt.Color;

public class BasicBounds {
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getX();
		solid.weight();
	}
}

interface HasColor {
	Color getColor();
}

class Dimension {
	public int x,y,z;
}

class HoldItem<T> {
	T item;
	public HoldItem(T t) {
		item = t;
	}
	public T getItem() {
		return item;
	}
}

class Colored<T extends HasColor> extends HoldItem<T>{
	Colored(T t) {
		super(t);
	}
	Color color() {
		return item.getColor();
	}
}

class ColoredDimension<T extends Dimension & HasColor> extends Colored<T>{
	ColoredDimension(T t) {
		super(t);
	}
	int getX() {
		return item.x;
	}
	int getY() {
		return item.y;
	}
	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight> extends ColoredDimension<T>{
	Solid(T t) {
		super(t);
	}
	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor,Weight {
	@Override
	public int weight() {
		return 0;
	}
	@Override
	public Color getColor() {
		return null;
	}
}
