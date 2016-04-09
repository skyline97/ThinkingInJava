package exception_;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException extends Exception{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger("LoggingException");
	
	public LoggingException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
		//printStackTrace();
	}
}

public class LoggingExceptions {
	
	public static void test() throws LoggingException {
		throw new LoggingException();
	}
	
	public static void main(String[] args) {
		System.out.println("-----------------------------");
		try {
			test();
		} catch (LoggingException e) {
			System.err.println("Caught " + e);
		}
	}
}
