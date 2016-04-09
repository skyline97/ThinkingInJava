package interface_;

public class Filter {

	public String name() {
		return getClass().getSimpleName();
	}
	
	public Waveform process(Object input) {
		return (Waveform) input;
	}

}
