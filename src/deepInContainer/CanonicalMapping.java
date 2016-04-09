package deepInContainer;

import java.util.WeakHashMap;

public class CanonicalMapping {
	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
		for(int i=0;i<size;i++) {
			Key k = new Key(String.valueOf(i));
			Value v = new Value(String.valueOf(i));
			if(i % 3 == 0) 
				keys[i] = k;
			map.put(k, v);
		}
		System.gc();
	}
}

class Element {
	private String ident;
	public Element(String id) {
		ident = id;
	}
	@Override
	public String toString() {
		return ident;
	}
	
	@Override
	public int hashCode() {
		return ident.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Element && this.ident.equals(((Element)obj).ident);
	}
	
	@Override
	protected void finalize() {
		System.out.println("Finalizing " + getClass().getSimpleName() + " " + ident);
	}
}

class Key extends Element {
	public Key(String id) {
		super(id);
	}
}

class Value extends Element {
	public Value(String id) {
		super(id);
	}
}
