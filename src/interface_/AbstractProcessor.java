package interface_;

public abstract class AbstractProcessor implements Processor{
	
	public static final String S = "If she weighs the same as a duck,she's made of wood";

	@Override
	public String name() {
		return getClass().getSimpleName();
	}
	
	@Override
	public abstract Object process(Object input);
	
	public static void main(String[] args) {
		Apply.process(new Upcase(), S);
	}
}
