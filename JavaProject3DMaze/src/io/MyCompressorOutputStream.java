package io;

import java.io.IOException;
import java.io.OutputStream;
/**
 * The <b>MyCompressorOutputStream</b> class represents a type of output stream
 * With an OutputStream content 
 * @authors Dor Edelstein, Lior Mantin
 * @since 16/12/2015
 * @see OutputStream
 */
public class MyCompressorOutputStream extends OutputStream {

	/**
	 * The out content
	 */
	private OutputStream out;
	/**
	 * <strong>MyCompressorOutputStream</strong>
	 * <p>
	 * <code>public MyCompressorOutputStream(OutputStream out)</code>
	 * <p>
	 * Constructor of <b>MyCompressorOutputStream</b> that gets an OutputStream variable and initialize the out content
	 * 
	 * @param OutputStream out 
	 * @return nothing
	 */
	public MyCompressorOutputStream(OutputStream out) {
		this.out = out;
	}
	/**
	 * <strong>write</strong>
	 * <p>
	 * <code>public void write(int arg0) throws IOException</code>
	 * <p>
	 * Writes an int argument to the Output stream field
	 * 
	 * @param  int arg0
	 * @return nothing
	 */
	@Override
	public void write(int arg0) throws IOException {
		this.out.write(arg0);
	}
	/**
	 * <strong>write</strong>
	 * <p>
	 * <code>public void write(byte[] b) throws IOException</code>
	 * <p>
	 * Writes an array of byte to the Output stream field
	 * 
	 * @param  byte[] b
	 * @return nothing
	 */
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
