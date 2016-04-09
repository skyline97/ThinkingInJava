package string_;

public class Inmutable {

	public static String upcase(String s) {
		return s.toUpperCase();
	}
	
	public static User test(User u) {
		u = null;
		return u;
	}
	
	public static void main(String[] args) {
		User u = new User();
		u.name = "pfw";
		System.out.println(u);
		User uu = test(u);
		System.out.println(u);
		System.out.println(uu);
	}
}

class User {
	String name;
	
	@Override
	public String toString() {
		return name;
	}
}