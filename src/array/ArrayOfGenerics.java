package array;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {

	public static void main(String[] args) {
		//List<String>[] ls = new List<String>[10];
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la;
		ls[0] = new ArrayList<String>();
		//ls[1] = new ArrayList<Integer>();
		
		Object[] objects = ls;
		objects[1] = new ArrayList<Integer>();//OK!
	}
}
