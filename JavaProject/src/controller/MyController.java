package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {
	 private Model m;
	 private View v;
	 
	 public void setModel(Model m){this.m=m;}
	 public void setView(View v){ this.v=v;}
	 public HashMap<String,Command> CreateCommandMap()
	 {
		 HashMap<String,Command> hm = new HashMap<String,Command>();
		 
		 return hm;
	 }
}
