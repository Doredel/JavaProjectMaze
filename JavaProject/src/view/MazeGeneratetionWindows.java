package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * @author Dor Edelstein, Lior Mantin
 *
 */
public class MazeGeneratetionWindows extends BasicWindow {

	/**
	 * <strong>MazeGeneratetionWindows</strong>
	 * <p>
	 * <code>public MazeGeneratetionWindows(int width, int height,String title)</code>
	 * <p>
	 * Constructor of MazeGeneratetionWindows that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The window's title
	 */
	public MazeGeneratetionWindows(int width, int height,String title) {
		super(width, height,title);
	}
	
	/**
	 * <strong>MazeGeneratetionWindows</strong>
	 * <p>
	 * <code>public MazeGeneratetionWindows(int width, int height,String title,Display display)</code>
	 * <p>
	 * Constructor of MazeGeneratetionWindows that initializes the BasicWindow by the parameters. 
	 * The difference from the first c'tor is in the display mode- CLI or GUI.
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The window's title
	 * @param display The represent of the program- by GUI or CLI 
	 */
	public MazeGeneratetionWindows(int width, int height,String title,Display display) {
		super(width, height,title,display);
	}

	/**
	 * <strong>initWidgets</strong>
	 * <p>
	 * <code>public void initWidgets()</code>
	 * <p>
	 * Init widgets method, that initializes the window and fill it with
	 * buttons and widgets.
	 * This is the game window, and inside him there is the represent of the generation of the maze
	 * by the values that the user puts in- maze name and his sizes.
	 * @return nothing.
	 */
	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Text nameLabel = new Text(shell, SWT.READ_ONLY);
		nameLabel.setText("Name:");
		nameLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text nameInfo = new Text(shell, SWT.BORDER);
		nameInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Text widthLabel = new Text(shell, SWT.READ_ONLY);
		widthLabel.setText("Width:");
		widthLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text widthInfo = new Text(shell, SWT.BORDER);
		widthInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Text heightLabel = new Text(shell, SWT.READ_ONLY);
		heightLabel.setText("Height:");
		heightLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text heightInfo = new Text(shell, SWT.BORDER);
		heightInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Text depthLabel = new Text(shell, SWT.READ_ONLY);
		depthLabel.setText("Depth:");
		depthLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text depthInfo = new Text(shell, SWT.BORDER);
		depthInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		/*TODO*/
		
		Button generate = new Button(shell, SWT.BORDER);
		generate.setText("generate maze!!");
		generate.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("generate 3d maze "+nameInfo.getText()+" "+widthInfo.getText()+","+heightInfo.getText()+","+depthInfo.getText());
				//shell.dispose();
				GameWindow gw = new GameWindow(500, 300, nameInfo.getText(),display);
				gw.run();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}
}
