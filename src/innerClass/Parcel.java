package innerClass;

public class Parcel {

	public Destination destination(final P5 dest) {
		return new Destination() {
			private P5 label = dest;
			
			@Override
			public P5 readLabel() {
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Destination d = p.destination(new P5());
		P5 label = d.readLabel();
		System.out.println(label);
	}
}

