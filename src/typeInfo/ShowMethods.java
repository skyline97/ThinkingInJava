package typeInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
	
	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in cass or:\n"
			+ "ShowMethods qualified.class.name word:\n"
			+ "To search for methods involving 'word' ";
	
	private static Pattern p = Pattern.compile("\\w+\\.|final|native");
	
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] ms = c.getMethods();
			Constructor<?>[] cons = c.getConstructors();
			if(args.length == 1) {
				for(Method m:ms) {
					System.out.println(p.matcher(m.toString()).replaceAll(""));
				}
				System.out.println("---------------------");
				for(Constructor<?> con:cons) {
					System.out.println(p.matcher(con.toString()).replaceAll(""));
				}
				lines = ms.length + cons.length;
			} else {
				for(Method m:ms) {
					if(m.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(m.toString()).replaceAll(""));
						lines++;
					}
				}
				System.out.println("--------------------");
				for(Constructor<?> con:cons) {
					if(con.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(con.toString()).replaceAll(""));
						lines++;
					}
				}
			}
			System.out.println(lines);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
 