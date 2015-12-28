package boot;

import algorithms.mazeGenerators.Position;
import model.MyModel;
import presenter.Presenter;
import view.BasicWindow;
import view.MazeGeneratetionWindows;
import view.MyView;
import view.PropertiesWindow;


public class Run {
	public static void main(String[] args) {
		
		//MyView<Position> view = new MyView<Position>();
		
		BasicWindow view = new MazeGeneratetionWindows(400, 200);
		MyModel model = new MyModel();
		
		Presenter<Position> presenter = new Presenter<Position>(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		
		//view.start();
		
		view.run();
	}
}


