package deepInContainer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V>{
	
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	public V put(K key,V value) {
		V oldValue = get(key);
		if(!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else {
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}

	public V get(Object key) {
		if(!keys.contains(key)) 
			return null;
		return values.get(keys.indexOf(key));
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while(ki.hasNext()) 
			set.add(new MapEntry<K, V>(ki.next(),vi.next()));
		return set;
		
	}
	
		@Override
		public int size() {
			return keys.size();
		}
		
	
	public static void main(String[] args) {
		Map<String, String> m = new SlowMap2<String, String>();
		m.putAll(FootballData.play());
		System.out.println(m);
		System.out.println(m.get("曼联"));
		System.out.println(m.entrySet());
	}
}
