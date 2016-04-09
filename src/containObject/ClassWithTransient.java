package containObject;

public class ClassWithTransient {

	transient Object[] os;
	
	public ClassWithTransient() {
	}
	
	public ClassWithTransient(Object[] os) {
		this.os = os;
	}
}
