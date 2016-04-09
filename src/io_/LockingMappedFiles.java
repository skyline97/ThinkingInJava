package io_;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class LockingMappedFiles {

	static final int LENGTH = 0x8ff;
	static FileChannel fc;
	
	public static void main(String[] args) throws Exception {
		fc = new RandomAccessFile("test.dat","rw").getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for(int i=0;i<LENGTH;i++)
			out.put((byte)('x'));
		new LockAndModify(out, 0, 0 + LENGTH / 3);
		new LockAndModify(out, LENGTH / 2, LENGTH / 2 + LENGTH / 4);
	}
	
	private static class LockAndModify extends Thread {
		private ByteBuffer buf;
		private int start,end;
		
		LockAndModify(ByteBuffer bb,int start,int end) {
			this.start = start;
			this.end = end;
			bb.limit(end);
			bb.position(start);
			buf = bb.slice();
			start();
		}
		
		@Override
		public void run() {
			try {
				FileLock fl = fc.lock(start,end,false);
				System.out.println("Locked: " + start + " to " + end);
				while(buf.position() < buf.limit() - 1)
					buf.put((byte)(buf.get() + 1));
				fl.release();
				System.out.println("Released: " + start + " to " + end);
				//System.out.println((char)buf.get(2));
			} catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
