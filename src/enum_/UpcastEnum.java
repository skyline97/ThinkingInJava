package enum_;

import java.util.Arrays;

public class UpcastEnum {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Search[] vals = Search.values();
		System.out.println(Arrays.toString(vals));
		Enum<Search> e = Search.HITHER;
		for(Enum<Search> en : e.getClass().getEnumConstants())
			System.out.println(en);
	}
}

enum Search {
	HITHER,YON
}
