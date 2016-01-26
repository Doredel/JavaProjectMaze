package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

/**
 * Class of the presenter that connects between the model and the view
 * and responsible to notify and update each facade.(Server side...)
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see Observer
 */
public class Presenter implements Observer{
	/**
	 * The model field
	 */
	private Model m;
	/**
	 * The view field
	 */
	private View v;
	/**
	 * The properties of the program
	 */
	private ServerProperties properties;

	/**
	 * <strong>Presenter</strong>
	 * <p>
	 * <code>public Presenter(Model model, View<T> view)</code>
	 * <p>
	 * Constructor of Presenter<T> that initializes the 
	 * model and the view facades, creates the command hash map
	 * and loads the properties from the XML file.
	 * 
	 * @param model The model's Facade.
	 * @param view The view's Facade.
	 */
	public Presenter(Model model, View view) {
		super();
		this.m = model;
		this.v = view;
		
		properties = m.loadProperties();

	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs == v) {
			if(arg == null){
				
				m.openServer(properties.getPort(), properties.getNumThreads());
				
			}else if (((String)arg).equals("exit")) {
				m.stopServer();
			}
		} else {
			v.dispaly((String)arg);
		}
	}
}
