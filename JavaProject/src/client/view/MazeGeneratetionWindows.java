package client.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Class of the Maze generatetion Windows that creates a window by a
 * simple request.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see BasicWindow
 */
public class MazeGeneratetionWindows extends BasicWindow {

	private String request;
	private String name;
	private boolean changed;

	/**
	 * Constructor of MazeGeneratetionWindows that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window.
	 * @param height The height of the window.
	 * @param title The window's title.
	 */
	public MazeGeneratetionWindows(int width, int height,String title) {
		super(width, height,title);
		changed = false;
	}
	
	/**
	 * Constructor of MazeGeneratetionWindows that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window.
	 * @param height The height of the window.
	 * @param title The window's title.
	 */
	public MazeGeneratetionWindows(int width, int height,String title, Shell parent) {
		super(width, height,title,parent);
		changed = false;
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Label nameLabel = new Label(shell, SWT.READ_ONLY);
		nameLabel.setText("Name:");
		nameLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text nameInfo = new Text(shell, SWT.BORDER);
		nameInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Label widthLabel = new Label(shell, SWT.READ_ONLY);
		widthLabel.setText("Width:");
		widthLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text widthInfo = new Text(shell, SWT.BORDER);
		widthInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Label heightLabel = new Label(shell, SWT.READ_ONLY);
		heightLabel.setText("Height:");
		heightLabel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		Text heightInfo = new Text(shell, SWT.BORDER);
		heightInfo.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		Label depthLabel = new Label(shell, SWT.READ_ONLY);
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
				changed = true;
				shell.dispose();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button cancel = new Button(shell, SWT.BORDER);
		cancel.setText("Cancel");
		cancel.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		cancel.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
	}
	
	/**
	 * Getting the massege that will generate a maze
	 * @return the massege that will generate a maze
	 */
	public String getRequest(){
		return request;
	}
	/**
	 * Getting the name of maze
	 * @return The name
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return whether the request has been created
	 */
	public boolean isChanged() {
		return changed;
	}
}
