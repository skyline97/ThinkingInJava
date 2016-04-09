package interface_;

public class FilterProcessor {

	public static void main(String[] args) {
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(0)), w);
		Apply.process(new FilterAdapter(new LowPass(1)), w);
		Apply.process(new FilterAdapter(new LowPass(2)), w);
	}
}
