import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameLogic {

	public static void gameplay(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {
		
		if(HitDetection.enemyHit(lasers, firstRow, secThirdRow, fourthRow)){
			
			Attack.score += 100;
			ApplicationMain.scoreLabel.setText("Score: " + Integer.toString(Attack.score));
			
			gameIsWon(firstRow, secThirdRow, fourthRow);
			
		}
		
	}
	
	public static void gameIsWon(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {
		
		if(firstRow.isEmpty() && secThirdRow.isEmpty() && fourthRow.isEmpty()) {

			ApplicationMain.layeredPane.setLayer(ApplicationMain.background, 2);
			ApplicationMain.layeredPane.setLayer(ApplicationMain.youWon,3);
			
			Attack.score = 0;
			Movement.leftOrRight = !Movement.leftOrRight;
			Movement.picNum = 0;
			firstRow.clear();
			secThirdRow.clear();
			fourthRow.clear();
			
			ApplicationMain.youWon.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()== KeyEvent.VK_SPACE){
						
						ApplicationMain.youWon.setEnabled(false);
						ApplicationMain.youWon.setVisible(false);
						ApplicationMain.reset();
					
					}
					
					
				}
			});
			
			ApplicationMain.youWon.requestFocus();
			
		}
		
		return;
		
	}
	
	public static void gameLost(JLabel spaceship, List<JLabel> enemyLasers) {
		
		if(HitDetection.playerHit(enemyLasers, spaceship)){

			spaceship.setDisabledIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceshipHit.png")));
			spaceship.setEnabled(false);
			enemyLasers.clear();
			
			ApplicationMain.layeredPane.setLayer(ApplicationMain.background, 2);
			ApplicationMain.layeredPane.setLayer(ApplicationMain.gameOverLabel,3);
			
			Attack.score = 0;
			Movement.leftOrRight = !Movement.leftOrRight;
			Movement.picNum = 0;
			
			ApplicationMain.gameOverLabel.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode()== KeyEvent.VK_SPACE){
						
						ApplicationMain.gameOverLabel.setEnabled(false);
						ApplicationMain.gameOverLabel.setVisible(false);
						ApplicationMain.reset();
					
					}
					
					
				}
			});
			
			ApplicationMain.gameOverLabel.requestFocus();
		    
			
		}
		
	}
	
}
