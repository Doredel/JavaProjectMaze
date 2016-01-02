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
	
	public void displayCross(int[][] cross){
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < cross.length; i++) {
			for (int j = 0; j < cross[0].length; j++) {
				str.append(cross[i][j]+" ");
			}
			str.append("\n");
		}
		str.append("\n");
		
		cli.display(str.toString());
	}
}
