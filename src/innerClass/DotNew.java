package innerClass;

public class DotNew {

	public class Inner {
		private int i = 10;
	}
	
	
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		Inner i = dn.new Inner();
		System.out.println(i.i);
	}
}
