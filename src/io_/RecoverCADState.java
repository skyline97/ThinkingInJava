package io_;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class RecoverCADState {

	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("CADState.out"));
		List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
		Line.deserializeStaticState(in);
		List<Shape> shapes = (List<Shape>)in.readObject();
		in.close();
		System.out.println(shapes);
	}
}
