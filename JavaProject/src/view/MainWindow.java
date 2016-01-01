package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;

import presenter.Properties;

public class MainWindow extends BasicWindow {

	public MainWindow(int width, int height, String name) {
		super(width, height, name);
		
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));

		Button prop= new Button(shell, SWT.BORDER);
		prop.setText("Open properties");
		prop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,2,1));
		prop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				BasicWindow bw = new GeneralClassWindow(500, 300, "properties", Properties.class);
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		


	}

}
