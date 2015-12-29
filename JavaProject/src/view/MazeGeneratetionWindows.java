/*
package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

/**
 * @author mantinli
 *
 *
public class MazeGeneratetionWindows extends BasicWindow {

	public MazeGeneratetionWindows(int width, int height) {
		super(width, height, "Maze generation");
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Text nameLabel = new Text(shell, SWT.READ_ONLY);
		nameLabel.setText("Name:");
		nameLabel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text nameInfo = new Text(shell, SWT.BORDER);
		nameInfo.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,1 ,1));
		
		Text widthLabel = new Text(shell, SWT.READ_ONLY);
		widthLabel.setText("Width:");
		widthLabel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text widthInfo = new Text(shell, SWT.BORDER);
		widthInfo.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,1 ,1));
		
		Text heightLabel = new Text(shell, SWT.READ_ONLY);
		heightLabel.setText("Height:");
		heightLabel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text heightInfo = new Text(shell, SWT.BORDER);
		heightInfo.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,1 ,1));
		
		Text depthLabel = new Text(shell, SWT.READ_ONLY);
		depthLabel.setText("Depth:");
		depthLabel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text depthInfo = new Text(shell, SWT.BORDER);
		depthInfo.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,1 ,1));
		
		/*TODO*
		
		Button generate = new Button(shell, SWT.BORDER);
		generate.setText("generate maze!!");
		generate.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
		
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setCommand(6);
				notifyObservers(new String[]{nameInfo.getText(),widthInfo.getText(),heightInfo.getText(),depthInfo.getText()});
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

}*/
