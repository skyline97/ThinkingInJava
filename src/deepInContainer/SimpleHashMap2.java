package deepInContainer;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap2<K, V> extends AbstractMap<K, V>{
	
	static final int SIZE = 997;
	
	@SuppressWarnings("unchecked")
	MapEntry<K, V>[] buckets = new MapEntry[SIZE];
	
	static class MapEntry<K,V> implements Map.Entry<K, V> {
		
		private K key;
		private V value;
		private MapEntry<K, V> next;
		
		public MapEntry(K key,V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = getValue();
			this.value = value;
			return oldValue;
		}
		
		@Override
		public String toString() {
			return key + "=" + value;
		}
		
		@Override
		public int hashCode() {
			return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
		}
		
		@Override
		public boolean equals(Object obj) {
			if(!(obj instanceof MapEntry))
				return false;
			@SuppressWarnings("unchecked")
			MapEntry<K,V> me = (MapEntry<K,V>)obj;
			return (key == null ? 
					me.getKey() == null : key.equals(me.getKey())) && 
					(value == null ? 
							me.getValue() == null : value.equals(me.getValue()));
		}
		
	}
	
	public V put(K key,V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		MapEntry<K, V> newEntry = new MapEntry<K,V>(key,value);
		if(buckets[index] == null) 
			buckets[index] = newEntry;
		MapEntry<K, V> oldEntry = null;
		boolean found = false;
		for(MapEntry<K, V> pair =buckets[index];pair != null;pair = pair.next) {
			if(pair.getKey().equals(key)) {
				oldValue = pair.getValue();
				if(oldEntry != null)
					oldEntry.next = newEntry;
				else
					buckets[index] = newEntry;
				newEntry.next = pair.next;
				found = true;
				break;
			}
			oldEntry = pair;
		}
		if(!found)
			oldEntry.next = newEntry;
		return oldValue;
	}
	
	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null) 
			return null;
		for(MapEntry<K, V> entry = buckets[index];entry != null;entry = entry.next) {
			if(entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	@Override
	public V remove(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] == null)
			return null;
		MapEntry<K, V> oldEntry = null;
		for(MapEntry<K, V> entry = buckets[index];entry != null;entry = entry.next) {
			if(entry.getKey().equals(key)) {
				V value = entry.getValue();
				if(oldEntry != null)
					oldEntry.next = entry.next;
				else
					buckets[index] = null;
				return value;
			}
			oldEntry = entry;
		}
		return null;
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(int i=0;i<buckets.length;i++) {
			if(buckets[i] == null) 
				continue;
			set.add(buckets[i]);
		}
		return set;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new MapEntry[SIZE];
	}
	
	public static void main(String[] args) {
		SimpleHashMap2<String, String> m = new SimpleHashMap2<String,String>();
		m.putAll(FootballData.play());
		System.out.println(m);
		System.out.println(m.get("切尔西"));
		System.out.println(m.entrySet());
		
		m.remove("切尔西");
		System.out.println(m);
	}

}
