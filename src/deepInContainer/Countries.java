package deepInContainer;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Countries {

	public static final String[][] DATA = {
		{"CHINA","Beijing"},{"JAPAN","Tokyo"},{"INDIA","New Delhi"},
		{"IRAN","Tehran"},{"MALASIA","Kuala Lumpur"}
	};
	
	static Map<String,String> select(final int size) {
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}
	
	static Map<String,String> map = new FlyweightMap();
	
	public static Map<String,String> capitals() {
		return map;
	}
	
	public static Map<String,String> capitals(int size) {
		return select(size);
	}
	
	static List<String> names = new ArrayList<String>(map.keySet());
	
	public static List<String> names() {
		return names;
	}
	
	public static List<String> names(int size) {
		return new ArrayList<String>(select(size).keySet());
	}
	
	public static void main(String[] args) {
		System.out.println(capitals());
		System.out.println(new HashMap<String, String>(capitals(5)));
		System.out.println(new LinkedHashMap<String, String>(capitals(5)));
		System.out.println(new TreeMap<String, String>(capitals(5)));
		System.out.println(new Hashtable<String, String>(capitals(5)));
		System.out.println(new HashSet<String>(names(5)));
		System.out.println(new LinkedHashSet<String>(names(5)));
		System.out.println(new TreeSet<String>(names(5)));
		System.out.println(new ArrayList<String>(names(5)));
		System.out.println(new LinkedList<String>(names(5)));
		System.out.println(capitals().get("CHINA"));
	}
	
	private static class FlyweightMap extends AbstractMap<String, String> {
		
		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);
		
		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;
			EntrySet(int size) {
				if(size < 0)
					this.size = 0;
				else if(size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}
			@Override
			public int size() {
				return size;
			}
			
			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				return new Iter();
			}
			
			private class Iter implements Iterator<Map.Entry<String, String>> {
				private Entry entry = new Entry(-1);
				@Override
				public boolean hasNext() {
					return entry.index < size - 1;
				}
				@Override
				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}
				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			}
			
			private static class Entry implements Map.Entry<String,String> {
				private int index;
				Entry(int index) {
					this.index = index;
				}
				@Override
				public boolean equals(Object obj) {
					return DATA[index][0].equals(obj);
				}
				@Override
				public int hashCode() {
					return DATA[index][0].hashCode();
				}
				@Override
				public String getKey() {
					return DATA[index][0];
				}
				@Override
				public String getValue() {
					return DATA[index][1];
				}
				@Override
				public String setValue(String value) {
					throw new UnsupportedOperationException();
				}
			}
			
		}
		
		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}

		
	}
	
}
