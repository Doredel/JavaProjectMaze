package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;

import presenter.Properties;

public class MainWindow extends BasicWindow {

	public MainWindow(int width, int height, String name) {
		super(width, height, name);
	}
	
	public MainWindow(int width, int height,String title,Display display) {
		super(width, height,title,display);
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

		/*Button prop= new Button(shell, SWT.BORDER);
		prop.setText("Open properties");
		prop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,2,1));
		prop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GeneralClassWindow<Properties> propertiesWindow = new GeneralClassWindow<Properties>(500, 300, "properties", display,Properties.class);
				propertiesWindow.run();
				try {
					Properties properties = propertiesWindow.getObject();
					setChanged();
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
		});*/
		
		Button createMaze= new Button(shell, SWT.BORDER);
		createMaze.setText("Create Maze");
		createMaze.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
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

		//////////////////////////////////////////////////////////////////////////////////////
		MazeDisplayer md = new Maze2D(shell,SWT.BORDER | SWT.FOCUSED);
		md.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,3));
		/////////////////////////////////////////////////////////////////////////////////////
		
		Group groupSection = new Group(shell, SWT.SHADOW_OUT);
		groupSection.setText("Sections:");
		groupSection.setLayout(new GridLayout(1, false));
		groupSection.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button xSect= new Button(groupSection, SWT.RADIO);
		xSect.setText("Cross section by X");
		xSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		xSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				//notifyObservers("display cross section by X "+x+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button ySect= new Button(groupSection, SWT.RADIO);
		ySect.setText("Cross section by Y");
		ySect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		ySect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				//notifyObservers("display cross section by Y "+y+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		Button zSect= new Button(groupSection, SWT.RADIO);
		zSect.setText("Cross section by Z");
		zSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		zSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				//notifyObservers("display cross section by Z "+z+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		
	    Group groupOption = new Group(shell, SWT.SHADOW_OUT);
	    groupOption.setText("Options:");
	    groupOption.setLayout(new GridLayout(2, true));
	    groupOption.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button hint = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		hint.setText("HINT");
		hint.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1,1));
		
		Button solve = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		solve.setText("SOLVE");
		solve.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
	}

}
