package deepInContainer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AssociativeArray<K, V> {
	
	private Object[][] datas;
	private int index;
	
	public AssociativeArray() {
		this(10);
	}
	
	public AssociativeArray(int length) {
		datas = new Object[length][2];
	}
	
	public void put(K key,V value) {
		if(index >= datas.length)
			throw new ArrayIndexOutOfBoundsException();
		datas[index++] = new Object[]{key,value};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K key) {
		for(int i=0;i<index;i++) {
			if(datas[i][0].equals(key)) {
				return (V) datas[i][1];
			}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i=0;i<index;i++) {
			result.append(datas[i][0].toString());
			result.append("=");
			result.append(datas[i][1].toString());
			if(i < index - 1);
				result.append("  ");
		}
		return result.toString();
	}
	
	public static void count(AssociativeArray<String, Integer> map,String fileName) {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(fileName));
			Pattern p = Pattern.compile("\\w+");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				Matcher m = p.matcher(line);
				while(m.find()) {
					String key = m.group();
					Integer value = map.get(key);
					map.put(m.group(), value == null ? 1 : value + 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
		}
	}
	
	public static void count(Map<String, Integer> map,String fileName) {
		Scanner in = null;
		try {
			in = new Scanner(new FileReader(fileName));
			Pattern p = Pattern.compile("\\w+");
			while(in.hasNextLine()) {
				String line = in.nextLine();
				Matcher m = p.matcher(line);
				while(m.find()) {
					String key = m.group();
					Integer value = map.get(key);
					map.put(m.group(), value == null ? 1 : value + 1);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(in != null) in.close();
		}
	}
	
	public static void main(String[] args) {
		AssociativeArray<String, Integer> map = new AssociativeArray<String, Integer>(100);
		count(map,"E:/temp/transaction.txt");
		System.out.println(map);
		
		System.out.println("-----------------");
		Map<String,Integer> map2 = new HashMap<String, Integer>();
		count(map2,"E:/temp/transaction.txt");
		System.out.println(map2);
		
	}
	
}
