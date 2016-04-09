package string_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestRegex {

	public static void main(String[] args) {
		if(args.length < 2) {
			System.exit(0);
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for(String arg:args) {
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while(m.find()) {
				System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1) );
			}
		}
	}
	
	@Test
	public void test01() {
		Pattern p = Pattern.compile("s{0,3}");
		Matcher m = p.matcher("Java now has regular expressions");
		while(m.find()) {
			System.out.println(m.group() + " " + m.start() + "-" + (m.end()));
		}
	}
}
