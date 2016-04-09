package enum_;

import enum_.Food.Appetizer;
import enum_.Food.MainCourse;

public class TypeOfFood {

	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		System.out.println(food);
	}
}
