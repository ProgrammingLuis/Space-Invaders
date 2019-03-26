import java.awt.Rectangle;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


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
			
			Rectangle laser = new Rectangle(l.getX(),l.getY(),l.getWidth(),l.getHeight());
			
			for(JLabel f : firstRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/enemyHit.png")));
					l.setVisible(false);
					lasers.remove(l);
					Movement.enemyDisappear(firstRow, f);
					firstRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : secThirdRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/enemyHit.png")));
					l.setVisible(false);
					lasers.remove(l);
					Movement.enemyDisappear(secThirdRow, f);
					secThirdRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : fourthRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					SoundEffects.invaderKilled();
					f.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/enemyHit.png")));
					l.setVisible(false);
					lasers.remove(l);
					Movement.enemyDisappear(fourthRow, f);
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
	
	// Triggers randomly after first death. NEED TO FIX!!!
	static boolean playerHit(List<JLabel> enemyLasers, JLabel spaceship) {
		
		Rectangle player = new Rectangle(spaceship.getX(),spaceship.getY(),spaceship.getWidth(),spaceship.getHeight());
		
		for(JLabel l : enemyLasers) {
			
			Rectangle laser = new Rectangle(l.getX(),l.getY(),l.getWidth(),l.getHeight());
			
			if(laser.intersects(player)) {
				
				return true;
			}
				
		}
			
		
		return false;
		
	}
	
}
