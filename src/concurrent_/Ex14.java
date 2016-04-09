package concurrent_;

import java.util.Timer;
import java.util.TimerTask;

public class Ex14 {
	
	public static void main(String[] args) {
		Timer t = new Timer();
		for(int i=0;i<5;i++)
			t.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("haha");
				}
			}, 100);
		
	}
}
