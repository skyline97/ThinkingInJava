package containObject;

import java.util.LinkedList;

public class TestStack {

	private LinkedList<Character> stack = new LinkedList<Character>();
	
	public void getMeaning(String s) {
		char[] ca = s.toCharArray();
		for(int i=0;i<ca.length;i++) {
			if(ca[i] == '-')
				System.out.print(stack.poll());
			if(ca[i] == '+')
				stack.push(ca[i + 1]);
		}
	}
	
	public static void main(String[] args) {
		TestStack ts = new TestStack();
		ts.getMeaning("+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---");
	}
}
