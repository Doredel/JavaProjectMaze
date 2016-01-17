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
	
	public MyServer(int port,int numThreads,ClientHandler clientHandler){
		this.port=port;
		stop=false;
		this.clientHandler=clientHandler;
		threadPool = Executors.newFixedThreadPool(numThreads);
		clients = new ConcurrentHashMap<Integer, String>();
	}
	
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
								notifyObservers(addClient(someClient));
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
	
	public void stopServer(){
		stop=true;
		threadPool.shutdownNow();
		clientHandler.exit();
	}

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

	public String addClient(Socket client){
		clients.put(client.getPort(), client.getLocalAddress().getHostAddress());
		return client.getLocalAddress().getHostAddress()+":"+client.getPort()+" has connected";
	}
}