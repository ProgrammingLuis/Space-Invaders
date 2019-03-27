import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Class where the player model, or spaceship, is created.
 * @author programmingLuis
 *
 */

public class Player {

	public static final int SPACESHIP_WIDTH = 28;
	public static final int SPACESHIP_HEIGHT = 18;
	
	/**
	 * Creates the player object (the spaceship).
	 * @param spaceship the element that is being generated (the player).
	 * @param lasers a spaceship needs a place to store its lasers
	 * @param layeredPane where the spaceship will be placed
	 */
	public static void createPlayer(JLabel spaceship, List<JLabel> lasers, JLayeredPane layeredPane) {
		
		layeredPane.setLayer(spaceship, 3);
		Movement.playerMovement(spaceship, lasers);
		spaceship.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceShip.png")));
		spaceship.setVisible(true);
		spaceship.setEnabled(true);
		spaceship.setBounds(278, 320, SPACESHIP_WIDTH, SPACESHIP_HEIGHT);
		layeredPane.add(spaceship);
		spaceship.requestFocus();
		
	}
	
}
