package exception_;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class SimpleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger("LoggingException");

	public SimpleException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
	
	public SimpleException(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "111111";
	}
	
}
