package controller;

import model.Model;
import view.View;

public class DispalySolutionCommand<T> extends CommonCommand<T> {

	public DispalySolutionCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		
	}

}
