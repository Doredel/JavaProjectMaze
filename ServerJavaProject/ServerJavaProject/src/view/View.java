package view;

/**
 * <strong>View</strong>  Is a view interface for the project.
 * 
 * @author Dor Edelstein, Lior Mantin
 */
public interface View {
	
	/**
	 * Displays a message to the output stream.
	 * @param massage The message that will shown.
	 * @return nothing.
	 */
	public void dispaly(String massage);
	
	/**
	 * Starts the the CLI execute.
	 * @return nothing.
	 */
	public void start();
}
