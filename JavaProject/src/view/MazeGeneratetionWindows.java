package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

/**
 * @author Dor Edelstein, Lior Mantin
 *
 */
public class MazeGeneratetionWindows extends BasicWindow {

	private String request;
	private String name;

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
	 * <code>public MazeGeneratetionWindows(int width, int height,String title)</code>
	 * <p>
	 * Constructor of MazeGeneratetionWindows that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The window's title
	 */
	public MazeGeneratetionWindows(int width, int height,String title,Display display) {
		super(width, height,title,display);
	}

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
		
		Button generate = new Button(shell, SWT.BORDER);
		generate.setText("generate maze!!");
		generate.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				name = nameInfo.getText();
				request = "generate 3d maze "+nameInfo.getText()+" "+widthInfo.getText()+","+heightInfo.getText()+","+depthInfo.getText();
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
	}
	
	public String getMaze(){
		return request;
	}
	
	public String getName(){
		return name;
	}
}
