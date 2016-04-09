package enum_;

import java.util.EnumMap;
import java.util.Map.Entry;

import static enum_.AlarmPoints.*;

public class EnumMaps {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(KITCHEN, new Command() {
			@Override
			public void action() {
				System.out.println("Kitchen fire");
			}
		});
		
		em.put(BATHROOM, new Command() {
			@Override
			public void action() {
				System.out.println("Bathroom fire");
			}
		});
		
		for(Entry<AlarmPoints, Command> entry:em.entrySet()) {
			System.out.print(entry.getKey() + ": " + entry.getValue());
			entry.getValue().action();
		}
		
		try {
			em.get(UTILITY).action();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

interface Command {
	void action();
}
