package enum_;

import static enum_.OutCome.*;

public enum RoShamBo3 implements Competitor<RoShamBo3> {
	PAPER{
		@Override
		public OutCome compete(RoShamBo3 it) {
			switch(it) {
				default:
				case PAPER: return DRAW;
				case SCISSORS: return LOSE;
				case ROCK: return WIN;
			}
		}
	},
	
	SCISSORS {
		@Override
		public OutCome compete(RoShamBo3 it) {
			switch(it) {
				default:
				case PAPER:return WIN;
				case SCISSORS: return DRAW;
				case ROCK: return LOSE;
			}
		}
	},
	
	ROCK {
		@Override
		public OutCome compete(RoShamBo3 it) {
			switch(it) {
				default:
				case PAPER:return LOSE;
				case SCISSORS: return WIN;
				case ROCK: return DRAW;
			}
		}
	};
	
	public abstract OutCome compete(RoShamBo3 it);
	
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo3.class, 10);
	}
}
