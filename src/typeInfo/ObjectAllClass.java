package typeInfo;

public class ObjectAllClass {

	public static void printSuperClass(Object obj) {
		Class<?> c = obj.getClass();
		Class<?> sup = c.getSuperclass();
		System.out.println(sup.getSimpleName());
	}
	
	public static void main(String[] args) {
		printSuperClass(123);
	}
}
