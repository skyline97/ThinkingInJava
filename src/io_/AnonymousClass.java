package io_;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class AnonymousClass {
	
	private String s;

	public FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			Pattern p = Pattern.compile(s);
			@Override
			public boolean accept(File dir, String name) {
				return p.matcher(name).matches();
			}
		};
	}
}
