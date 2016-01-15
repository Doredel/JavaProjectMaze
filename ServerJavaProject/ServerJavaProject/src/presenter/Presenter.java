package presenter;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class Presenter implements Observer{
	/**
	 * The model field
	 */
	private Model m;
	/**
	 * The view field
	 */
	@SuppressWarnings("unused")
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
	 * @param model The model's Facade
	 * @param view The view's Facade
	 */
	public Presenter(Model model, View view) {
		super();
		this.m = model;
		this.v = view;
		
		properties = m.loadProperties();
		m.openServer(properties.getPort(), properties.getNumThreads());
		m.setNumThreatsClient(properties.getNumThreads());
	}

	@Override
	public void update(Observable obs, Object arg) {
		//pass
	}
}
