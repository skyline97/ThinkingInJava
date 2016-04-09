package interface_;

public class GameApply {
	
	public static void play(Game g) {
		g.doGame();
	}
	
	public static void play(GameFactory gf) {
		Game g = gf.getGame();
		g.doGame();
	}

	public static void main(String[] args) {
		play(new CoinGame());
		play(new DiceGameFactory());
	}
}
