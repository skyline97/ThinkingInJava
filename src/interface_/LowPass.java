package interface_;

public class LowPass extends Filter {

	double cutoff;
	
	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}
	
	@Override
	public Waveform process(Object input) {
		return (Waveform) input;
	}
}
