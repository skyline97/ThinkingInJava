package interface_;

public class Apply {

	public static void process(Processor processor,Object input) {
		System.out.println(processor.name());
		System.out.println(processor.process(input));
	}
	
	public static void main(String[] args) {
		process(new ChangeAdapter(), "qwaals");
	}
	
}
