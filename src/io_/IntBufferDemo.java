package io_;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		ib.put(new int[]{0,1,2,3,4,5,6});
		System.out.println(ib.get(3));
		ib.put(3,33);
		ib.flip();
		while(ib.hasRemaining()) {
			int i = ib.get();
			System.out.print(i + " ");
		}
		System.out.println();
		while(bb.hasRemaining()) 
			System.out.print(bb.getInt() + ", ");
		System.out.println();
		System.out.println(bb);
	}
}
