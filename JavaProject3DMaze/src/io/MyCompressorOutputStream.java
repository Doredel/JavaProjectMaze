package io;

import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {

	private OutputStream out;
	
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}
	
	@Override
	public void write(int arg0) throws IOException {
		this.out.write(arg0);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		int counter = 1;
		
		for (int i = 0; i < b.length-1; i++) {
			if (b[i] != b[i+1]) {
				this.write(b[i]);
				this.write(counter);
				counter=1;
			} else {
				counter++;
			
			}
		}
		this.write(b[b.length-1]);
		this.write(counter); 
	}

}
