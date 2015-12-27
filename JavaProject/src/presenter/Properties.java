package presenter;

import java.io.Serializable;

public class Properties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1677586283266085771L;
	
	/**
	 * 
	 */
	private int numberOfThread;
	
	/**
	 * 
	 */
	private String algorithms;
	
	
	public Properties(){}

	/**
	 * @return the numberOfThread
	 */
	public int getNumberOfThread() {
		return numberOfThread;
	}

	/**
	 * @param numberOfThread the numberOfThread to set
	 */
	public void setNumberOfThread(int numberOfThread) {
		this.numberOfThread = numberOfThread;
	}

	/**
	 * @return the algorithms
	 */
	public String getAlgorithms() {
		return algorithms;
	}

	/**
	 * @param algorithms the algorithms to set
	 */
	public void setAlgorithms(String algorithms) {
		this.algorithms = algorithms;
	}
	
	
	
}
