import java.awt.Rectangle;
import java.util.List;
import javax.swing.JLabel;

/**
 * Class where the hit detection functionality is made.
 * @author programmingLuis
 *
 */

public class HitDetection {

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
			
			Rectangle laser = new Rectangle(l.getX(),l.getY(),Attack.LASER_WIDTH,Attack.LASER_HEIGHT);
			
			for(JLabel f : firstRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(Animate.ENEMY_HIT);
					l.setVisible(false);
					lasers.remove(l);
					Animate.enemyDisappear(firstRow, f);
					firstRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : secThirdRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(Animate.ENEMY_HIT);
					l.setVisible(false);
					lasers.remove(l);
					Animate.enemyDisappear(secThirdRow, f);
					secThirdRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : fourthRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),Aliens.ALIEN_WIDTH,Aliens.ALIEN_HEIGHT);
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(Animate.ENEMY_HIT);
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
		
		Rectangle player = new Rectangle(spaceship.getX(),spaceship.getY(),Player.SPACESHIP_WIDTH,Player.SPACESHIP_HEIGHT);
		
		for(JLabel l : enemyLasers) {
			
			Rectangle laser = new Rectangle(l.getX(),l.getY(),Attack.LASER_WIDTH,Attack.LASER_HEIGHT);
			
			if(laser.intersects(player) && spaceship.isEnabled()) {
				return true;
			}
				
		}
			
		
		return false;
		
	}
	
}
