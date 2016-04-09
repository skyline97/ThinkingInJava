package deepInContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Countries.names());
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(list);
		for(int i=0;i<10;i++) {
			Collections.shuffle(list);
			System.out.println(list);
		}
	}
}
