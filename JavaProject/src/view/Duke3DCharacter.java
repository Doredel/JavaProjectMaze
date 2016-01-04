package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class Duke3DCharacter extends Game3DCharacter {

	private Image image;
	
	/**
	 *  with the image of the one and only duke
	 * @param parent - the window in which the character is
	 */
	public Duke3DCharacter(Shell parent) {
		super(parent);
		try {
			image = new Image(this.parent.getDisplay(), new FileInputStream("resources/duke_running.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(PaintEvent e, int x, int y, int width, int height) {
		e.gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, x, y, width, height);
	}

}
