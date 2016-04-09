package exception_;

public class MyException2 extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int x;
	
	public MyException2() {
	}
	
	public MyException2(String msg) {
		super(msg);
	}
	
	public MyException2(String msg,int x) {
		super(msg);
		this.x = x;
	}
	
	public int val() {
		return x;
	}
	
	public String getMsg() {
		return "Detail Message: " + x + " " + super.getMessage();
	}

}
