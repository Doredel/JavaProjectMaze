package presenter;

import java.io.Serializable;


public class Properties implements Serializable {
	
	/**
	 * the maximum number of threads in the model
	 */
	private int serverPort;
	
	/**
	 * the type of interface
	 */
	private String interfaceType;
	
	private String serverIP;
	
	/**
	 * Construct a properties object
	 */
	public Properties(){}



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
	 * @return the serverPort
	 */
	public int getServerPort() {
		return serverPort;
	}



	/**
	 * @param serverPort the serverPort to set
	 */
	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}



	/**
	 * @return the serverIP
	 */
	public String getServerIP() {
		return serverIP;
	}



	/**
	 * @param serverIP the serverIP to set
	 */
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	
	
	
}
