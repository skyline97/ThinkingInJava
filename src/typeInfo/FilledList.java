package typeInfo;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {

	private Class<T> type;
	public FilledList(Class<T> type) {
		this.type = type;
	}
	public List<T> create(int n) {
		List<T> result = new ArrayList<T>();
		try {
			for(int i=0;i<n;i++) {
				result.add(type.newInstance());
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void main(String[] args) {
		FilledList<CountedInteger> list = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(list.create(10));
	}
}

class CountedInteger {
	private static long counter;
	private final long id = counter++;
	public CountedInteger() {
	}
	@Override
	public String toString() {
		return Long.toString(id);
	}
}
