package interface_;

public class Upcase extends AbstractProcessor {
	
	@Override
	public String process(Object input) {
		return ((String)input).toUpperCase();
	}
	
}
