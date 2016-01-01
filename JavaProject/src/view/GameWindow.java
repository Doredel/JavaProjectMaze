package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class GameWindow extends BasicWindow{

	private int x;
	private int y;
	private int z;
	private String name;
	
	public GameWindow(int width, int height, String name) {
		super(width, height, name);
		
	}

	@Override
	public void initWidgets() {
		shell.setLayout(new GridLayout(2, false));
		
		Group groupSection = new Group(shell, SWT.SHADOW_OUT);
		groupSection.setText("Sections:");
		groupSection.setLayout(new GridLayout(1, false));
		groupSection.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button xSect= new Button(groupSection, SWT.RADIO);
		xSect.setText("Cross section by X");
		xSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		xSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by X "+x+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		Button ySect= new Button(groupSection, SWT.RADIO);
		ySect.setText("Cross section by Y");
		ySect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		ySect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by Y "+y+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		Button zSect= new Button(groupSection, SWT.RADIO);
		zSect.setText("Cross section by Z");
		zSect.setLayoutData(new GridData(SWT.FILL,SWT.TOP,false,false,1,1));
		zSect.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setChanged();
				notifyObservers("display cross section by Z "+z+" for "+name);
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		//////////////////////////////////////////////////////////////////////////////////////
		MazeDisplayer md = new Maze2D(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		md.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true,1,2));
		/////////////////////////////////////////////////////////////////////////////////////
		
	    Group groupOption = new Group(shell, SWT.SHADOW_OUT);
	    groupOption.setText("Options:");
	    groupOption.setLayout(new GridLayout(2, true));
	    groupOption.setLayoutData(new GridData(SWT.FILL ,SWT.TOP ,false ,false ,1 ,1));
		
		Button hint = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		hint.setText("HINT");
		hint.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1,1));
		
		Button solve = new Button(groupOption, SWT.READ_ONLY|SWT.BOLD);
		solve.setText("SOLVE");
		solve.setLayoutData(new GridData(SWT.FILL ,SWT.FILL ,false ,false ,1 ,1));
	}

}
