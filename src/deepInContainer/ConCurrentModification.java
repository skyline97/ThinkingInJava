package deepInContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConCurrentModification {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("q");
		list.add("w");
		//list.add("e");
		for(Iterator<String> it = list.iterator();it.hasNext();) {
			System.out.println(it.next());
			list.remove("w");
		}
	}
}
