package deepInContainer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TypesForSets {
	
	static <T> Set<T> fill(Set<T> set,Class<T> type) {
		try {
			for (int i = 0; i < 20; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}
	
	static <T> void test(Set<T> set,Class<T> type) {
		fill(set,type);
		fill(set,type);
		fill(set,type);
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		test(new HashSet<HashType>(),HashType.class);
		test(new LinkedHashSet<HashType>(),HashType.class);
		test(new TreeSet<TreeType>(),TreeType.class);
		
		test(new HashSet<SetType>(),SetType.class);
		test(new HashSet<TreeType>(),TreeType.class);
	}
}

class SetType {
	int i;
	public SetType(int n) {
		i = n;
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (i == ((SetType)obj).i);
	}
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

class HashType extends SetType {
	public HashType(int n) {
		super(n);
	}
	@Override
	public int hashCode() {
		return i;
	}
}

class TreeType extends SetType implements Comparable<TreeType>{
	public TreeType(int n) {
		super(n);
	}
	@Override
	public int compareTo(TreeType arg) {
		return i < arg.i ? 1 : (i == arg.i ? 0 : -1);
	}
}
