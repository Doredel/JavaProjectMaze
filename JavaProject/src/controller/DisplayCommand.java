package controller;

import model.Model;
import view.View;

public class DisplayCommand extends CommonCommand {

	public DisplayCommand(View v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String param) {
	}

}
