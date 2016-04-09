package string_;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ThreatAnalyzer {

	static String threatData = 
			"24.23.22.111@03/11/2009\n"
			+ "34.54.223.1@02/10/2005\n"
			+ "204.45.234.40@02/11/2005\n"
			+ "58.58.24.255@03/11/2005\n"
			+ "[Next log section with different data format]";
		
	public static void main(String[] args) {
		Scanner in = new Scanner(threatData);
		Pattern p = Pattern.compile("(?m)(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d{2}/\\d{2}/\\d{4})$");
		while(in.hasNext(p)) {
			in.next(p);
			MatchResult result = in.match();
			String ip = result.group(1);
			String date = result.group(2);
			System.out.printf("Threat on %s from %s\n",date,ip);
		}
		in.close();
	}
}
