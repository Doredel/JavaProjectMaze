package view;

import java.util.Observer;
/**
 * The GUIAdaptor from CLI
 * @author Dor Edelstein , Lior Mantin
 *
 */
public class GUIAdaptor extends GUI{

	public CLI cli;

	/**
	 * <strong>GUIAdaptor</strong>
	 * <p>
	 * <code>public GUIAdaptor(CLI cli)</code>
	 * <p>
	 * Constructor of GUIAdaptor that initialize the cli variable.
	 * 
	 * @param cli The initializer of the cli field.
	 */
	
	public GUIAdaptor(CLI cli) {
		super();
		this.cli = cli;
	}

	/**
	 * <strong>start</strong>
	 * <p>
	 * <code>public void start()</code>
	 * <p>
	 * Start method that runs the start of cli from the GUI adaptor.
	 * @return nothing
	 */
	@Override
	public void start() {
		cli.start();
	}
	
	/**
	 * <strong>addObserver</strong>
	 * <p>
	 * <code>public void addObserver(Observer o)</code>
	 * <p>
	 * Adding observer method that adds a certain observer to the cli 
	 * from the GUI adaptor.
	 * @param o The observer variable that will be added to the observers of cli.
	 * @return nothing
	 */
	public void addObserver(Observer o){
		cli.addObserver(o);
	}

	/**
	 * <strong>displayError</strong>
	 * <p>
	 * <code>public void displayError(String string)</code>
	 * <p>
	 * Display error method that calling to the cli's display and shows the error.
	 * @param string The notice/type of the error that may be found in program
	 * @return nothing
	 */
	@Override
	public void displayError(String string) {
		cli.display(string);
	} 
}
