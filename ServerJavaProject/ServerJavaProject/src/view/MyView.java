package view;

import java.io.PrintWriter;
import java.util.Observable;

public class MyView extends Observable implements View{

	private CLI cli;
	
	public MyView(){
		cli = new CLI(new PrintWriter(System.out));
	}
	
	@Override
	public void dispaly(String massage) {
		cli.display(massage);
	}

}
