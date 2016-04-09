package io_;

import java.io.IOException;
import java.nio.ByteBuffer;

public class TestSlice {

	public static void main(String[] args) throws IOException {
		ByteBuffer bb = ByteBuffer.wrap("abcdef".getBytes());
		System.out.println(bb);
		bb.position(2);
		bb.limit(4);
		System.out.println(bb);
		ByteBuffer slice = bb.slice();
		System.out.println(slice);
		while(slice.hasRemaining())
			System.out.print((char)slice.get() + " ");
		slice.rewind();
		slice.put("mn".getBytes());
		slice.rewind();
		while(slice.hasRemaining())
			System.out.print((char)slice.get() + " ");
		System.out.println();
		System.out.println(bb);
		bb.clear();
		while(bb.hasRemaining())
			System.out.print((char)bb.get() + " ");
		
		ByteBuffer a = ByteBuffer.wrap("qwe".getBytes());
		a.position(2);
		System.out.println(a);
		System.out.println((char)a.get());
//		bb.putChar('q');
//		System.out.println(bb);
//		bb.flip();
//		System.out.println(bb.getChar());
	}
}
