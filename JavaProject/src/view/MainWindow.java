package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import algorithms.mazeGenerators.Maze3d;
import presenter.Properties;

public class MainWindow extends BasicWindow{

	private String name;
	private Maze3d maze;
	private MazeDisplayer md;
	
	public MainWindow(int width, int height, String name) {
		super(width, height, name);
	}
	
	public MainWindow(int width, int height,String title,Display display) {
		super(width, height,title,display);
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

	    // Create the bar menu
	    Menu menuBar = new Menu(shell, SWT.BAR);

	    // Create the File item's dropdown menu
	    Menu fileMenu = new Menu(menuBar);

	    // Create all the items in the bar menu
	    MenuItem fileItem = new MenuItem(menuBar, SWT.CASCADE);
	    fileItem.setText("File");
	    fileItem.setMenu(fileMenu);

	    // Create all the items in the File dropdown menu
	    MenuItem prop = new MenuItem(fileMenu, SWT.NONE);
	    prop.setText("Open properties");
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
					(new MessageBox(shell)).open();
				} catch (IllegalAccessException e) {
					(new MessageBox(shell)).open();
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
	    
	    MenuItem exitItem = new MenuItem(fileMenu, SWT.NONE);
	    exitItem.setText("Exit");
	    exitItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

	    shell.setMenuBar(menuBar);		
		
		Button createMaze= new Button(shell, SWT.BORDER);
		createMaze.setText("Create Maze");
		createMaze.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		createMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MazeGeneratetionWindows mgw = new MazeGeneratetionWindows(500, 300, "maze generation window", display);
				mgw.run();
				setChanged();
				notifyObservers(mgw.getMaze());
				name = mgw.getName();
				setChanged();
				notifyObservers("display "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		//////////////////////////////////////////////////////////////////////////////////////
		md = new Maze2D(shell,SWT.BORDER | SWT.FOCUSED);
		md.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,4));
		/////////////////////////////////////////////////////////////////////////////////////
		
		Group groupSection = new Group(shell, SWT.SHADOW_OUT);
		groupSection.setText("Sections:");
		groupSection.setLayout(new GridLayout(1, false));
		groupSection.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button xSect= new Button(groupSection, SWT.RADIO|SWT.SELECTED);
		xSect.setText("Cross section by X");
		xSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		xSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by X "+maze.getStartPosition().getX()+" for "+name);
				md.setCharacterPosition(maze.getStartPosition().getY(),maze.getStartPosition().getZ());
				md.redraw();
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
				notifyObservers("display cross section by Y "+maze.getStartPosition().getY()+" for "+name);
				md.setCharacterPosition(maze.getStartPosition().getZ(),maze.getStartPosition().getX());
				md.redraw();
				System.out.println(maze.getStartPosition());
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
				notifyObservers("display cross section by Z "+maze.getStartPosition().getZ()+" for "+name);
				md.setCharacterPosition(maze.getStartPosition().getX(),maze.getStartPosition().getY());
				md.redraw();
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
		
		Group groupPosition = new Group(shell, SWT.SHADOW_OUT);
		groupPosition.setText("Your position:");
		groupPosition.setLayout(new GridLayout(1, false));
		groupPosition.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,true ,1 ,1));
		
	    Text PosXLabel = new Text(groupPosition, SWT.READ_ONLY);
	    PosXLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text PosYLabel = new Text(groupPosition, SWT.READ_ONLY);
		PosYLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text PosZLabel = new Text(groupPosition, SWT.READ_ONLY);
		PosZLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		md.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				switch (arg0.keyCode) {
				case SWT.PAGE_UP:
					maze.setStartPosition(maze.getStartPosition().getUp());
					break;

				case SWT.PAGE_DOWN:
					maze.setStartPosition(maze.getStartPosition().getDown());
					break;
					
				case SWT.ARROW_RIGHT:
					maze.setStartPosition(maze.getStartPosition().getRight());
					break;
					
				case SWT.ARROW_LEFT:
					maze.setStartPosition(maze.getStartPosition().getLeft());
					break;
					
				case SWT.ARROW_DOWN:
					maze.setStartPosition(maze.getStartPosition().getForward());
					break;
					
				case SWT.ARROW_UP:
					maze.setStartPosition(maze.getStartPosition().getBackward());
					break;
				}
				
				PosXLabel.setText("X: "+(maze.getStartPosition().getX()+1)+"/"+maze.getMaze3d().length);
				PosYLabel.setText("Y: "+(maze.getStartPosition().getY()+1)+"/"+maze.getMaze3d()[0].length);
				PosZLabel.setText("Z: "+(maze.getStartPosition().getZ()+1)+"/"+maze.getMaze3d()[0][0].length);
				
				setChanged();
				notifyObservers("display cross section by Y "+maze.getStartPosition().getY()+" for "+name);
				md.setCharacterPosition(maze.getStartPosition().getX(),maze.getStartPosition().getZ());
				md.redraw();
			}
		});
		
		shell.addDisposeListener(new DisposeListener() {
			
			@Override
			public void widgetDisposed(DisposeEvent arg0) {
				setChanged();
				notifyObservers("exit");
			}
		});
	}
	
	public void setCross(int[][] maze){
		md.setMazeData(maze);
	}
	
	public void setMaze(Maze3d maze){
		this.maze = maze;
	}
}
