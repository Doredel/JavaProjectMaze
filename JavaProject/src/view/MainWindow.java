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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import algorithms.search.State;
import presenter.Properties;
import view.Maze3dDisplayer.Axis;

public class MainWindow extends BasicWindow{

	final String[] searchAlgorithms = {"BFS","AStarMazeAirDistance","AStarMazeManhattanDistance"};
	
	private String name;
	private Maze3d maze;
	private Game3DCharacter character;
	
	private Menu menuBar;
	private Menu fileMenu;
	private MenuItem fileItem;
	private MenuItem prop;
	private MenuItem restartItem;
	private MenuItem exitItem;
	private Button createMaze;
	private Maze3dDisplayer md;
	private Group groupSection;
	private Button xSect;
	private Button ySect;
	private Button zSect;
	private Group groupOption;
	private Combo algorithmCombo;
	private Button hint;
	private Button solve;
	
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
	public MainWindow(int width, int height,String title, Shell parent) {
		super(width, height,title,parent);
	}

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
	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

	    // Create the bar menu
		menuBar = new Menu(shell, SWT.BAR);

	    // Create the File item's dropdown menu
	    fileMenu = new Menu(menuBar);

	    // Create all the items in the bar menu
	    fileItem = new MenuItem(menuBar, SWT.CASCADE);
	    fileItem.setText("File");
	    fileItem.setMenu(fileMenu);

