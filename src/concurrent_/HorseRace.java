package concurrent_;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
	static final int FINISH_LINE = 75;
	private List<Horse> horses = new ArrayList<Horse>();
	private ExecutorService exe = Executors.newCachedThreadPool();
	private CyclicBarrier barrier;
	
	public HorseRace(int nHorses,final int pause) {
		barrier = new CyclicBarrier(nHorses,new Runnable() {
			
			@Override
			public void run() {
				StringBuilder s = new StringBuilder();
				for(int i=0;i<FINISH_LINE;i++)
					s.append("=");
				System.out.println(s);
				
				for(Horse h:horses) {
					System.out.println(h.tracks());
				}
				
				for(Horse h:horses) {
					if(h.getStrides() >= FINISH_LINE) {
						System.out.println(h + " won!");
						exe.shutdownNow();
						return;
					}
				}
				
				try {
					TimeUnit.MILLISECONDS.sleep(pause);
				} catch (InterruptedException e) {
					System.out.println("barrier-action sleep interrupted");
				}
			}
		});
		
		for(int i=0;i<nHorses;i++) {
			Horse h = new Horse(barrier);
			horses.add(h);
			exe.execute(h);
		}
	}
	
	public static void main(String[] args) {
		int nHorses = 7;
		int pause = 200;
		
		new HorseRace(nHorses, pause);
	}
}

class Horse implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private int strides = 0;
	private static Random ran = new Random(47);
	private static CyclicBarrier barrier;
	
	public Horse(CyclicBarrier c) {
		barrier = c;
	}
	
	public synchronized int getStrides() {
		return strides;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					strides += ran.nextInt(3);
				}
				barrier.await();
			}
		} catch (InterruptedException e) {
			
		} catch (BrokenBarrierException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return "Horse " + id + " " ;
	}
	
	public String tracks() {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<getStrides();i++) {
			s.append("*");
		}
		s.append(id);
		return s.toString();
	}
}
