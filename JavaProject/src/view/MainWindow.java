package view;

import java.util.ArrayList;
import java.util.Arrays;

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

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;
import presenter.Properties;

public class MainWindow extends BasicWindow{

	private String name;
	private Maze3d maze;
	private Position character;
	private Maze2D md;
	private Group groupSection;
	
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
				GeneralClassWindow propertiesWindow = new GeneralClassWindow(500, 300, "properties", display,Properties.class);
				propertiesWindow.run();
				Properties properties = (Properties) propertiesWindow.getObject();
				setChanged();
				notifyObservers(properties);
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
				character = maze.getStartPosition();
				md.setCharacter(character);
				md.setGoal(maze.getGoalPosition());
				
				setChanged();
				notifyObservers("display cross section by X "+character.getX()+" for "+name);
				md.setCross(0);
				md.redraw();
				
				md.setSolution(null);
				groupSection.setFocus();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		//////////////////////////////////////////////////////////////////////////////////////
		md = new Maze2D(shell,SWT.BORDER | SWT.FOCUSED);
		md.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,4));
		/////////////////////////////////////////////////////////////////////////////////////
		
		groupSection = new Group(shell, SWT.SHADOW_OUT);
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
				notifyObservers("display cross section by X "+character.getX()+" for "+name);
				md.setCross(0);
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
				notifyObservers("display cross section by Y "+character.getY()+" for "+name);
				md.setCross(1);
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
				notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
				md.setCross(2);
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
		hint.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("clue "+name+" BFS "+character.toString());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		Button solve = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		solve.setText("SOLVE");
		solve.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		solve.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("solve "+name+" BFS");
				setChanged();
				notifyObservers("display solution "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		

		
		md.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent arg0) {}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				ArrayList<String> pos = new ArrayList<String>(Arrays.asList(maze.getPossibleMoves(character)));
				switch (arg0.keyCode) {
				case SWT.PAGE_UP:
					if (pos.contains(character.getUp().toString())) {
						character = character.getUp();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;

				case SWT.PAGE_DOWN:
					if (pos.contains(character.getDown().toString())) {
						character = character.getDown();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;
					
				case SWT.ARROW_RIGHT:
					if (pos.contains(character.getRight().toString())) {
						character = character.getRight();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;
					
				case SWT.ARROW_LEFT:
					if (pos.contains(character.getLeft().toString())) {
						character = character.getLeft();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;
					
				case SWT.ARROW_DOWN:
					if (pos.contains(character.getForward().toString())) {
						character = character.getForward();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;
					
				case SWT.ARROW_UP:
					if (pos.contains(character.getBackward().toString())) {
						character = character.getBackward();
					}else{
						MessageBox ms = new MessageBox(shell);
						ms.setMessage("Cant move there");
						ms.open();
					}
					break;
				}
				md.setCharacter(character);
				
				switch (md.getCross()) {
				case 0:
					setChanged();
					notifyObservers("display cross section by X "+character.getX()+" for "+name);
					break;
				case 1:
					setChanged();
					notifyObservers("display cross section by Y "+character.getY()+" for "+name);
					break;
				case 2:
					setChanged();
					notifyObservers("display cross section by Z "+character.getZ()+" for "+name);;
					break;
				}
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
		md.redraw();
	}
	
	public void setMaze(Maze3d maze){
		this.maze = maze;
	}

	public void setSolutin(Solution<?> solution) {
		md.setSolution((Solution<Position>) solution);
		md.redraw();
	}

	public void setClue(State<?> arg) {
		md.setClue((State<Position>)arg);
		md.redraw();
	}
}
