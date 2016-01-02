package view;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class GeneralClassWindow extends BasicWindow {
	
	private Class theClass;
	private List<Field> fields ;
	private Object result;
	
	
	public GeneralClassWindow(int width, int height, String name, Class theClass) {
		super(width, height, name);
		this.theClass = theClass;
		fields = new ArrayList<Field>(Arrays.asList(theClass.getDeclaredFields()));
	}
	
	public GeneralClassWindow(int width, int height, String name, Display display, Class theClass) {
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
			Label lable = new Label(shell, SWT.READ_ONLY);
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
					for (int i = 0; i < fields.size(); i++) {
						if (isNumber(info.get(i).getText())) {
							PropertyUtils.setNestedProperty(result, fields.get(i).getName(), Integer.parseInt(info.get(i).getText()));
						} else {
							PropertyUtils.setNestedProperty(result, fields.get(i).getName(), info.get(i).getText());
						}
					}
					
					
				} catch (InstantiationException | IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
				shell.close();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {	
			}
		});
	}

	public Object getObject(){
		return result;
	}
	
	private boolean isNumber(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
}
