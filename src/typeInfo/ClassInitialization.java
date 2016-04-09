package typeInfo;

import java.util.Random;

public class ClassInitialization {
	public static Random ran = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> initable = Initable.class;
		System.out.println(initable.getName());
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		//初始化被延迟到了对静态方法或者非常数静态域进行首次引用时才执行
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNonFinal);
		Class<?> initable3 = Class.forName("fourteen.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}

class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.ran.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}