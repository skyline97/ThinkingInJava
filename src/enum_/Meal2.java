package enum_;

public enum Meal2 {

	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class);
	
	private Food[] values;
	
	private Meal2(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}
	
	public interface Food {
		enum Appetizer implements Food {
			SALAD,SOUP,SPRING_ROLLS;
		}
		enum MainCourse implements Food {
			LASAGNE,BURRITO,PAD_THAI,
			LENTILS,HUMMOUS,VINDALOO;
		}
	}
	
	public Food randomSelection() {
		return Enums.random(values);
	}
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			for(Meal2 meal : Meal2.values()) {
				Food food = meal.randomSelection();
				System.out.println(food);
			}
			System.out.println("------");
		}
	}
}
