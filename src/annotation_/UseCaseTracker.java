package annotation_;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UseCaseTracker {

	public static void trackUseCases(List<Integer> useCases,Class<?> cla) {
		for(Method m:cla.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if(uc != null) {
				System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
				//如果remove(uc.id())则移除的是Index为id的元素,抛出IndexoutofboundsException
				useCases.remove(new Integer(uc.id()));
			}
		}
		for(int i:useCases) {
			System.out.println("Warning:Missing use case-" + i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47,48,49,50);
		trackUseCases(useCases, PasswordUtils.class);
	}
}
