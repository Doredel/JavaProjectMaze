package presenter;

import java.io.Serializable;
// missed the type of view(GUI or CLI)
public class Properties implements Serializable {
	
	/**
	 * 
	 */
	private int numberOfThread;
	
	/**
	 * 
	 */
	private String algorithms;
	
	private String interfaceType;
	
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
