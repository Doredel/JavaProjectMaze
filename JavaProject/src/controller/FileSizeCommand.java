package controller;

import model.Model;
import view.View;

public class FileSizeCommand<T> extends CommonCommand<T> {
	/**
	 * <strong>FileSizeCommand</strong>
	 * <p>
	 * <code>FileSizeCommand(View<T> v, Model<T> m)</code>
	 * <p>
	 * Constructor of DispalySolutionCommand<T> that initialize the facades of view and model 
	 * 
	 * @param View<T> v - The facade of view to talk with
	 * @param Model<T> m - The facade of model to talk with
	 * @return nothing
	 */
	public FileSizeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * @param String[] param - The content of the parameters that the command will need to make his mission
	 * param[0]- The  file name that his size will be shown in view.
	 * @return nothing
	 */
	@Override
	public void doCommand(String[] param) {
		String fileName = param[0];
		this.m.fileSize(fileName);
	}

}
