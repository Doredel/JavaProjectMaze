package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import presenter.ServerProperties;

/**
 * <strong>Model</strong>  Is a model interface for the project.
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	/**
	 * <strong>openServer</strong>
	 * <p>
	 * <code>public void openServer(int port , int numThread)</code>
	 * <p>
	 * Opens the server with the port number and the number of clients.
	 * 
	 * @param port - the port of the server.
	 * @param numThread - the number of clients.
	 * @return nothing.
	 */
	public void openServer(int port , int numThread);
	
	/**
	 * <strong>stopServer</strong>
	 * <p>
	 * <code>public void stopServer()</code>
	 * <p>
	 * Close the server without leaving any threads or streams open.
	 * @return nothing.
	 */
	public void stopServer();

	/**
	 * <strong>loadProperties</strong>
	 * <p>
	 * <code>public void loadProperties(Properties properties)</code>
	 * <p>
	 * Loading the properties of the program from the XML properties file.
	 * @return properties The properties object that contains the properties.
	 * @see XMLDecoder
	 */
	public ServerProperties loadProperties();

	
	/**
	 * <strong>saveProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Saving the properties of the program in a XML file.
	 * @param properties The properties object that contains the properties.
	 * @return nothing.
	 * @see XMLEncoder 
	 */
	public void saveProperties(ServerProperties properties);

}
