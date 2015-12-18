package controller;

import model.Model;
import view.View;

public class DisplayCrossSectionCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>DisplayCrossSectionCommand</strong>
	 * <p>
	 * <code>public DisplayCrossSectionCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DisplayCrossSectionCommand<T>  that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public DisplayCrossSectionCommand(View<T> v, Model m) {
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
