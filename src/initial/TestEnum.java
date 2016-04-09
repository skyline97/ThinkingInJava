package initial;

public class TestEnum {
	
	Size size;
	
	void describe() {
		switch(size) {
		case SMALL : 
			System.out.println("小");
			break;
		case MEDIUM :
			System.out.println("中");
			break;
		case LARGE :
			System.out.println("大");
			break;
		default :
			System.out.println("?");
		}
	}
	
	public static void main(String[] args) {
		for(Size size:Size.values()) {
			TestEnum t = new TestEnum();
			t.size = size;
			t.describe();
		}
	}

}

enum Size {
	SMALL("s"),MEDIUM("m"),LARGE("l");
	
	private String abbreviation;

	public String getAbbreviation() {
		return abbreviation;
	}
	
	private Size(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}
