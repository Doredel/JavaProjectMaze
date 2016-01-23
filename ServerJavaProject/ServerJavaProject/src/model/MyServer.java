package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyServer extends Observable{
	
	private int port;
	private ClientHandler clientHandler;
	private volatile boolean stop;
	private ExecutorService threadPool;
	private ConcurrentHashMap<Integer, String> clients;
	
	/**
	 * <strong>MyServer</strong>
	 * <p>
	 * <code>public MyServer(int port,int numThreads,ClientHandler clientHandler)</code>
	 * <p>
	 * Constructor of MyServer that initializes the port and the clients map,
	 * and the number of clients that can running the application at the same time.
	 * (AKA number of threads).
	 * 
	 * @param port number of port that the server talks with.
	 * @param numThreads The number of clients that the server can handle.
	 * @param clientHandler The client handler that connects with the server. 
	 */
	public MyServer(int port,int numThreads,ClientHandler clientHandler){
		this.port=port;
		stop=false;
		this.clientHandler=clientHandler;
		threadPool = Executors.newFixedThreadPool(numThreads);
		clients = new ConcurrentHashMap<Integer, String>();
	}
	
	/**
	 * <strong>startServer</strong>
	 * <p>
	 * <code>public void startServer()</code>
	 * <p>
	 * This method starts the server's execute.
	 * @return nothing
	 */
	public void startServer(){
		try {
			// Initialize new socket for the server side
			ServerSocket server = new ServerSocket(port);
			server.setSoTimeout(5000);
			while(!stop)
			{
				try {
					// Takes a client that connected to the server and starts handle him.
					Socket someClient=server.accept();
					// Using the thread pool...
					threadPool.execute(new Runnable() {
						
						@Override
						public void run() {
							
							try {
								setChanged();
								notifyObservers(addClient(someClient));
								// Initializes the IO stream for the handle_client's method.
								InputStream inputFromClient=someClient.getInputStream();
								OutputStream outputToClient=someClient.getOutputStream();
								clientHandler.handleClient(inputFromClient,outputToClient);
								inputFromClient.close();
								outputToClient.close();
								clients.remove(someClient.getPort());
								someClient.close();
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
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
	 * @return nothing
	 */
	public void stopServer(){
		// The volatile boolean field used in the loop of the start method
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
	 * @return nothing
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
	 * @return the clientHandler
	 */
	public ClientHandler getClientHandler() {
		return clientHandler;
	}

	/**
	 * <strong>addClient</strong>
	 * <p>
	 * <code>public String addClient(Socket client)</code>
	 * <p>
	 * Adding a client to the clients base by socket.
	 * 
	 * @param client The socket that from him all information will put to the clients hash map
	 * @return A string of information about the connection(the local address, host address
	 * port and confirmation).
	 */
	public String addClient(Socket client){
		clients.put(client.getPort(), client.getLocalAddress().getHostAddress());
		return client.getLocalAddress().getHostAddress()+":"+client.getPort()+" has connected";
	}
}