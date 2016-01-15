package model;

import presenter.ServerProperties;

/**
 * <strong>Model</strong>  is a model interface for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface Model {
	
	public void openServer(int port , int numThread);
	
	public void stopServer();

	public ServerProperties loadProperties();

	public void setNumThreatsClient(int numThreads);
}
