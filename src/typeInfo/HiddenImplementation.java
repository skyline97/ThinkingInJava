package typeInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import packageaccess.HiddenC;
import typeInfo.interfacea.A;

public class HiddenImplementation {

	public static void main(String[] args) {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");//default method
		callHiddenMethod(a, "v");//protected method
		callHiddenMethod(a, "w");//private method
	}
	
	public static void callHiddenMethod(Object a,String methodName) {
		try {
			Method m = a.getClass().getDeclaredMethod(methodName);
			m.setAccessible(true);
			m.invoke(a);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
