package array;

public class ConvertTo {

	public static boolean[] primitive(Boolean[] in) {
		boolean[] result = new boolean[in.length];
		for(int i=0;i<in.length;i++) {
			result[i] = in[i];
		}
		return result;
	}
}
