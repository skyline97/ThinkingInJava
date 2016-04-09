package generic;

import java.util.Date;

public class Decoration {
	public static void main(String[] args) {
		TimeStamped ts = new TimeStamped(new Basic());
		ts.getStamp();
	}
}

class Basic {
	private String value;
	public void set(String val) { value = val;}
	public String get() { return value;}
}

class Decorator extends Basic {
	protected Basic basic;
	public Decorator(Basic basic) {
		this.basic = basic;
	}
	public void set(String val) {
		basic.set(val);
	}
	public String get() {
		return basic.get();
	}
}

class TimeStamped extends Decorator {
	private final long timeStamp;
	public TimeStamped(Basic basic) {
		super(basic);
		timeStamp = new Date().getTime();
	}
	public long getStamp() {
		return timeStamp;
	}
	
}
