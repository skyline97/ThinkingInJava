package introduction;

public class Alias2 {
	
	static void change(Word w) {
		w.setC('p');
	}

	public static void main(String[] args) {
		Word w = new Word();
		w.setC('g');
		System.out.println(w.getC());
		change(w);
		System.out.println(w.getC());
	}
}

class Word {
	char c;

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
}
