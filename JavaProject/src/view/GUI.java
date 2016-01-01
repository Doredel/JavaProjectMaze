package view;

import java.util.Observable;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class GUI extends Observable{
	
	BasicWindow[] allwindows;
	
	public GUI() { 
	}
	
	public void start()
	{
		MainWindow mw = new MainWindow(500, 300, "Main window");
		mw.run();
	}
	public void displayError(String string)
	{
		MessageBox messageBox = new MessageBox(new Shell());
		messageBox.setMessage(string);
		messageBox.open();
	}


}
