package controller;

import model.Model;
import view.View;

public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DisplayCrossSectionCommand</strong>
	 * <p>
	 * <code>public DisplayCrossSectionCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of DisplayCrossSectionCommand<T>  that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public DisplayCrossSectionCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[3]- The parameter of the coordinate that will cut by him the maze.
	 * param[4]- The parameter of the index that rules which index in the axis to cut
	 * param[6]- The parameter of the maze name that his cross section will be shown in view.
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		String coordinate = param[3];
		String index = param[4];
		String mazeName = param[6];
		this.m.displayCrossSection(coordinate,index,mazeName);
	}
	
}
