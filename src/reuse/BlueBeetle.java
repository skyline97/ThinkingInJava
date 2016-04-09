package reuse;

public class BlueBeetle extends Beetle {
	
	public BlueBeetle() {
		System.out.println("BlueBeetle constructor");
	}

	public static void main(String[] args) {
		System.out.println("main");
		BlueBeetle bb = new BlueBeetle();
	}
}
