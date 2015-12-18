package controller;

import model.Model;
import view.View;

public class FileSizeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>FileSizeCommand</strong>
	 * <p>
	 * <code>FileSizeCommand(View<T> v, Model m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model m - The facade of model to talk with
	 * @return nothing
	 */
	public FileSizeCommand(View<T> v, Model m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		String fileName = param[0];
		this.m.fileSize(fileName);
	}

}
