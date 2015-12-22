package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter<T> implements Observer {

	private Model m;
	private View<T> v;
	
	public Presenter(Model m, View<T> v) {
		super();
		this.m = m;
		this.v = v;
	}
	
	@Override
	public void update(Observable obs, Object arg) {
	    	    
	    if (obs == m) {
			
			v.display(arg.toString());
			
		}else if (obs == v) {
			
			
		}
	}

	

}
