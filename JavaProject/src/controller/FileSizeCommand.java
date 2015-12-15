package controller;

import model.Model;
import view.View;

public class FileSizeCommand<T> extends CommonCommand<T> {

	public FileSizeCommand(View<T> v, Model<T> m) {
		super(v, m);
	}

	@Override
	public void doCommand(String[] param) {
		String fileName = param[0];
		this.m.fileSize(fileName);
	}

}
