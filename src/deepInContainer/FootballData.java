package deepInContainer;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FootballData {

	public static final String[][] PLAYERS= {
		{"巴塞罗那","梅西"},{"皇家马德里","C罗"},{"阿森纳","亨利"}
		,{"切尔西","穆里尼奥"},{"拜仁","罗本"},{"巴黎圣日耳曼","伊布"}
		,{"曼联","鲁尼"}
	};
	
	
	
	private static class FlyWeightMap extends AbstractMap<String, String> {
		
		private static class Entry implements Map.Entry<String, String> {
			
			private int index;
			
			Entry(int index) {
				this.index = index;
			}

			@Override
			public String getKey() {
				return PLAYERS[index][0];
			}

			@Override
			public String getValue() {
				return PLAYERS[index][1];
			}

			@Override
			public String setValue(String value) {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public boolean equals(Object obj) {
				return PLAYERS[index][0].equals(obj);
			}
			
			@Override
			public int hashCode() {
				return PLAYERS[index][0].hashCode();
			}
			
		}

		private static class EntrySet extends AbstractSet<Map.Entry<String,String>> {
			
			private int size;
			
			EntrySet(int size) {
				if(size < 0)
					this.size = 0;
				else if(size > PLAYERS.length)
					this.size = PLAYERS.length;
				else 
					this.size = size;
			}

			@Override
			public Iterator<Map.Entry<String, String>> iterator() {
				return new Iter();
			}

			@Override
			public int size() {
				return PLAYERS.length;
			}
			
			//不能是静态类
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
			
		}
		
		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return new EntrySet(PLAYERS.length);
		}
		
	}
	
	static Map<String,String> dataMap = new FlyWeightMap();
	
	public static Map<String,String> play() {
		return dataMap;
	}
	
	public static Set<String> names() {
		return dataMap.keySet();
	}
	
	public static void main(String[] args) {
		System.out.println(play());
		System.out.println(names());
		System.out.println(new HashMap<String,String>(play()));
	}
}
