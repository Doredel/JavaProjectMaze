package presenter;


import view.View;
import model.Model;

/**
 * An abstract class that contains an the data members of the model and the view.
 * 
 * @authors Dor Edelstein, Lior Mantin
 * @see Command
 *
 */
public abstract class CommonCommand<T> implements Command {
	
	/**
	 * The v content
	 */
	protected View<T> v;
	
	/**
	 * The m content 
	 */
	protected Model m;
	
	protected String[] param;
	
	/**
	 * <strong>CommonCommand</strong>
	 * <p>
	 * <code>public CommonCommand(View<T> v,Model m)</code>
	 * <P>
	 * constructor that will be used to create Commands.
	 *  
	 * @param v Reference to the view
	 * @param m Reference to the model
	 */
	public CommonCommand(View<T> v,Model m) {
		this.v=v;
		this.m=m;
	}
	
	@Override
	public abstract void doCommand();
	
	@Override
	public void setParams(String[] param) {
		this.param = param;
	}
	
}
