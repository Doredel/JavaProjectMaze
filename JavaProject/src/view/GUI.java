package view;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class GUI extends Observable implements Observer{
	
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

	@Override
	public void update(Observable o, Object arg) {
		notifyObservers(arg);
	}

}
