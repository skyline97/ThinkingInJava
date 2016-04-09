package typeInfo;

public class RealObject implements Interface{

	@Override
	public void doSomething() {
		System.out.println("do something");
	}
	
	@Override
	public void somethingElse(String args) {
		System.out.println("something else " + args);
	}
}
