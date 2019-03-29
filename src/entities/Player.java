package entities;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import display.ScaleRes;
import movement.Animate;
import movement.Movement;

/**
 * Class where the player model, or spaceship, is created.
 * @author programmingLuis
 *
 */

public class Player {

	public static final int SPACESHIP_WIDTH = ScaleRes.getScaledWidth(ScaleRes.INIT_SPACESHIP);
	public static final int SPACESHIP_HEIGHT = ScaleRes.getScaledHeight(ScaleRes.INIT_SPACESHIP);
	
	private static final int PLAYER_XPOS = ScaleRes.getXPos(ScaleRes.INIT_PLAYER_POS);
	public static final int PLAYER_YPOS = ScaleRes.getYPos(ScaleRes.INIT_PLAYER_POS);

	/**
	 * Creates the player object (the spaceship).
	 * @param spaceship the element that is being generated (the player).
	 * @param lasers a spaceship needs a place to store its lasers
	 * @param layeredPane where the spaceship will be placed
	 */
	public static void createPlayer(JLabel spaceship, List<JLabel> lasers, JLayeredPane layeredPane) {

		layeredPane.setLayer(spaceship, 3);
		spaceship.setDisabledIcon(Animate.player_Hit);
		spaceship.setVisible(true);
		spaceship.setEnabled(true);
		spaceship.setBounds(PLAYER_XPOS, PLAYER_YPOS, SPACESHIP_WIDTH, SPACESHIP_HEIGHT);
		layeredPane.add(spaceship);
		Movement.playerMovement(spaceship, lasers);
		
	}

}
