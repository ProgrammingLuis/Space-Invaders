import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameLogic {

	public static void gameplay(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLabel scoreLabel, JLayeredPane layeredPane, JLabel background, JLabel youWon) {
		
		if(HitDetection.enemyHit(lasers, firstRow, secThirdRow, fourthRow)){
			
			Attack.score += 100;
			scoreLabel.setText("Score: " + Integer.toString(Attack.score));
			
			gameIsWon(firstRow, secThirdRow, fourthRow, layeredPane, background, youWon);
			
		}
		
	}
	
	public static void gameIsWon(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane, JLabel background, JLabel youWon) {
		
		if(firstRow.isEmpty() && secThirdRow.isEmpty() && fourthRow.isEmpty()) {

			layeredPane.setLayer(background, 2);
			layeredPane.setLayer(youWon,3);
			
			Attack.score = 0;
			
			youWon.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()== KeyEvent.VK_SPACE){
						
						Aliens.x1 = Aliens.INIT_X; 
						Aliens.y1 = 112;
						
						Aliens.x2 = Aliens.INIT_X;
						Aliens.y2 = Aliens.y1+Aliens.XY_VAR;
						
						Aliens.x3 = Aliens.INIT_X;
						Aliens.y3 = Aliens.y2+Aliens.XY_VAR;
						
						Aliens.x4 = Aliens.INIT_X;
						Aliens.y4 = Aliens.y3+Aliens.XY_VAR;
						
						youWon.setEnabled(false);
						youWon.setVisible(false);
						ApplicationMain.reset();
					
					}
					
					
				}
			});
			
			youWon.requestFocus();
			
		}
		
		return;
		
	}
	
	public static void gameLost(JLabel spaceship, List<JLabel> enemyLasers, JLayeredPane layeredPane, JLabel background, JLabel gameOverLabel) {
		
		if(HitDetection.playerHit(enemyLasers, spaceship)){

			spaceship.setDisabledIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceshipHit.png")));
			spaceship.setEnabled(false);
			enemyLasers.clear();
			
			layeredPane.setLayer(background, 2);
			layeredPane.setLayer(gameOverLabel,3);
			
			Attack.score = 0;
			
			gameOverLabel.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()== KeyEvent.VK_SPACE){
						
						Aliens.x1 = Aliens.INIT_X; 
						Aliens.y1 = 112;
						
						Aliens.x2 = Aliens.INIT_X;
						Aliens.y2 = Aliens.y1+Aliens.XY_VAR;
						
						Aliens.x3 = Aliens.INIT_X;
						Aliens.y3 = Aliens.y2+Aliens.XY_VAR;
						
						Aliens.x4 = Aliens.INIT_X;
						Aliens.y4 = Aliens.y3+Aliens.XY_VAR;
						
						gameOverLabel.setEnabled(false);
						gameOverLabel.setVisible(false);
						ApplicationMain.reset();
					
					}
					
					
				}
			});
			
			gameOverLabel.requestFocus();
		    
			
		}
		
	}
	
}
