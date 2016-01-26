package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

/**
 * Class of DUKE 3d character to create DUKE as a character.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see Game3DCharacter
 */
public class Duke3DCharacter extends Game3DCharacter {

	private Image image;
	
	/**
	 * <strong>Duke3DCharacter</strong>
	 * <p>
	 * <code>public Duke3DCharacter(Shell parent)</code>
	 * <p>
	 * Constructor of Duke 3d character drawing.
	 * 
	 * @param parent The window in which the character is.
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
