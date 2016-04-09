package interface_;

import java.util.Arrays;

public class Splitter extends AbstractProcessor {

	@Override
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}

}
