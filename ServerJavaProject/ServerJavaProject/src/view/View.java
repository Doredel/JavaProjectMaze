package view;

public interface View {
	
	/**
	 * <strong>dispaly</strong>
	 * <p>
	 * <code>public void dispaly(String massage)</code>
	 * <p>
	 * Displays a message to the input stream.
	 * @param massage The message that will shown.
	 * @return nothing.
	 */
	public void dispaly(String massage);
	
	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * Starts the the CLI execute.
	 * @return nothing.
	 */
	public void start();
}
