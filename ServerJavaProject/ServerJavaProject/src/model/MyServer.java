package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Observable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class of my server that responsible to the server side and connection
 * to the clients.
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @see Observable
 */
public class MyServer extends Observable{
	
	private int port;
	private ClientHandler clientHandler;
	private volatile boolean stop;
	private ExecutorService threadPool;
	
	/**
	 * <strong>MyServer</strong>
	 * <p>
	 * <code>public MyServer(int port,int numThreads,ClientHandler clientHandler)</code>
	 * <p>
	 * Constructor of MyServer that initializes the port and the clients map,
	 * and the number of clients that can running the application at the same time.
	 * (AKA number of threads).
	 * 
	 * @param port Number of port that the server talks with.
	 * @param numThreads The number of clients that the server can handle.
	 * @param clientHandler The client handler that connects with the server. 
	 */
	public MyServer(int port,int numThreads,ClientHandler clientHandler){
		this.port=port;
		stop=false;
		this.clientHandler=clientHandler;
		threadPool = Executors.newFixedThreadPool(numThreads);
	}
	
	/**
	 * <strong>startServer</strong>
	 * <p>
	 * <code>public void startServer()</code>
	 * <p>
	 * This method starts the server's execute.
	 * @return nothing.
	 */
	public void startServer(){
		try {
			ServerSocket server = new ServerSocket(port);
			server.setSoTimeout(5000);
			while(!stop)
			{
				try {
					Socket someClient=server.accept();
					threadPool.execute(new Runnable() {
						
						@Override
						public void run() {
							
							try {
								setChanged();
								notifyObservers(someClient.getLocalAddress().getHostAddress()+":"+someClient.getPort()+" has connected");
								// Initializes the IO stream for the handle_client's method.
								InputStream inputFromClient=someClient.getInputStream();
								OutputStream outputToClient=someClient.getOutputStream();
								clientHandler.handleClient(inputFromClient,outputToClient);
								inputFromClient.close();
								outputToClient.close();
								setChanged();
								notifyObservers(someClient.getLocalAddress().getHostAddress()+":"+someClient.getPort()+" has disconnected");
								someClient.close();
								
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					});
					
				} catch (SocketTimeoutException e) {
				}
			}
			server.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	/**
	 * <strong>stopServer</strong>
	 * <p>
	 * <code>public void stopServer()</code>
	 * <p>
	 * This method stops the server's execute.
	 * @return nothing.
	 */
	public void stopServer(){
		stop=true;
		threadPool.shutdownNow();
		clientHandler.exit();
	}

	/**
	 * <strong>open</strong>
	 * <p>
	 * <code>public void open()</code>
	 * <p>
	 * This method opens a thread that runs the server's execute.
	 * @return nothing.
	 */
	public void open(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				startServer();
			}
		}).start();
	}

	/**
	 * @return The clientHandler.
	 */
	public ClientHandler getClientHandler() {
		return clientHandler;
	}
}