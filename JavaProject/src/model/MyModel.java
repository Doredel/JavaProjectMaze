package model;


import controller.Controller;

public class MyModel<T> implements Model<T> {
	private Controller<T> c;
	
	public MyModel(Controller<T> c){
		this.c=c;
	}
	
	@Override
	public void search(String name){
	}

}
