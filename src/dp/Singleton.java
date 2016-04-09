package dp;

public class Singleton {
	
	private static Singleton instance;
	
	private Singleton() {
	}
	
	public static Singleton newInstance() {
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.newInstance();
		Singleton s2 = Singleton.newInstance();
		System.out.println(s1 == s2);
	}
}
