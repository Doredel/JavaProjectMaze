package view;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

public class MazeWindow extends BasicWindow{
	
	/**
	 * timer variable of Timer's type
	 */
	Timer timer;
	/**
	 * task variable of TimerTask's type
	 */
	TimerTask task;
	
	/**
	 * <strong>MazeWindow</strong>
	 * <p>
	 * <code>public MazeWindow(int width, int height, String title)</code>
	 * <p>
	 * Constructor of MazeWindow that initializes the BasicWindow by the parameters. 
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param title The window's title
	 */
	public MazeWindow(int width, int height, String title) {
		super(width, height, title);
	}
	
	/**
	 * <strong>initWidgets</strong>
	 * <p>
	 * <code>public void initWidgets()</code>
	 * <p>
	 * Init widgets method, That sets and shows a window of a maze board 
	 * 
	 * @return nothing
	 */
	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2,false));
		
		Button startButton=new Button(shell, SWT.PUSH);
		startButton.setText("Start");
		startButton.setLayoutData(new GridData(SWT.FILL, SWT.None, false, false, 1, 1));
				
		
		//MazeDisplayer maze=new Maze2D(shell, SWT.BORDER);		
		MazeDisplayer maze=new Maze3D(shell, SWT.BORDER);
		maze.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,true,1,2));
		
		Button stopButton=new Button(shell, SWT.PUSH);
		stopButton.setText("Stop");
		stopButton.setLayoutData(new GridData(SWT.None, SWT.None, false, false, 1, 1));
		stopButton.setEnabled(false);
		
		
		startButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				timer=new Timer();
				task=new TimerTask() {
					@Override
					public void run() {
						display.syncExec(new Runnable() {
							@Override
							public void run() {

							}
						});
					}
				};				
				timer.scheduleAtFixedRate(task, 0, 100);				
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		stopButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				task.cancel();
				timer.cancel();
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
	}
	
	public static void main(String[] args) {
		MazeWindow win=new MazeWindow(500, 300, "maze example");
		win.run();
	}

}
