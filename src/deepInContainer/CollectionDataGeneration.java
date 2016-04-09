package deepInContainer;

import java.util.ArrayList;
import java.util.HashSet;

import array.RandomGenerator;

public class CollectionDataGeneration {
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(
				CollectionData.list(new RandomGenerator.String(9), 10)));
		
		System.out.println(new HashSet<java.lang.Character>(
				new CollectionData<Character>(new RandomGenerator.Character(), 10)));
	}
}
