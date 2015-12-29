package view;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import algorithms.mazeGenerators.Position;

public abstract class BasicWindow extends MyView<Position> implements Runnable {

	protected Display display;
	protected Shell shell;
	
	public BasicWindow(int width, int height, String name) {
		display = new Display();  // our display
		shell = new Shell(display);             // our window

		shell.setSize(width,height);
		shell.setText(name);

	}
	
	public abstract void initWidgets(); 
	
	@Override
	public void run() {
		initWidgets();
		
		shell.open();
		
		// main event loop
		 while(!shell.isDisposed()){ // while window isn't closed

		    // 1. read events, put then in a queue.
		    // 2. dispatch the assigned listener
		    if(!display.readAndDispatch()){ 	// if the queue is empty
		       display.sleep(); 			// sleep until an event occurs 
		    }

		 } // shell is disposed

		 display.dispose(); // dispose OS components

	}

}
