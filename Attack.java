import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

/**
 * Class where the attack functionality is made for both the enemy and the player.
 * @author programmingLuis
 *
 */

public class Attack {

	public static final int LASER_WIDTH = ScaleRes.getScaledWidth(ScaleRes.INIT_LASER);
	public static final int LASER_HEIGHT = ScaleRes.getScaledHeight(ScaleRes.INIT_LASER);

	public static int score = 0;

	/**
	 * The player shot a laser and it will be drawn on the screen.
	 * @param lasers where the spaceship's lasers are stored.
	 * @param firstRow
	 * @param secThirdRow first, second, third, and fourth row of aliens are needed for <code>GameLogic.gameplay()</code> to detect shots.
	 * @param fourthRow
	 * @param layeredPane where the lasers are being displayed
	 * @param scoreLabel is needed for the <code>GameLogic.gameplay()</code> method.
	 * @param background is needed for the <code>GameLogic.gameplay()</code> method.
	 * @param youWon is needed for the <code>GameLogic.gameplay()</code> method.
	 * @param spaceship is needed for the <code>Movement.updatePlayer()</code> method.
	 */

	public static void playerShoot(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane, JLabel scoreLabel, JLabel background, JLabel youWon, List<JLabel> enemyLasers, JLabel spaceship) {

		ActionListener task1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Movement.updatePlayer(spaceship); // I put this here because this loops a lot. Perfect for this method.

				if(!lasers.isEmpty()) {

					try{for(JLabel l : lasers) {

						layeredPane.add(l);
						l.setBounds(l.getX(),l.getY()-LASER_WIDTH,LASER_WIDTH,LASER_HEIGHT);
						if(l.getY()<=GameWindow.backgroundUpBound) {
							lasers.remove(l);
							l.setVisible(false);
						}

						GameLogic.gameplay(lasers, firstRow, secThirdRow, fourthRow, scoreLabel, layeredPane, background, youWon, enemyLasers);

					}} catch(Exception ex) {
						ex.printStackTrace();
					}

				}

			}};
			Timer timer1 = new Timer(10, task1);
			timer1.setRepeats(true);
			timer1.start();

	}

	/**
	 * The enemy shot so it will be displayed on the screen.
	 * @param enemyLasers where the enemy lasers are stored
	 * @param spaceship is needed for <code>GameLogic.gameLost()</code> method.
	 * @param layeredPane where the shot is stored.
	 * @param background is needed for <code>GameLogic.gameLost()</code> method.
	 * @param gameOverLabel is needed for <code>GameLogic.gameLost()</code> method.
	 */
	public static void enemyShoot(List<JLabel> enemyLasers, JLabel spaceship, JLayeredPane layeredPane, JLabel background, JLabel gameOverLabel) {

		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!enemyLasers.isEmpty()) {

					try{for(JLabel l : enemyLasers) {

						layeredPane.add(l);
						l.setBounds(l.getX(),l.getY()+LASER_WIDTH/2,LASER_WIDTH,LASER_HEIGHT);
						if(l.getY()>=GameWindow.backgroundDownBound) {
							enemyLasers.remove(l);
							l.setVisible(false);
							layeredPane.remove(l);
							l.setEnabled(false);

						}

						GameLogic.gameLost(spaceship, enemyLasers, layeredPane, background, gameOverLabel);

					}} catch(Exception ex) {
						ex.printStackTrace();
					}

				}

			}};
			Timer timer = new Timer(20, task);
			timer.setRepeats(true);
			timer.start();

	}


}
