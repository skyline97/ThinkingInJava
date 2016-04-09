package deepInContainer;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountingMapData extends AbstractMap<Integer,String> {
	
	private int size;
	private static String[] chars = 
			"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
	
	public CountingMapData(int size) {
		this.size = size < 0 ? 0 : size;
	}
	
	private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
		
		private int size;
		
		EntrySet(int size) {
			if(size < 0)
				throw new IllegalArgumentException();
			this.size = size;
		}
		
		@Override
		public Iterator<java.util.Map.Entry<Integer, String>> iterator() {
			return new Iterator<Map.Entry<Integer,String>>() {
				
				private Entry entry = new Entry(-1);
				
				@Override
				public boolean hasNext() {
					return entry.index < size - 1;
				}

				@Override
				public Map.Entry<Integer, String> next() {
					entry.index++;
					return entry;
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

		@Override
		public int size() {
			return size;
		}
		
	}
	
	@Override
	public Set<Map.Entry<Integer, String>> entrySet() {
		Set<Map.Entry<Integer, String>> entries = new EntrySet(size);
		return entries;
	}
	
	public static void main(String[] args) {
		System.out.println(new CountingMapData(60));
	}
	
	private static class Entry implements Map.Entry<Integer, String> {
		
		private int index;
		
		Entry(int index) {
			this.index = index;
		}
		
		@Override
		public boolean equals(Object obj) {
			return Integer.valueOf(index).equals(obj);
		}
		
		@Override
		public int hashCode() {
			return Integer.valueOf(index).hashCode();
		}

		@Override
		public Integer getKey() {
			return index;
		}

		@Override
		public String getValue() {
			return chars[index % chars.length] + Integer.toString(index / chars.length);
		}

		@Override
		public String setValue(String value) {
			throw new UnsupportedOperationException();
		}
		
	}
	
}
