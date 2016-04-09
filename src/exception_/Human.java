package exception_;

public class Human {

	public static void main(String[] args) {
		try {
			throw new Sneeze();
		}catch(Sneeze e) {
			
		}catch (Annoyance e) {
		}
	}
}

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
