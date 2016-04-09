package innerClass;

import innerClass.Parcel2.Contents;

public class Outer {

	class Inner {
		
	}
	
	Inner m() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Inner i = o.m();
		Parcel2 p = new Parcel2();
		Contents c = p.contents();
	}
}
