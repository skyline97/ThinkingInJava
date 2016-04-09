package interface_;

public class Waveform {

	private static long counter = 0;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return "Waveform " + id;
	}
}
