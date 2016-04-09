package typeInfo;

public class CharArray {

	public static void main(String[] args) {
		char[] ca = {'a','b'};
		
		System.out.println(ca.getClass().isPrimitive());
		System.out.println(ca instanceof Object);
		System.out.println(ca.getClass().getSuperclass());
	}
}
