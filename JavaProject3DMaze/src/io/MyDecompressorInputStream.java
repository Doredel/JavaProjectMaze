package io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The <b>MyDecompressorInputStream</b> class represents a type of input stream
 * With a compression
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @since 16/12/2015
 * @see InputStream
 */
public class MyDecompressorInputStream extends InputStream {
	/**
	 * The input content
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
		this.in = new BufferedInputStream(in);
	}
	
	@Override
	public int read() throws IOException {
		return this.in.read();
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		int val,num;
		int index=0;		
		while(index< b.length) {
			in.mark(2);
			val=in.read();
			num = in.read();
			if(val == -1){
				break;
			}else if(num+index >= b.length){
				in.reset();
				break;
			}
			else {
				for (int i = 0; i < num; i++) {
					b[index] = (byte)val;
					index++;
				}
			}	
			
		}
		if (index != 0) {
			return index;
		} else {
			return -1;
		}
		
	}

}
