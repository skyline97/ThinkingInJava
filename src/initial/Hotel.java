package initial;

public class Hotel {

	boolean checkedOut;
	
	public Hotel(boolean checkOut) {
		this.checkedOut = checkOut;
	}
	
	void checkOut() {
		checkedOut = true;
	}
	
	@Override
	protected void finalize() {
		if(!checkedOut) 
			System.out.println("Error: not checkout");
		//super.finalize();
	}
	
	public static void main(String[] args) {
		Hotel h = new Hotel(false);
		h.checkOut();
		new Hotel(false);
		System.gc();
		System.runFinalization();
	}
}
