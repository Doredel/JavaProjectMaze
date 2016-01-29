package presenter;

/**
 * An interface that represent the most generic command there is in command design pattern
 * 
 * @author Dor Edelstein, Lior Mantin
 *
 */
public interface Command {
	
	/**
	 * The function doCommand is using different algorithms 
	 * 
	 * @param param - The content of the parameters that the command will
	 * need to make his mission
	 * @return nothing
	 */
	public void doCommand();
	/**
	 * Setting the parameters clearly to the model.
	 * 
	 * @param param - The content of the parameters that the command will
	 * need.
	 * @return nothing
	 */
	public void setParams(String[] param);
}