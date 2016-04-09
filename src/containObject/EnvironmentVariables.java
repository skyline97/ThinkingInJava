package containObject;

import java.util.Map;

public class EnvironmentVariables {

	public static void main(String[] args) {
		for(Map.Entry<String,String> entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
