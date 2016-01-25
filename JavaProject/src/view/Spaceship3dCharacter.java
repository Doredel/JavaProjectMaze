package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

public class Spaceship3dCharacter extends Game3DCharacter {
	
	Image player;
	/**
	 * <strong>Spaceship3dCharacter</strong>
	 * <p>
	 * <code> public Spaceship3dCharacter(Shell parent)</code>
	 * <p>
	 * Constructor of Spaceship 3d character drawing.
	 * 
	 * @param parent The window in which the character is.
	 */
	public Spaceship3dCharacter(Shell parent) {
		super(parent);
		try {
			// Setting the player image to be a great spaceship(!)
			player = new Image(parent.getDisplay(), new FileInputStream("resources/phoenix.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(PaintEvent e, int x, int y, int width, int height) {
		e.gc.drawImage(player, 0, 0, player.getBounds().width, player.getBounds().height, x, y, width, height);

	}

}
