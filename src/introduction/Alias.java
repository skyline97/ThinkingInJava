package introduction;

public class Alias {

	static void f(Letter y) {
		y.c = 'z';
	}
	
	public static void main(String[] args) {
		Letter x = new Letter();
		x.c = 'a';
		System.out.println(x.c);
		f(x);
		System.out.println(x.c);
	}
	
}

class Letter {
	char c;
}
