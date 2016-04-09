package exception_;

public class StormyInning extends Inning implements Storm{
	
	public StormyInning() throws BaseballException,RainedOut {
	}
	
	public StormyInning(String s) throws BaseballException,Foul {
	}
	
	@Override
	public void walk() {
	}
	
	@Override
	public void event() {
	}

	@Override
	public void rainHard() throws RainedOut {
	}

	@Override
	public void atBat() throws PopFoul {
	}
	
	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (PopFoul e) {
			e.printStackTrace();
		} catch (RainedOut e) {
			e.printStackTrace();
		} catch (BaseballException e) {
			e.printStackTrace();
		}
		try {
			Inning i = new StormyInning();
			i.atBat();
		} catch (RainedOut e) {
			e.printStackTrace();
		} catch (Strike e) {
			e.printStackTrace();
		} catch (Foul e) {
			e.printStackTrace();
		} catch (BaseballException e) {
			e.printStackTrace();
		}
	}
	
}



abstract class Inning {
	public Inning() throws BaseballException{
	}
	public void event() throws BaseballException {
		
	}
	public abstract void atBat() throws Strike,Foul;
	public void walk() {}
}

interface Storm {
	public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class PopFoul extends Foul {};
class Strike extends BaseballException {}

class StormException extends Exception {}
class RainedOut extends StormException {}

