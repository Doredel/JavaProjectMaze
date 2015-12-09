package view;

import controller.Controller;

public class MyView implements View {
	private Controller c;
	private CLI cli;
	public MyView(Controller c){
		this.c=c;
	}

	@Override
	public void start() {
		this.cli.start();
	}
		 
}
