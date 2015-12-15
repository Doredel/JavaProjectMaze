package controller;

import model.Model;
import view.View;

public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {

	public DisplayCrossSectionCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		String coordinate = param[3];
		String index = param[4];
		String mazeName = param[6];
		this.m.displayCrossSection(coordinate,index,mazeName);
	}
	
}
