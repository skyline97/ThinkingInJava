package generic;

public class P_30 {
	
	
	
	public static void main(String[] args) {
		Holder<Integer> intHolder = new Holder<Integer>(17);
		int i = intHolder.get();
		intHolder.set(18);
	}
}

interface Payable<T> {}

class Employee1 implements Payable<Employee1> {}

class Hourly extends Employee1 implements Payable<Employee1> {}
