package controller;

import model.Model;
import view.View;

public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {

	public DisplayCrossSectionCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		
	}
	
}
