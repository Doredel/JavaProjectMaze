package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


public class GenerateMaze3dWidget extends BasicWindow{
	
	
	
	public GenerateMaze3dWidget(int width, int height, String name) {
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
	}

}
