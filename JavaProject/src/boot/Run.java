package boot;

import model.MyModel;
import presenter.Presenter;
import presenter.Properties;
import view.BasicWindow;
import view.GameWindow;
import view.GeneralClassWindow;
import view.GenerateMaze3dWidget;
import view.MainWindow;
import view.MyView;

public class Run {
	public static void main(String[] args) {
		
		/*MyView<Position> view = new MyView<Position>();
		MyModel model = new MyModel();
		
		Presenter<Position> presenter = new Presenter<Position>(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		
		view.start();*/
		
		BasicWindow win = new MainWindow(500,300,"Lior the star");
		//BasicWindow win1 = new  GeneralClassWindow(500,300,"Lior",Properties.class);
		win.run();
	}
}


