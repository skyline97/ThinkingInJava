package enum_;

import java.util.Random;

public enum Input {
	NICKEL(5),DIME(10),QUARTER(25),DOLLAR(100),
	TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
	ABORT_TRANSACTION {
		public int amount() {
			throw new RuntimeException("ABORT.amount()");
		}
	},
	STOP {
		public int amount() {
			throw new RuntimeException("SHUT_DOWN.amount()");
		}
	};
	
	int value;
	private Input(int value) {
		this.value = value;
	}
	
	private Input() {
	}
	
	int amount() {
		return value;
	}
	
	static Random ran = new Random(47);
	
	/**
	 * values()返回值是enum类型的数组
	 * @return
	 */
	public static Input randomSelection() {
		return values()[ran.nextInt(values().length - 1)];
	}
	
}