	    // Create all the items in the File dropdown menu
	    prop = new MenuItem(fileMenu, SWT.NONE);
	    prop.setText("Open properties");
		prop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GeneralClassWindow propertiesWindow = new GeneralClassWindow(500, 300, "properties", shell,Properties.class);
				propertiesWindow.run();
				if (propertiesWindow.isCreated()) {
					Properties properties = (Properties) propertiesWindow.getObject();
					setChanged();
					notifyObservers(properties);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
	    
		restartItem = new MenuItem(fileMenu, SWT.NONE);
		restartItem.setText("Restart");
		restartItem.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				restart();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		exitItem = new MenuItem(fileMenu, SWT.NONE);
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
		
	    createMaze= new Button(shell, SWT.BORDER);
		createMaze.setText("Create Maze");
		createMaze.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		createMaze.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				MazeGeneratetionWindows mgw = new MazeGeneratetionWindows(500, 300, "maze generation window", shell);
				mgw.run();
				if (mgw.isChanged()) {
					setChanged();
					notifyObservers(mgw.getRequest());
					name = mgw.getName();
					
					setChanged();
					notifyObservers("display "+name);
					
					
					restart();
				}
				
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
		
		xSect= new Button(groupSection, SWT.RADIO|SWT.SELECTED);
		xSect.setText("Cross section by X");
		xSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		xSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by X "+character.getX()+" for "+name);
				md.setCross(Axis.X);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		ySect= new Button(groupSection, SWT.RADIO);
		ySect.setText("Cross section by Y");
		ySect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		ySect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by Y "+character.getY()+" for "+name);
				md.setCross(Axis.Y);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		zSect= new Button(groupSection, SWT.RADIO);
		zSect.setText("Cross section by Z");
		zSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		zSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
				md.setCross(Axis.Z);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		
		groupOption = new Group(shell, SWT.SHADOW_OUT);
	    groupOption.setText("Options:");
	    groupOption.setLayout(new GridLayout(2, true));
	    groupOption.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
	    algorithmCombo = new Combo(groupOption, SWT.DROP_DOWN);
	    algorithmCombo.setItems(searchAlgorithms);
	    algorithmCombo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,2,1));
	    algorithmCombo.select(0);
	    
	    hint = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		hint.setText("HINT");
		hint.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1,1));
		hint.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("clue "+name+" "+searchAlgorithms[algorithmCombo.getSelectionIndex()]+" "+character.getPosition().toString());
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		solve= new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		solve.setText("SOLVE");
		solve.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		solve.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("solve "+name+" "+searchAlgorithms[algorithmCombo.getSelectionIndex()]);
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
				if(md.isMovement()){
					ArrayList<String> pos = new ArrayList<String>(Arrays.asList(maze.getPossibleMoves(character.getPosition())));
					switch (md.getCross()) {
					case X:
						switch (arg0.keyCode) {
						case SWT.PAGE_UP:
							if (pos.contains(character.getPosition().getRight().toString())) {
								character.moveRight();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
		
						case SWT.PAGE_DOWN:
							if (pos.contains(character.getPosition().getLeft().toString())) {
								character.moveLeft();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_RIGHT:
							if (pos.contains(character.getPosition().getForward().toString())) {
								character.moveForward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_LEFT:
							if (pos.contains(character.getPosition().getBackward().toString())) {
								character.moveBackward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
						case SWT.ARROW_DOWN:
							if (pos.contains(character.getPosition().getUp().toString())) {
								character.moveUp();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_UP:
							if (pos.contains(character.getPosition().getDown().toString())) {
								character.moveDown();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
						}
						break;
					case Y:
						switch (arg0.keyCode) {
						case SWT.PAGE_UP:
							if (pos.contains(character.getPosition().getUp().toString())) {
								character.moveUp();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
		
						case SWT.PAGE_DOWN:
							if (pos.contains(character.getPosition().getDown().toString())) {
								character.moveDown();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_RIGHT:
							if (pos.contains(character.getPosition().getRight().toString())) {
								character.moveRight();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_LEFT:
							if (pos.contains(character.getPosition().getLeft().toString())) {
								character.moveLeft();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_DOWN:
							if (pos.contains(character.getPosition().getForward().toString())) {
								character.moveForward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
						case SWT.ARROW_UP:
							if (pos.contains(character.getPosition().getBackward().toString())) {
								character.moveBackward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
						}
						break;
						
						
					case Z:
						switch (arg0.keyCode) {
						case SWT.PAGE_UP:
							if (pos.contains(character.getPosition().getForward().toString())) {
								character.moveForward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
		
						case SWT.PAGE_DOWN:
							if (pos.contains(character.getPosition().getBackward().toString())) {
								character.moveBackward();
								if (md.getCross()  == Axis.Z) {
									setChanged();
									notifyObservers("display cross section by Z "+character.getZ()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
							
						case SWT.ARROW_RIGHT:
							if (pos.contains(character.getPosition().getUp().toString())) {
								character.moveUp();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
							
						case SWT.ARROW_LEFT:
							if (pos.contains(character.getPosition().getDown().toString())) {
								character.moveDown();
								if (md.getCross()  == Axis.Y) {
									setChanged();
									notifyObservers("display cross section by Y "+character.getY()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
							
						case SWT.ARROW_DOWN:
							if (pos.contains(character.getPosition().getRight().toString())) {
								character.moveRight();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
							
							
						case SWT.ARROW_UP:
							if (pos.contains(character.getPosition().getLeft().toString())) {
								character.moveLeft();
								if (md.getCross()  == Axis.X) {
									setChanged();
									notifyObservers("display cross section by X "+character.getX()+" for "+name);
								}
							}else{
								MessageBox ms = new MessageBox(shell);
								ms.setMessage("Cant move there");
								ms.open();
							}
							break;
						}
						break;
					
					}
					
					md.setCharacter(character);
					md.redraw();
				}
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

	@SuppressWarnings("unchecked")
	public void setSolutin(Solution<?> solution) {
		md.setSolution((Solution<Position>) solution);
		md.redraw();
	}

	@SuppressWarnings("unchecked")
	public void setClue(State<?> arg) {
		md.setClue((State<Position>)arg);
		md.redraw();
	}
	
	/**
	 * re start the widget to the initial conditions
	 */
	public void restart(){
		
		if (maze==null) {
			MessageBox ms = new MessageBox(shell);
			ms.setMessage("There is no maze");
			ms.open();
		}
		else {	
			character = new Spaceship3dCharacter(shell);
			character.setPosition(maze.getStartPosition());
			md.setCharacter(character);
			md.setGoal(maze.getGoalPosition());
			
			setChanged();
			notifyObservers("display cross section by Y "+character.getY()+" for "+name);
			md.setCross(Axis.Y);
			md.redraw();
			
			md.setSolution(null);
			md.setClue(null);
			md.setMovement(true);
			groupSection.forceFocus();
			ySect.forceFocus();
		}
	}
}
