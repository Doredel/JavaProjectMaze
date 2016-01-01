package boot;

import org.eclipse.swt.widgets.Display;

import algorithms.mazeGenerators.Position;
import model.MyModel;
import presenter.Presenter;
import view.MyView;

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


