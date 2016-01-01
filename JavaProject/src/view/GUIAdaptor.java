package view;

import java.util.Observer;

public class GUIAdaptor extends GUI{

	public CLI cli;

	/**
	 * @param cli
	 */
	public GUIAdaptor(CLI cli) {
		super();
		this.cli = cli;
	}

	@Override
	public void start() {
		cli.start();
	}
	
	public void addObserver(Observer o){
		cli.addObserver(o);
	}

	@Override
	public void displayError(String string) {
		cli.display(string);
	} 
}
