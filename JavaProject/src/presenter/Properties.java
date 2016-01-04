package presenter;

import java.io.Serializable;


public class Properties implements Serializable {
	
	/**
	 * the maximum number of threads in the model
	 */
	private int numberOfThread;
	
	/**
	 * the type of interface
	 */
	private String interfaceType;
	
	/**
	 * Construct a properties object
	 */
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
	 * @return the interfaceType
	 */
	public String getInterfaceType() {
		return interfaceType;
	}

	/**
	 * @param interfaceType the interfaceType to set
	 */
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}
	
	
	
}
