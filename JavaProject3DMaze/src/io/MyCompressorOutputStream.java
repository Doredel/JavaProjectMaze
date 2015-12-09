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
		int counter = 0;
		
		for (int i = 1; i < b.length; i++) {
			if (b[i-1] != b[i]) {
				this.write(b[i-1]);
				this.write(counter); 
			} else {
				counter++;
				if (i == b.length-1) {
					this.write(b[i]);
					this.write(counter); 
				}
			}
		}
	}

}
