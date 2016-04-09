package enum_;

public class NotClasses {
	
	//void f1(LikeClasses.WINKEN instance) {};
}

enum LikeClasses {
	WINKEN {
		@Override
		void behavior() {
			System.out.println("Behavior1");
		}
	},
	
	BLINKEN {
		@Override
		void behavior() {
			System.out.println("Behavior2");
		}
	};
	
	abstract void behavior();
}
