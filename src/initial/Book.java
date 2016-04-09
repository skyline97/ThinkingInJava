package initial;

public class Book {

	boolean checkedOut = false;
	
	public Book(boolean checkOut) {
		checkedOut = checkOut;
	}
	
	void checkIn() {
		checkedOut = false;
	}
	
	@Override
	protected void finalize() {
		if(checkedOut)
			System.out.println("Error:checked out");
		//super.finalize();
	}
	
}
