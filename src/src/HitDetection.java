import java.awt.Rectangle;
import java.util.List;
import javax.swing.JLabel;


public class HitDetection {

	static boolean enemyHit(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {
		
		for(JLabel l : lasers) {
			
			Rectangle laser = new Rectangle(l.getX(),l.getY(),l.getWidth(),l.getHeight());
			
			for(JLabel f : firstRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					l.setVisible(false);
					lasers.remove(l);
					f.setVisible(false);
					firstRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : secThirdRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					l.setVisible(false);
					lasers.remove(l);
					f.setVisible(false);
					secThirdRow.remove(f);
					return true;
				}
				
			}
			
			for(JLabel f : fourthRow) {
				
				Rectangle enemy = new Rectangle(f.getX(),f.getY(),f.getWidth(),f.getHeight());
				
				if(laser.intersects(enemy)) {
					
					l.setVisible(false);
					lasers.remove(l);
					f.setVisible(false);
					fourthRow.remove(f);
					return true;
				}
				
			}
			
		}
		
		return false;
		
	}
	
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
