package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class PropertiesWindow extends BasicWindow {

	public PropertiesWindow(int width, int height) {
		super(width, height, "Properties");
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Text numThreadLabel = new Text(shell, SWT.READ_ONLY);
		numThreadLabel.setText("Number of threads:");
		numThreadLabel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Text numThreadInfo = new Text(shell, SWT.BORDER);
		numThreadInfo.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,1 ,1));
		
		/*TODO*/
		
		Button SaveChanges = new Button(shell, SWT.BORDER);
		SaveChanges.setText("Save Changes");
		SaveChanges.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,true ,false ,1 ,1));
	}

}
