package enum_;

public enum OverrideConstantSpecific {

	NUT,BOLT,
	WASHER {
		@Override
		void f() {
			System.out.println("Overridden method");
		}
	};
	
	void f() {
		System.out.println("Default behavior");
	}
	
	public static void main(String[] args) {
		for(OverrideConstantSpecific ocs : values()) {
			ocs.f();
		}
	}
}
