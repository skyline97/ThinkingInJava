package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ObjectAnalyzer {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String name;
		if(args.length > 0) 
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name (e.g. java.util.Date): ");
			name = in.next();
		}
		
		try {
			Class<?> cla = Class.forName(name);
			Class<?> superCla = cla.getSuperclass();
			String modifiers = Modifier.toString(cla.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print("class " + name);
			if(superCla != null && superCla != Object.class) 
				System.out.print(" extends " + superCla.getName());
			System.out.print("\n{\n");
			printConstructors(cla);
			System.out.println();
			printMethods(cla);
			System.out.println();
			printFields(cla);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public static void printConstructors(Class<?> cla) {
		Constructor<?>[] constructors = cla.getDeclaredConstructors();
		for(Constructor<?> c:constructors) {
			String name = c.getName();
			System.out.print("   ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(name + "(");
			
			Class<?>[] paramTypes = c.getParameterTypes();
			for(int i = 0;i < paramTypes.length; i++) {
				if(i > 0) System.out.print(", ");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printMethods(Class<?> cla) {
		Method[] methods = cla.getDeclaredMethods();
		for(Method m:methods) {
			Class<?> retType = m.getReturnType();
			String name = m.getName();
			
			System.out.print("    ");
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name + "(");
			Class<?>[] parameterTypes = m.getParameterTypes();
			for(int i = 0;i < parameterTypes.length; i++) {
				if(i > 0) System.out.print(", ");
				System.out.print(parameterTypes[i].getName());
			}
			System.out.println(");");
		}
	}
	
	public static void printFields(Class<?> cla) {
		Field[] fields = cla.getDeclaredFields();
		
		for(Field f:fields) {
			Class<?> type = f.getType();
			String name = f.getName();
			System.out.print("    ");
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length() > 0) System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}

}

