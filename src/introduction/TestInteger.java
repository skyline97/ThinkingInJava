package introduction;

public class TestInteger {

	public static Integer change(Integer i) {
		return i + 1;
	}
	
	public static void change(String s) {
		s = s + "q";
	}
	
	public static void main(String[] args) {
		Integer i = 0;
		change(i);
		System.out.println(i);
		
		String s = "q";
		change(s);
		System.out.println(s);
	}
}
