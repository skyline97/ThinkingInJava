package io_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TransferTo {
	
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception{
		if(args.length != 2) {
			System.out.println("arguments: sourcefile destfile");
			System.exit(1);
		}
		
		FileChannel in = new FileInputStream(args[0]).getChannel();
		FileChannel out = new FileOutputStream(args[1]).getChannel();
		ByteBuffer buf = ByteBuffer.allocate(BSIZE);
		
		in.transferTo(0,in.size(), out);
	}
}
