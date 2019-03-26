import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
*Class where game logic is created.
*/

public class GameLogic {
	
	/**
	 * Detects whether lasers are hitting enemies and updates player score.
	 * @param lasers the lasers that are shot by the player.
	 * @param firstRow 
	 * @param secThirdRow the first, second, third, and fourth row of aliens will be checked to see if they have made contact with the lasers.
	 * @param fourthRow	
	 * @param scoreLabel score label to be updated.
	 * @param layeredPane where these elements are stored.
	 * @param background the background of the game which may be updated with <code>gameIsWon</code>.
	 * @param youWon the label that will appear forward if <code>gameIsWon</code>
	 */
	public static void gameplay(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLabel scoreLabel, JLayeredPane layeredPane, JLabel background, JLabel youWon) {
		
		if(HitDetection.enemyHit(lasers, firstRow, secThirdRow, fourthRow)){
			
			Attack.score += 100;
			scoreLabel.setText("Score: " + Integer.toString(Attack.score));
			
			gameIsWon(firstRow, secThirdRow, fourthRow, layeredPane, background, youWon);
			
		}
		
	}
	
	/**
	 * Checks if there are any remaining aliens.
	 * @param firstRow
	 * @param secThirdRow the first, second, third, and fourth row of aliens will be checked to see if they are empty.
	 * @param fourthRow 
	 * @param layeredPane the layered pane where elements will be moved.
	 * @param background will be brought forward to hide remaining elements
	 * @param youWon will be moved forward to display winning message
	 */
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
	
	/**
	 * Checks to see if player got hit
	 * @param spaceship the destroyed spaceship will be moved forward.
	 * @param enemyLasers the enemy lasers will be cleared since game is over.
	 * @param layeredPane where the elements are stored.
	 * @param background the background will be brought forward to hide remaining elements after loss.
	 * @param gameOverLabel label that will display losing message.
	 */

	public static void gameLost(JLabel spaceship, List<JLabel> enemyLasers, JLayeredPane layeredPane, JLabel background, JLabel gameOverLabel) {
		
		if(HitDetection.playerHit(enemyLasers, spaceship)){
			
			spaceship.setDisabledIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceshipHit.png")));
			spaceship.setEnabled(false);
			enemyLasers.clear();
			
			layeredPane.setLayer(background, 2);
			layeredPane.setLayer(gameOverLabel,3);
			
			//SoundEffects.playerKilled(); Something is wrong with the HitDetection.playerHit logic. It is triggering randomly after the first death. NEED TO FIX.
			
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
						
						Attack.score = 0;
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
