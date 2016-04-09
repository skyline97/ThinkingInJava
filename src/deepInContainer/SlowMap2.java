package deepInContainer;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap2<K,V> extends AbstractMap<K, V> {

	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	@Override
	public V put(K key, V value) {
		V oldValue = get(key);
		if(!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}
	
	@Override
	public V get(Object key) {
		if(!keys.contains(key)) 
			return null;
		return values.get(keys.indexOf(key));
	}
	
	private EntrySet entrySet = new EntrySet();
	
	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {

		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			return new Iterator<Map.Entry<K,V>>() {
				
				private int index = -1;
				private boolean canRemove;

				@Override
				public boolean hasNext() {
					return index < keys.size() - 1;
				}

				@Override
				public java.util.Map.Entry<K, V> next() {
					canRemove = true;
					++index;
					return new MapEntry<K,V>(keys.get(index), values.get(index));
				}

				@Override
				public void remove() {
					if(!canRemove)
						throw new IllegalStateException();
					canRemove = false;
					keys.remove(index);
					values.remove(index--);
				}
			};
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean contains(Object o) {
			if(o instanceof MapEntry) {
				MapEntry<K, V> e = (MapEntry<K,V>) o;
				K key = e.getKey();
				if(keys.contains(key))
					return e.equals(new MapEntry<K, V>(key, get(key)));
			}
			return false;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean remove(Object o) {
			if(contains(o)) {
				MapEntry<K, V> e = (MapEntry<K, V>) o;
				K key = e.getKey();
				V value = e.getValue();
				keys.remove(key);
				values.remove(value);
				return true;
			}
			return false;
		}
		
		@Override
		public void clear() {
			keys.clear();
			values.clear();
		}

		@Override
		public int size() {
			return keys.size();
		}
		
	}
	
	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return entrySet;
	}

	
}
