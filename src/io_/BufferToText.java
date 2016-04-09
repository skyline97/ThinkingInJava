package io_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {

	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream("dataq.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		
		fc = new FileInputStream("dataq.txt").getChannel();
		ByteBuffer buf = ByteBuffer.allocate(BSIZE);
		fc.read(buf);
		buf.flip();
		
		//Doesnt work
		System.out.println(buf.asCharBuffer());
		
		buf.rewind();
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).newDecoder().decode(buf));
		
		fc = new FileOutputStream("dataq.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		
		fc = new FileInputStream("dataq.txt").getChannel();
		buf.clear();
		fc.read(buf);
		buf.flip();
		System.out.println(buf.asCharBuffer());
		
		fc = new FileOutputStream("dataq.txt").getChannel();
		buf = ByteBuffer.allocate(24);
		buf.asCharBuffer().put("Some text");
		fc.write(buf);
		fc.close();
		
		fc = new FileInputStream("dataq.txt").getChannel();
		buf.clear();
		fc.read(buf);
		buf.flip();
		System.out.println(buf.asCharBuffer());
	}
}
