package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;

public class Ball3DCharacter extends Game3DCharacter {

	public Ball3DCharacter(Shell parent) {
		super(parent);
	}

	@Override
	public void draw(PaintEvent e, int x, int y, int width, int height) {
		e.gc.fillOval(x, y, width, height);
	}

}
