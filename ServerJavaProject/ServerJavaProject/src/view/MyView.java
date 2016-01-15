package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Observable;

public class MyView extends Observable implements View{

	private CLI cli;
	
	public MyView(){
		cli = new CLI(new BufferedReader(new  InputStreamReader(System.in)), new PrintWriter(System.out));
	}
	
	@Override
	public void dispaly(String massage) {
		cli.display(massage);
	}

	@Override
	public void read() {
		setChanged();
		notifyObservers(cli.read());
	}

}
