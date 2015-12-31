package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


public class GenerateMaze3dWindow extends BasicWindow{
	
	
	
	public GenerateMaze3dWindow(int width, int height, String name) {
		super(width, height, name);
	}

	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Text Title = new Text(shell, SWT.READ_ONLY|SWT.BOLD);
		Title.setText("Generate 3d maze here");
		Title.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,2 ,1));
		
		Text labelx = new Text(shell, SWT.READ_ONLY);
		labelx.setText("Width");
		labelx.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text infox= new Text(shell, SWT.BORDER);
		infox.setText("");
		infox.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text labely = new Text(shell, SWT.READ_ONLY);
		labely.setText("Height");
		labely.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text infoy= new Text(shell, SWT.BORDER);
		infoy.setText("");
		infoy.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text labelz = new Text(shell, SWT.READ_ONLY);
		labelz.setText("Length");
		labelz.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text infoz= new Text(shell, SWT.BORDER);
		infoz.setText("");
		infoz.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button generate = new Button(shell, SWT.PUSH);
		generate.setText("Generate Now!");
		generate.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false ,false ,1 ,1));
		generate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				GameWindow gw = new GameWindow(500, 300, "Maze");
				gw.run();
				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

	}

}
