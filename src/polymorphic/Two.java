package polymorphic;

public class Two extends One {
	
	static {
		System.out.println("static two");
	}
	
	private static int id = 10;
	
	public static void main(String[] args) {
		//Two t = new Two();
	}
	
	@Override
	public Wheat a() {
		System.out.println("two do" + id);
		return new Wheat();
	}
}
