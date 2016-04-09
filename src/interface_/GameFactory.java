package interface_;

public interface GameFactory {

	Game getGame();
	
}

class CoinGameFactory implements GameFactory {
	
	@Override
	public Game getGame() {
		return new CoinGame();
	}
}

class DiceGameFactory implements GameFactory {
	
	@Override
	public Game getGame() {
		return new DiceGame();
	}
}
