package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;

import presenter.Properties;

public class MainWindow extends BasicWindow {

	/**
	 * <strong>MainWindow</strong>
	 * <p>
	 * <code>public MainWindow(int width, int height, String name)</code>
	 * <p>
	 * Constructor of MainWindow that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param name The window's title
	 */
	public MainWindow(int width, int height, String name) {
		super(width, height, name);
	}
	
	/**
	 * <strong>MainWindow</strong>
	 * <p>
	 * <code>public MainWindow(int width, int height,String title,Display display)</code>
	 * <p>
	 * Constructor of MainWindow that initializes the BasicWindow by the parameters. 
	 * The difference from the first c'tor is in the display mode- CLI or GUI.
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The window's title
	 * @param display The represent of the program- by GUI or CLI 
	 */
	public MainWindow(int width, int height,String title,Display display) {
		super(width, height,title,display);
	}

	@Override
	/**
	 * <strong>initWidgets</strong>
	 * <p>
	 * <code>public void initWidgets()</code>
	 * <p>
	 * Init widgets method, that initializes the window and fill it with
	 * buttons and widgets.
	 * This is the main window, and inside him there is the represent of the
	 * open properties (that can be updated in accordance to the user)
	 * Furthermore, there is a 'generate maze' button that
	 * gives us the maze generator window.
	 * @return nothing.
	 */
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

		Button prop= new Button(shell, SWT.BORDER);
		prop.setText("Open properties");
		prop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,2,1));
		prop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GeneralClassWindow<Properties> propertiesWondow = new GeneralClassWindow<Properties>(500, 300, "properties", display,Properties.class);
				propertiesWondow.run();
				try {
					Properties properties = propertiesWondow.getObject();
					notifyObservers(properties);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Button createMaze= new Button(shell, SWT.BORDER);
		createMaze.setText("Create Maze");
		createMaze.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,2,1));
		createMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MazeGeneratetionWindows mgw = new MazeGeneratetionWindows(500, 300, "maze generation window", display);
				mgw.run();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		
	}

}
