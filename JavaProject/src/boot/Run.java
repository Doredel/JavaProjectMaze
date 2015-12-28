package boot;

import algorithms.mazeGenerators.Position;
import model.MyModel;
import presenter.Presenter;
import view.BasicWindow;
import view.MyView;
import view.PropertiesWindow;


public class Run {
	public static void main(String[] args) {
		
		/*MyView<Position> view = new MyView<Position>(); 
		MyModel model = new MyModel();
		
		Presenter<Position> presenter = new Presenter<Position>(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		
		view.start();	*/
		BasicWindow bw = new PropertiesWindow(400, 200);
		bw.run();
	}
}


