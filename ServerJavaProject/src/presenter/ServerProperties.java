package presenter;

import java.io.Serializable;

public class ServerProperties implements Serializable {

	/**
	 * the maximum number of threads in the model
	 */
	private int numThreads;
	
	/**
	 * the type of interface
	 */
	private String interfaceType; 
	
	/**
	 * the port number
	 */
	private int port;
	
	/**
	 * Construct a properties object
	 */
	public ServerProperties() {
	}
	
	/**
	 * @return the numThreads
	 */
	public int getNumThreads() {
		return numThreads;
	}

	/**
	 * @param numThreads the numThreads to set
	 */
	public void setNumThreads(int numThreads) {
		this.numThreads = numThreads;
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

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
}
