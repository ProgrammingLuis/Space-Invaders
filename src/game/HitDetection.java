package game;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JLabel;

import entities.Aliens;
import entities.Player;
import game_sounds.SoundEffects;
import movement.Animate;

/**
 * Class where the hit detection functionality is made.
 * @author programmingLuis
 *
 */

public class HitDetection {

	private static Rectangle laserHitBox;
	private static Rectangle enemyHurtBox;
	private static Rectangle playerHurtBox;
	
	/**
	 * Detects if enemy has been hit by a laser.
	 * @param lasers where the lasers are stored.
	 * @param firstRow
	 * @param secThirdRow all rows of aliens will be checked to see if they have been hit.
	 * @param fourthRow
	 * @return true if enemy has been hit, otherwise false
	 */
	static boolean enemyHit(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {

		for(JLabel l : lasers) {

			laserHitBox = new Rectangle(l.getX(),l.getY(),Attack.LASER_WIDTH,Attack.LASER_HEIGHT);

			for(JLabel f : firstRow) {

				enemyHurtBox = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);

				if(laserHitBox.intersects(enemyHurtBox)) {

					SoundEffects.invaderKilled();
					f.setIcon(Animate.enemy_Hit);
					l.setVisible(false);
					lasers.remove(l);
					Animate.enemyDisappear(firstRow, f);
					firstRow.remove(f);
					return true;
				}

			}

			for(JLabel f : secThirdRow) {

				enemyHurtBox = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);

				if(laserHitBox.intersects(enemyHurtBox)) {

					SoundEffects.invaderKilled();
					f.setIcon(Animate.enemy_Hit);
					l.setVisible(false);
					lasers.remove(l);
					Animate.enemyDisappear(secThirdRow, f);
					secThirdRow.remove(f);
					return true;
				}

			}

			for(JLabel f : fourthRow) {

				enemyHurtBox = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);

				if(laserHitBox.intersects(enemyHurtBox)) {

					SoundEffects.invaderKilled();
					f.setIcon(Animate.enemy_Hit);
					l.setVisible(false);
					lasers.remove(l);
					Animate.enemyDisappear(fourthRow, f);
					fourthRow.remove(f);
					return true;
				}

			}

		}

		return false;

	}

	/**
	 * Detects if player has been hit.
	 * @param enemyLasers where enemy lasers are stored.
	 * @param spaceship is going to be checked if it has been hit by an enemy laser.
	 * @return true if player is hit, otherwise false.
	 */
	static boolean playerHit(List<JLabel> enemyLasers, JLabel spaceship) {

		playerHurtBox = new Rectangle(spaceship.getX(),spaceship.getY(),Player.SPACESHIP_WIDTH,Player.SPACESHIP_HEIGHT);

		for(JLabel l : enemyLasers) {

			laserHitBox = new Rectangle(l.getX(),l.getY(),Attack.LASER_WIDTH,Attack.LASER_HEIGHT);

			if(laserHitBox.intersects(playerHurtBox) && spaceship.isEnabled()) {
				return true;
			}

		}


		return false;

	}

}
