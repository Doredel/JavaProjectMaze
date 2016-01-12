package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MyServer {
	
	private int port;
	private ClientHandler clientHandler;
	private volatile boolean stop;
	private ExecutorService threadPool;
	
	public MyServer(int port,int numThreads,ClientHandler clientHandler){
		this.port=port;
		stop=false;
		this.clientHandler=clientHandler;
		threadPool = Executors.newFixedThreadPool(numThreads);
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
								InputStream inputFromClient=someClient.getInputStream();
								OutputStream outputToClient=someClient.getOutputStream();
								clientHandler.handleClient(inputFromClient,outputToClient);
								inputFromClient.close();
								outputToClient.close();
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
	}

	public void open(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				startServer();
			}
		}).start();
	}
	
	public static void main(String[] args) {
		
		try {
			
			MyServer server = new MyServer(1202, 2, new MazeHandler());
			server.open();
			Thread.sleep(1000*60);
			System.out.println("bye");
			server.stopServer();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}