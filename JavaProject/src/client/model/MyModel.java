package client.model;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.Observable;

import algorithms.mazeGenerators.Position;
import client.presenter.Properties;


/**
 * <strong>MyModel</strong> is a model class for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public class MyModel extends Observable implements Model {

	private String Ip;
	private int port;
	
	/**
	 * construct MyModel instance
	 * 
	 */
	public MyModel(){
		
	}
	
	@Override
	public void getDir(String path){
		setChanged();
		notifyObservers((String)Client.helpFromServer("dir "+path,Ip,port));
	}

	@Override
	public void generateMaze(String name, int width,int height,int depth) {
		setChanged();
		notifyObservers((String)Client.helpFromServer("generate "+name+" "+width+" "+height+" "+depth,Ip,port));
	}

	@Override
	public void displayMaze(String name) {
		setChanged();
		notifyObservers(Client.helpFromServer("maze "+name,Ip,port));
	}
	
	@Override
	public void displaySolution(String name){
		setChanged();
		notifyObservers(Client.helpFromServer("solution "+name,Ip,port));
	
	}
	
	@Override
	public void saveMaze(String mazeName, String fileName) {
		setChanged();
		notifyObservers((String)Client.helpFromServer("save "+mazeName+" "+fileName,Ip,port));
		
	}

	@Override
	public void loadMaze(String mazeName, String fileName) {
		setChanged();
		notifyObservers((Client.helpFromServer("load "+fileName+" "+mazeName,Ip,port)));
	}

	@Override
	public void solveMaze(String name, String algorithm) {
		setChanged();
		notifyObservers((String)Client.helpFromServer("solve "+name+" "+algorithm,Ip,port));	
	}
	
	@Override
	public void getClue(String name, String algorithm, Position position) {
		
		setChanged();
		notifyObservers(Client.helpFromServer("clue "+name+" "+algorithm+" "+position.toString(),Ip,port));
	}
	
	@Override
	public void displayCrossSection(String axis, int index, String mazeName) {
		setChanged();
		notifyObservers(Client.helpFromServer("cross "+axis+" "+index+" "+mazeName,Ip,port));
	}

	@Override
	public void mazeSize(String name) {
		setChanged();
		notifyObservers(Client.helpFromServer("sizeMaze "+name,Ip,port));
	}
	
	@Override
	public void fileSize(String fileName){
		setChanged();
		notifyObservers(Client.helpFromServer("fileSize "+fileName,Ip,port));
	}

	@Override
	public void exit() {
		setChanged();
		notifyObservers(Client.helpFromServer("exit",Ip,port));
	}

	@Override
	public void saveProperties(Properties properties) {
		try {
			XMLEncoder coder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Properties.xml")));
			coder.writeObject(properties);
			coder.close();
		} catch (FileNotFoundException e) {
			setChanged();
			notifyObservers("can't Save Properties");
		}
	}

	@Override
	public Properties loadProperties() {
		Properties properties = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Properties.xml")));
			properties = (Properties)decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException e) {
			setChanged();
			notifyObservers("can't Load Properties");
		}
		return properties;
	}
	
	@Override
	public void setPort(int port){
		this.port = port;
	}

	@Override
	public void setIP(String ip){
		this.Ip = ip;
	}
}
