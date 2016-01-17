package model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Observable;
import java.util.Observer;

import presenter.ServerProperties;

/**
 * <strong>MyModel</strong>  is a model class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyModel extends Observable implements Model,Observer {

	private MyServer server;
	

	@Override
	public void openServer(int port, int numThreads) {
		server = new MyServer(port, numThreads, new MazeHandler());
		server.open();
	}


	@Override
	public void stopServer() {
		server.stopServer();
	}


	/**
	 * <strong>saveProperties</strong>
	 * <p>
	 * <code>public void saveProperties(Properties properties)</code>
	 * <p>
	 * Saving the properties of the program in a XML file.
	 * @param properties The properties object that contains the properties
	 * @see XMLEncoder 
	 */
	public void saveProperties(ServerProperties properties) {
		try {
			XMLEncoder coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("ServerProperties.xml")));
			coder.writeObject(properties);
			coder.close();
		} catch (FileNotFoundException e) {
			System.out.println("can't Save Properties");
		}
	}

	/**
	 * <strong>loadProperties</strong>
	 * <p>
	 * <code>public void loadProperties(Properties properties)</code>
	 * <p>
	 * Loading the properties of the program from the XML properties file
	 * @return properties The properties object that contains the properties
	 * @see XMLDecoder
	 */
	@Override
	public ServerProperties loadProperties() {
		ServerProperties properties = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("ServerProperties.xml")));
			properties = (ServerProperties)decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			System.out.println("can't Load Properties");
		}
		return properties;
	}


	@Override
	public void setNumThreatsClient(int numThreads) {
		server.getClientHandler().setNumThreats(numThreads);
	}


	@Override
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}
	
	

}
