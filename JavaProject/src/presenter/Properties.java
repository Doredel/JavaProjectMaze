package presenter;

import java.io.Serializable;


public class Properties implements Serializable {
	
	/**
	 * The maximum number of threads in the model.
	 */
	private int serverPort;
	
	/**
	 * The type of interface.
	 */
	private String interfaceType;
	
	private String serverIP;
	
	/**
	 * Construct a properties object.
	 */
	public Properties(){}



	/**
	 * @return The interfaceType.
	 */
	public String getInterfaceType() {
		return interfaceType;
	}

	/**
	 * @param interfaceType The interfaceType to set.
	 */
	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}



	/**
	 * @return The serverPort.
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
