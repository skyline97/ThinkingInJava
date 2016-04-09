package io_;


public class DirectoryDemo {

	public static void main(String[] args) {
		PPrint.pprint(Directory.walk(".").dirs);
		
		PPrint.pprint(Directory.local(".",".*"));
	}
}
