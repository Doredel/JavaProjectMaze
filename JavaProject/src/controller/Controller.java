package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public interface Controller {
	public void setModel(Model m);
	public void setView(View m);
	public HashMap<String, Command> CreateCommandMap();
	
}
