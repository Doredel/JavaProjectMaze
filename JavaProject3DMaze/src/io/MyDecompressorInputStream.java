package io;

import java.io.IOException;
import java.io.InputStream;

/**
 * The <b>MyDecompressorInputStream</b> class represents a type of input stream
 * With an InputStream content 
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @since 16/12/2015
 * @see InputStream
 */
public class MyDecompressorInputStream extends InputStream {
	/**
	 * The in content
	 */
	private InputStream in;
	/**
	 * <strong>MyDecompressorInputStream</strong>
	 * <p>
	 * <code>public MyDecompressorInputStream(InputStream in)</code>
	 * <p>
	 * Constructor of <b>MyDecompressorInputStream</b> that gets an InputStream variable and initialize the in content
	 * 
	 * @param InputStream in 
	 * @return nothing
	 */
	public MyDecompressorInputStream(InputStream in) {
		this.in = in;
	}
	/**
	 * <strong>read</strong>
	 * <p>
	 * <code>public int read() throws IOException</code>
	 * <p>
	 * Reads info from the in field
	 * 
	 * @param  nothing
	 * @return <b>int</b> - The content of one line in the input stream field
	 */
	@Override
	public int read() throws IOException {
		return this.in.read();
	}
	/**
	 * <strong>read</strong>
	 * <p>
	 * <code>public int read() throws IOException</code>
	 * <p>
	 * Reads the whole info from the in field
	 * 
	 * @param  byte[] b
	 * @return <b>int</b> - The content of whole file of the input stream field
	 */
	@Override
	public int read(byte[] b) throws IOException {
		int val,num;
		int index=0;		
		while(((val=in.read()) != -1)&&(index< b.length)) {
			num = in.read();
			for (int i = 0; i < num; i++) {
				b[index] = (byte)val;
				index++;
			}
		}
		if (index != 0) {
			return index;
		} else {
			return -1;
		}
		
	}

}
