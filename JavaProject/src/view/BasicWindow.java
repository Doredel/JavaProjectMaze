package view;


import java.util.Observable;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public abstract class BasicWindow extends Observable implements Runnable {
	/**
	 * The display field
	 */
	protected Display display;
	/**
	 * The shell field
	 */
	protected Shell shell;
	
	/**
	 * <strong>BasicWindow</strong>
	 * <p>
	 * <code>public BasicWindow(int width, int height, String name)</code>
	 * <p>
	 * Constructor of BasicWindow that initializes
	 * the shell and the display fields, the size of the window
	 * and his name.
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param name The window's title
	 */
	public BasicWindow(int width, int height, String name) {
		display = new Display();  // our display
		shell = new Shell(display); // our window

		shell.setSize(width,height);
		shell.setText(name);

	}
	/**
	 * <strong>BasicWindow</strong>
	 * <p>
	 * <code>public BasicWindow(int width, int height, String name, Display display)</code>
	 * <p>
	 * Constructor of BasicWindow that initializes as like as the first c'tor.
	 * The difference from the first c'tor is in the display mode- CLI or GUI.
	 * 
	 * @param width The width of the window
	 * @param height The height of the window
	 * @param name The window's title
	 * @param display The represent of the program- by GUI or CLI 
	 */
	public BasicWindow(int width, int height, String name, Display display) {
		this.display = display;  // our display
		shell = new Shell(display); // our window

		shell.setSize(width,height);
		shell.setText(name);

	}
	
	/**
	 * <strong>initWidgets</strong>
	 * <p>
	 * <code>public abstract void initWidgets()</code>
	 * <p>
	 * Init widgets method, The basic method of running a shell&display.
	 * @return nothing.
	 */
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
