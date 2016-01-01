package view;


import java.util.Observable;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public abstract class BasicWindow extends Observable implements Runnable {

	protected Display display;
	protected Shell shell;
	
	public BasicWindow(int width, int height, String name) {
		display = new Display();  // our display
		shell = new Shell(display); // our window

		shell.setSize(width,height);
		shell.setText(name);

	}
	
	public BasicWindow(int width, int height, String name, Display display) {
		this.display = display;  // our display
		shell = new Shell(display); // our window

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

		  
		  if (display.getShells().length == 0) {
			  display.dispose();
		}

	}
}
