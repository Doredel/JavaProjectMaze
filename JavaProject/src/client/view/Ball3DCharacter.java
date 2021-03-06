package client.view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Shell;
/**
 * Class of the ball 3d character to create a ball as a character.
 * 
 * @authors Dor Edelstein, Lior Mantin
 *
 * @see Game3DCharacter
 */
public class Ball3DCharacter extends Game3DCharacter {
	/**
	 * Constructor of ball 3d character drawing.
	 * 
	 * @param parent The window in which the character is.
	 */
	 public Ball3DCharacter(Shell parent) {
		super(parent);
	 }

	 @Override
	 public void draw(PaintEvent e, int x, int y, int width, int height) {
		e.gc.fillOval(x, y, width, height);
	 }

}
