package interface_;

public class ChangeString {

	String swap(String input) {
		char[] cs = input.toCharArray();
		for(int i=0;i<cs.length;i++) {
			char temp = cs[i];
			if(i % 2 == 0)
				cs[i] = temp;
			else
				cs[i] = cs[i - 1];
		}
		return new String(cs);
	}
	
}
