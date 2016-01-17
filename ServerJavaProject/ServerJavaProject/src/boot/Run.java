package boot;

import model.MyModel;
import presenter.Presenter;
import view.MyView;

public class Run {
	
	public static void main(String[] args) {
		
		MyView view = new MyView();
		MyModel model = new MyModel();
		
		Presenter presenter = new Presenter(model, view);
		model.addObserver(presenter);
		view.addObserver(presenter);
		view.start();
	}
	
}
