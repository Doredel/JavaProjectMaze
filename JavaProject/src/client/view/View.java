package client.view;

/**
 * <strong>View</strong>  Is a view interface for the project.
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface View<T> {
	
	/**
	 * The main function starts the running of the program.
	 */
	public void start();
	
	/**
	 * The function which prints into the OutputStream.
	 * 
	 * @param string The string to be printed.
	 */
	public void display(String string);
	
	/**
	 * Setting the way of interface.
	 * @param inter The type of interface of the view(CLI or GUI).
	 */
	public void setView(String inter);
	
	/**
	 * passing object to further analysis
	 * @param arg The argument that will be passed to presenter.
	 */
	public void pass(Object arg);
}
