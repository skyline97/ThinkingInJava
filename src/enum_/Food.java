package enum_;

public interface Food {

	enum Appetizer implements Food {
		SALAD,SOUP,SPRING_ROLLS;
	}
	
	enum MainCourse implements Food {
		LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
	}
	
}
