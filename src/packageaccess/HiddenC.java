package packageaccess;

import typeInfo.interfacea.A;

public class HiddenC {
	public static A makeA() {
		return new C();
	}
}

class C implements A{

	@Override
	public void f() {
		System.out.println("public C.f()");
	}
	
	public void g() {
		System.out.println("public C.g()");
	}
	
	void u() {
		System.out.println("package u()");
	}
	
	protected void v() {
		System.out.println("protected C.v()");
	}
	
	private void w() {
		System.out.println("private C.w()");
	}
}
