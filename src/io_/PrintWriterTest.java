package io_;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PrintWriterTest {

	public static void main(String[] args) throws IOException {
		FileChannel fc = new RandomAccessFile("data2.txt","rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("haha".getBytes()));
		fc.close();
	}
}
