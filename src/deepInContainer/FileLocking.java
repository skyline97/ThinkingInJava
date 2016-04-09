package deepInContainer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new MyThread());
		t.start();
		FileOutputStream fos = new FileOutputStream("test.txt");
		FileLock fl = fos.getChannel().tryLock();
		if(fl != null) {
			System.out.println("Locked file");
			TimeUnit.MILLISECONDS.sleep(10000);
			fl.release();
			System.out.println("Released Lock");
		}
		fos.close();
	}
	
	private static class MyThread implements Runnable {

		@Override
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(5000);
				RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
				raf.read();
				raf.close();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
