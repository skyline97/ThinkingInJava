package io_;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;

public class LargeMappedFiles {

	static int length = 0x8ffffff;
	
	public static void main(String[] args) throws Exception {
		MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel()
				.map(MapMode.READ_WRITE, 0, length);
		for(int i=0;i<length;i++) 
			out.put((byte)'x');
		System.out.println("Finished writing");
		for(int i=length/2;i<length/2+6;i++)
			System.out.print((char)out.get(i));
	}
}
