package view;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

public class GeneralClassWindow<T> extends BasicWindow {
	
	private Class<T> theClass;
	private List<Field> fields ;
	private T result;
	
	
	public GeneralClassWindow(int width, int height, String name, Class<T> theClass) {
		super(width, height, name);
		this.theClass = theClass;
		fields = new ArrayList<Field>(Arrays.asList(theClass.getDeclaredFields()));
	}
	
	public GeneralClassWindow(int width, int height, String name, Display display, Class<T> theClass) {
		super(width, height, name, display);
		this.theClass = theClass;
		fields = new ArrayList<Field>(Arrays.asList(theClass.getDeclaredFields()));
		
	}
	
	@Override
	public void initWidgets() {
		ArrayList<Text> info = new ArrayList<Text>();
		shell.setLayout(new GridLayout(2, false));
		
		Text Title = new Text(shell, SWT.READ_ONLY|SWT.BOLD);
		Title.setText(theClass.getSimpleName());
		Title.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,true ,false ,2 ,1));
		
		for (int i=0; i<fields.size(); i++) {
			Text lable = new Text(shell, SWT.READ_ONLY);
			lable.setText(fields.get(i).getName());
			lable.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
			
			info.add(new Text(shell, SWT.BORDER));
			info.get(i).setText("");
			info.get(i).setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));

		};
		
		
		Button SaveChanges = new Button(shell, SWT.BORDER|SWT.PUSH);
		SaveChanges.setText("Save Changes");
		SaveChanges.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
		
		SaveChanges.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				try {
					result = theClass.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
	}

	public T getObject() throws InstantiationException, IllegalAccessException{
		return result;
	}
	
}
