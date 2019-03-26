import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {

	public static void createPlayer(JLabel spaceship, List<JLabel> lasers) {
		
		ApplicationMain.layeredPane.setLayer(spaceship, 3);
		Movement.playerMovement(spaceship, lasers);
		spaceship.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceShip.png")));
		spaceship.setVisible(true);
		spaceship.setEnabled(true);
		spaceship.setBounds(278, 320, 28, 18);
		ApplicationMain.layeredPane.add(spaceship);
		spaceship.requestFocus();
		
	}
	
}
