package array;

import java.util.Arrays;

public class CopyArrays {

	public static void main(String[] args) {
		User[] users = new User[10];
		Arrays.fill(users, new User());
		System.out.println(Arrays.toString(users));
		User[] copy = new User[10];
		System.arraycopy(users, 0, copy, 0, users.length);
		copy[0].setName("qwe");
		System.out.println(Arrays.toString(copy));
		System.out.println(Arrays.toString(users));
	}
}

class User {
	private String name;
	
	public User() {
		name = "pfw";
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
