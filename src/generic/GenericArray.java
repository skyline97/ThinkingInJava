package generic;

public class GenericArray<T> {

	private T[] array;
	
	@SuppressWarnings("unchecked")
	public GenericArray(int size) {
		array = (T[])new Object[size];
	}
	
	public void put(int index,T item) {
		array[index] = item;
	}
	
	public T get(int index) {
		return array[index];
	}
	
	public T[] rep() {
		return array;
	}
	
	public static void main(String[] args) {
		GenericArray<Integer> a = new GenericArray<Integer>(10);
		for(int i=0;i<10;i++) {
			a.put(i,i);
		}
		for(int i=0;i<10;i++) {
			System.out.println(a.get(i) + " ");
		}
		System.out.println();
	}
}
