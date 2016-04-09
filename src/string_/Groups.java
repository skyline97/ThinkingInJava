package string_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups {

	public static final String POEM = 
			"Twas brillig, nad the slithy toves\n" +
			"Did gyre and gimble in the wabe.\n";
	
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while(m.find()) {
			for(int i=0;i<=m.groupCount();i++) {
				System.out.print("[" + m.group(i) + "]");
			}
			System.out.println();
		}
		
		Matcher m2 = Pattern.compile("[a-z]+").matcher(POEM);
		int num = 0;
		while(m2.find()) {
			System.out.print(m2.group() + "  ");
			num++;
		}
		System.out.println();
		System.out.println(num);
	}
}
