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
		
		for (int i = 0; i < b.length; i+=2) {
			val = this.read();
			num = this.read();
			
			b[i] = (byte)val;
			b[i+1] = (byte)num;
		}
		return 0;
	}

}
