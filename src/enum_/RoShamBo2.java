package enum_;

import static enum_.OutCome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
	
	PAPER(DRAW,LOSE,WIN),
	SCISSORS(WIN,DRAW,LOSE),
	ROCK(LOSE,WIN,DRAW);
	
	private OutCome vPAPER,vSCISSORS,vROCK;
	
	private RoShamBo2(OutCome vPAPER, OutCome vSCISSORS, OutCome vROCK) {
		this.vPAPER = vPAPER;
		this.vSCISSORS = vSCISSORS;
		this.vROCK = vROCK;
	}

	@Override
	public OutCome compete(RoShamBo2 competitor) {
		switch(competitor) {
			default:
			case PAPER: return vPAPER;
			case SCISSORS: return vSCISSORS;
			case ROCK: return vROCK;
		}
	}
	
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo2.class, 10);
	}

	
}
