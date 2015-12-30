package view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

public class GeneralClassWindow extends BasicWindow {
	
	Class object;
	List<Field> fields ;
	
	public GeneralClassWindow(int width, int height, String name, Class object) {
		super(width, height, name);
		this.object = object;
		fields = new ArrayList<Field>(Arrays.asList(object.getDeclaredFields()));
	}

	@Override
	public void initWidgets() {
		ArrayList<Text> info = new ArrayList<Text>();
		shell.setLayout(new GridLayout(2, false));
		
		Text Titel = new Text(shell, SWT.READ_ONLY|SWT.BOLD);
		Titel.setText(object.getSimpleName());
		Titel.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,2 ,1));
		
		for (int i=0; i<fields.size(); i++) {
			Text lable = new Text(shell, SWT.READ_ONLY);
			lable.setText(fields.get(i).getName());
			lable.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
			
			info.add(new Text(shell, SWT.BORDER));
			info.get(i).setText("");
			info.get(i).setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));

		}
		
		Button SaveChanges = new Button(shell, SWT.BORDER|SWT.PUSH);
		SaveChanges.setText("Save Changes");
		SaveChanges.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
	}

}
