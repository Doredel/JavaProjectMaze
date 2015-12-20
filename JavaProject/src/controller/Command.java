package controller;

/**
 * A interface that represent the most generic command there is in command design pattern
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
	 *  need to make his mission
	 * @return nothing
	 */
	public void doCommand(String[] param);
}