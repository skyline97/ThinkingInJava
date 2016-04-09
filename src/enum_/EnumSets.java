package enum_;

import java.util.EnumSet;

import static enum_.AlarmPoints.*;

public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(BATHROOM);
		System.out.println(points);
		//EnumSet.of的返回值是一个包含所有参数的EnumSet
		points.addAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.of(STAIR1,STAIR2,KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}
