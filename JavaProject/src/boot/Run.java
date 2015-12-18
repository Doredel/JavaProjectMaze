package boot;

import algorithms.mazeGenerators.Position;
import controller.Controller;
import controller.MyController;
import model.Model;
import model.MyModel;
import view.MyView;
import view.View;

public class Run {
	public static void main(String[] args) {
		
		Controller<Position> controller = new MyController<Position>();
		View<Position> view = new MyView<Position>(controller); 
		Model model = new MyModel(controller);
		
		controller.setModel(model);
		controller.setView(view);
		
		view.start();
	}
}
