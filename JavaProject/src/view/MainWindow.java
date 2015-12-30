package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class MainWindow extends BasicWindow {

	public MainWindow(int width, int height, String name) {
		super(width, height, name);
		
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Text Title = new Text(shell, SWT.READ_ONLY|SWT.BOLD);
		Title.setText("Main Window");
		Title.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,2 ,1));
		
		 String[] items = "GUI CLI".split(" ");
		 Combo combo1 = new Combo(shell, SWT.DROP_DOWN);
		 combo1.setItems(items);
		 


		Button prop= new Button(shell, SWT.BORDER);
		prop.setText("Open properties");
		prop.setLayoutData(new GridData(SWT.FILL,SWT.TOP,true,false,2,1));
		prop.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				FileDialog properties=new FileDialog(shell,SWT.OPEN);
				properties.setText("Open properties");
				properties.setFilterPath("C:/Users/mantinli/JavaProjectMaze/JavaProjectMaze/JavaProject");
				String[] filterExt = {"*.xml"};
				properties.setFilterExtensions(filterExt);
				properties.open();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		


	}

}
