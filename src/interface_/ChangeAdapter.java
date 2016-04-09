package interface_;

public class ChangeAdapter implements Processor {
	
	private ChangeString cs = new ChangeString();

	@Override
	public String name() {
		return cs.getClass().getSimpleName();
	}

	@Override
	public String process(Object input) {
		return cs.swap((String)input);
	}
	
}
