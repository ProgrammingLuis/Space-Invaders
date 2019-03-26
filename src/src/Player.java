import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Player {

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
		spaceship.setBounds(278, 320, 28, 18);
		layeredPane.add(spaceship);
		spaceship.requestFocus();
		
	}
	
}
