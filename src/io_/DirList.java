package io_;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {

	public static void main(final String[] args) {
		File path = new File("src");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else {
			//final String regex = args[0];
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(".*teen");
				@Override
				public boolean accept(File dir, String name) {
					//System.out.println(pattern);
					//System.out.println(name);
					return pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
		for(String dirItem:list)
			System.out.println(dirItem);
		
	}
}
