package view;

import java.util.HashMap;

import presenter.Command;

/**
 * <strong>View</strong>  is a view interface for the project
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface View<T> {
	
	/**
	 * <strong>start</start>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * The main function starts the running of the program
	 */
	public void start();
	
	/**
	 * <strong>display</start>
	 * <p>
	 * <code>public void display(String string)</code>
	 * <p>
	 * The function which prints into the OutputStream
	 * 
	 * @param string - the string to be printed
	 */
	public void display(String string);

	public void setCommandMap(HashMap<String, Command> hm);

	public void setInterface(String Interface);
}
