package presenter;

/**
 * An interface that represent the most generic command there is in command design pattern
 * 
 * @author Dor Edelstein, Lior Mantin
 *
 */
public interface Command {
	
	/**
	 * <strong>doCommand</strong>
	 * <p>
	 * <code>public void doCommand(String[] param)</code>
	 * <p>
	 * The function doCommand is using different algorithms 
	 * 
	 * @param param - The content of the parameters that the command will
	 * need to make his mission
	 * @return nothing
	 */
	public void doCommand();
	/**
	 * <strong>setParams</strong>
	 * <p>
	 * <code>public void setParams(String[] param)</code>
	 * <p>
	 * Setting the parameters clearly to the model.
	 * 
	 * @param param - The content of the parameters that the command will
	 * need.
	 * @return nothing
	 */
	public void setParams(String[] param);
}