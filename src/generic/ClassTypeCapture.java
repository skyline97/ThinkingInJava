package generic;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {

	Map<String, Class<?>> map;
	Class<T> kind;
	
	public ClassTypeCapture(Class<T> kind) {
		this.kind = kind;
		map = new HashMap<String, Class<?>>();
	}
	
//	public void addType(String typename,Class<?> type) {
//		map.put(typename, createNew(typename));
//	}
	
	public void addType(String typename,Class<?> kind) {
		map.put(typename, kind);
	}
	
	public Class<?> createNew(String typename) {
		Class<?> result = null;
		try {
			result = Class.forName(typename);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean f(Object arg) {
		return kind.isInstance(arg);
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> c = new ClassTypeCapture<Building>(Building.class);
		System.out.println(c.f(new House()));
		Class<?> cla = c.createNew("fifteen.AClass");
		c.addType("AClass", cla);
		System.out.println(c.map);
	}
}

class Building {}

class House extends Building {}
