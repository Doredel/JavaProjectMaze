package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream in;
	
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}
	
	@Override
	public int read() throws IOException {
		return this.in.read();
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		int val,num;
		int index=0;		
		while((val=in.read()) != -1) {
			num = in.read();
			for (int i = 0; i < num; i++) {
				b[index] = (byte)val;
				index++;
			}
		}
		return 0;
	}

}
