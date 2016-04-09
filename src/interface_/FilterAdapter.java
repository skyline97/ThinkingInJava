package interface_;

public class FilterAdapter implements Processor {
	
	private Filter filter;
	
	public FilterAdapter(Filter filter) {
		this.filter = filter;
	}

	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Waveform process(Object input) {
		return filter.process((Waveform) input);
	}

	
}
