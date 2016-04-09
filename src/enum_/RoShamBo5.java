package enum_;

import java.util.EnumMap;

public enum RoShamBo5 implements Competitor<RoShamBo5> {
	
	PAPER,SCISSORS,ROCK;
	
	static EnumMap<RoShamBo5,EnumMap<RoShamBo5,OutCome>> table = 
			new EnumMap<RoShamBo5, EnumMap<RoShamBo5,OutCome>>(RoShamBo5.class);

	static {
		for(RoShamBo5 it : RoShamBo5.values()) 
			table.put(it, new EnumMap<RoShamBo5, OutCome>(RoShamBo5.class));
		initRow(PAPER, OutCome.DRAW, OutCome.LOSE, OutCome.WIN);
		initRow(SCISSORS, OutCome.WIN, OutCome.DRAW, OutCome.LOSE);
		initRow(ROCK, OutCome.LOSE, OutCome.WIN, OutCome.DRAW);
	}
	
	static void initRow(RoShamBo5 it,OutCome vPAPER,OutCome vSCISSORS,OutCome vROCK) {
		EnumMap<RoShamBo5, OutCome> row = RoShamBo5.table.get(it);
		row.put(PAPER, vPAPER);
		row.put(SCISSORS, vSCISSORS);
		row.put(ROCK, vROCK);
	}
	
	@Override
	public OutCome compete(RoShamBo5 it) {
		return table.get(this).get(it);
	}
	
	public static void main(String[] args) {
		RoShamBo.play(RoShamBo5.class, 10);
	}
}
