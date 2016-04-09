package array;

import java.lang.reflect.Array;

import deepInContainer.CollectionData;
import generic.Generator;

public class Generated {

	public static <T> T[] array(T[] a,Generator<T> gen) {
		return new CollectionData<T>(gen, a.length).toArray(a);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] array(Class<T> type,Generator<T> gen,int size) {
//		T[] arr = (T[]) Array.newInstance(type, size);
//		for(int i=0;i<arr.length;i++) {
//			arr[i] = gen.next();
//		}
//		return arr;
		
		T[] arr = (T[]) Array.newInstance(type, size);
		return new CollectionData<T>(gen, size).toArray(arr);
	}
}
