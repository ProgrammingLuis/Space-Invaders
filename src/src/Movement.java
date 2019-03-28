import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class where the enemy and player movement is made.
 * @author programmingLuis
 *
 */

public class Movement {

	private static boolean alienMovingRight = true;

	public static boolean playerMovingRight = false;
	public static boolean playerMovingLeft = false;

	private static final Random RAND = new Random();

	private static final int VAR_TO_SHOOT = 6; // edit this to change probability that aliens shoot

	private static final int ALIEN_VEL = ScaleRes.getScaledWidth(ScaleRes.INIT_ENEMY_VEL)+1;
	private static final int BOSS_VEL = ScaleRes.getScaledWidth(ScaleRes.INIT_BOSS_VEL)+1;
	private static final int PLAYER_VEL = ScaleRes.getScaledWidth(ScaleRes.INIT_PLAYER_VEL)+1;

	/**
	 * Movement of the aliens en masse. BossMovement will activate if one alien is left.
	 * @param firstRow
	 * @param secThirdRow will animate the first, second, third, and fourth row of aliens.
	 * @param fourthRow
	 * @param enemyLasers the generated lasers will be stored here
	 */

	public static void enemyMovement(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, List<JLabel> enemyLasers) {

		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!GameLogic.oneEnemyLeft(firstRow, secThirdRow, fourthRow)){   

					for(JLabel l : firstRow) {

						individualMovement(l, firstRow, enemyLasers);

					}

					for(JLabel l : secThirdRow){

						individualMovement(l, secThirdRow, enemyLasers);

					}

					for(JLabel l : fourthRow){

						individualMovement(l, fourthRow, enemyLasers);

					}

				} else bossMovement(GameLogic.lastAlien(firstRow, secThirdRow, fourthRow), enemyLasers);

			} 
		};
		Timer timer = new Timer(350, task);
		timer.setRepeats(true);
		timer.start();

	}

	/**
	 * Adds a key listener to player spaceship to generate movement and laser shots
	 * @param spaceship where the key listener will be attached
	 * @param lasers where the shot lasers will be stored
	 */
	public static void playerMovement(JLabel spaceship, List<JLabel> lasers) {
		spaceship.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()== KeyEvent.VK_SPACE){

					JLabel laser = new JLabel("");
					laser.setIcon(Animate.laser);
					laser.setBounds(spaceship.getX()+(Player.SPACESHIP_WIDTH/2), spaceship.getY()-Attack.LASER_HEIGHT, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);

					if(lasers.size()<1) {

						SoundEffects.playerShot();
						lasers.add(laser);
					}

				}

				if(e.getKeyCode()== KeyEvent.VK_LEFT){

					playerMovingLeft = true;

				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){

					playerMovingRight = true;

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

				if(e.getKeyCode()== KeyEvent.VK_LEFT){

					playerMovingLeft = false;

				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){

					playerMovingRight = false;

				}
			}

		});
	}

	/**
	 * Updates player location. Will be placed in <code>Attack.playerHit()</code> method because it updates constantly.
	 * @param spaceship
	 */
	public static void updatePlayer(JLabel spaceship) {

		if(playerMovingRight) {

			if(!(spaceship.getX()+Player.SPACESHIP_WIDTH+(PLAYER_VEL*2)>=GameWindow.backgroundRightBound))spaceship.setBounds(spaceship.getX()+PLAYER_VEL, Player.PLAYER_YPOS, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);

		}

		if(playerMovingLeft) {

			if(!(spaceship.getX()-PLAYER_VEL*2<=GameWindow.backgroundLeftBound))spaceship.setBounds(spaceship.getX()-PLAYER_VEL, Player.PLAYER_YPOS, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);

		}

	}

	/**
	 * Individual movement of aliens.
	 * @param l alien that will be moved
	 * @param alienRow the row the alien is in
	 * @param enemyLasers where this alien's lasers will be stored
	 */
	private static void individualMovement(JLabel l, List<JLabel> alienRow, List<JLabel> enemyLasers) {

		Animate.animateAlien(l);

		if(alienRow.get(alienRow.size()-1).getX()+Aliens.ALIEN_WIDTH>=GameWindow.backgroundRightBound) alienMovingRight = false;
		if(alienRow.get(0).getX()<=GameWindow.backgroundLeftBound) {

			alienRow.get(0).setBounds(alienRow.get(0).getX()+ALIEN_VEL*2, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			alienMovingRight = true;
		}

		if(alienMovingRight) {
			l.setBounds(l.getX()+ALIEN_VEL, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		} else if(!alienMovingRight) {
			l.setBounds(l.getX()-ALIEN_VEL, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		} 

		if(RAND.nextInt(VAR_TO_SHOOT) == 3) {

			JLabel laser = new JLabel("");
			laser.setIcon(Animate.laser);
			laser.setBounds(l.getX()+(Aliens.ALIEN_WIDTH/2), l.getY()+ALIEN_VEL, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
			if(enemyLasers.size()<5) enemyLasers.add(laser);

		}

	}

	/**
	 * Movement of boss alien.
	 * @param alien alien to be made boss
	 * @param enemyLasers the stored lasers of the boss
	 */
	private static void bossMovement(JLabel alien, List<JLabel> enemyLasers) {

		if(SoundEffects.playBossMusic) {

			SoundEffects.boss();
			SoundEffects.playBossMusic = false;

		}

		alien.setIcon(Animate.boss);

		if(alien.getX()+Aliens.ALIEN_WIDTH+15>=GameWindow.backgroundRightBound) alienMovingRight = false;
		if(alien.getX()-BOSS_VEL<=GameWindow.backgroundLeftBound) {

			alien.setBounds(alien.getX()+BOSS_VEL*2, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			alienMovingRight = true;
		}

		if(alienMovingRight) {
			alien.setBounds(alien.getX()+BOSS_VEL, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		} else if(!alienMovingRight) {
			alien.setBounds(alien.getX()-BOSS_VEL, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		} 

		if(RAND.nextInt(VAR_TO_SHOOT) > 1) {

			JLabel laser = new JLabel("");
			laser.setIcon(Animate.laser);
			laser.setBounds(alien.getX()+(Aliens.ALIEN_WIDTH/2), alien.getY()+ALIEN_VEL, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
			if(enemyLasers.size()<8) enemyLasers.add(laser);

		}



	}

}
