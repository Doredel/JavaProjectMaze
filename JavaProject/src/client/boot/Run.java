package client.boot;

import algorithms.mazeGenerators.Position;
import client.model.MyModel;
import client.presenter.Presenter;
import client.view.MyView;

public class Run {
	public static void main(String[] args) {
		MyView<Position> view = new MyView<Position>();
		MyModel model = new MyModel();
		
		Presenter<Position> presenter = new Presenter<Position>(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		
		view.start();
	}
}


