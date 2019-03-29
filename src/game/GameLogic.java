package game;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import display.ScaleRes;
import entities.Aliens;
import game_sounds.SoundEffects;
import movement.Movement;

/**
 * Class where the game logic is made.
 * @author programmingLuis
 *
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
	public static void gameplay(List<JLabel> lasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLabel scoreLabel, JLayeredPane layeredPane, JLabel background, JLabel youWon, List<JLabel> enemyLasers) {

		if(HitDetection.enemyHit(lasers, firstRow, secThirdRow, fourthRow)){

			Attack.score += 100;
			scoreLabel.setText("Score: " + String.format("%04d", Attack.score));

			gameIsWon(firstRow, secThirdRow, fourthRow, layeredPane, background, youWon, enemyLasers);

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
	 * @param enemyLasers needs to be cleared when game ends.
	 */
	private static void gameIsWon(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane, JLabel background, JLabel youWon, List<JLabel> enemyLasers) {

		if(firstRow.isEmpty() && secThirdRow.isEmpty() && fourthRow.isEmpty()) {

			layeredPane.setLayer(background, 2);
			layeredPane.setLayer(youWon,3);

			resetElements(enemyLasers, firstRow, secThirdRow, fourthRow);

			newGame(youWon);

		}

	}

	/**
	 * Checks to see if player got hit
	 * @param spaceship the destroyed spaceship will be moved forward.
	 * @param enemyLasers the enemy lasers will be cleared since game is over.
	 * @param layeredPane where the elements are stored.
	 * @param background the background will be brought forward to hide remaining elements after loss.
	 * @param gameOverLabel label that will display losing message.
	 */

	public static void gameLost(JLabel spaceship, List<JLabel> enemyLasers, JLayeredPane layeredPane, JLabel background, JLabel gameOverLabel, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {

		if(HitDetection.playerHit(enemyLasers, spaceship)){

			spaceship.setEnabled(false);
			
			layeredPane.setLayer(background, 2);
			layeredPane.setLayer(gameOverLabel,3);

			SoundEffects.playerKilled();

			resetElements(enemyLasers, firstRow, secThirdRow, fourthRow);
			
			newGame(gameOverLabel);

		}

	}
	
	/**
	 * Adds a key listener to the label in order to start a new game.
	 * @param l the label that the key listener will be added to.
	 */
	private static void newGame(JLabel l) {
		
		l.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()== KeyEvent.VK_SPACE){

					l.setEnabled(false);
					l.setVisible(false);
					
					ApplicationMain.reset();

				}


			}
		});

		l.requestFocus();

		
	}

	/**
	 * Checks if one alien is left.
	 * @param firstRow
	 * @param secThirdRow checks these rows.
	 * @param fourthRow
	 * @return true if alien is left, otherwise false.
	 */
	public static boolean oneEnemyLeft(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {

		if(firstRow.size()+secThirdRow.size()+fourthRow.size()==1) return true;

		return false;
	}

	/**
	 * Finds the last alien.
	 * @param firstRow
	 * @param secThirdRow checks these rows.
	 * @param fourthRow
	 * @return the last alien.
	 */
	public static JLabel lastAlien(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {

		if(firstRow.size()==1) return firstRow.get(0);
		if(secThirdRow.size()==1) return secThirdRow.get(0);
		if(fourthRow.size()==1) return fourthRow.get(0);

		return null;

	}
	
	/**
	 * Resets the elements of the game.
	 * @param enemyLasers 
	 * @param firstRow
	 * @param secThirdRow
	 * @param fourthRow
	 */
	private static void resetElements(List<JLabel> enemyLasers, List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow) {
		
		Aliens.x1 = Aliens.INIT_X; 
		Aliens.y1 = ScaleRes.getYPos(ScaleRes.INIT_ALIEN_POS);

		Aliens.x2 = Aliens.INIT_X;
		Aliens.y2 = Aliens.y1+Aliens.XY_VAR;

		Aliens.x3 = Aliens.INIT_X;
		Aliens.y3 = Aliens.y2+Aliens.XY_VAR;

		Aliens.x4 = Aliens.INIT_X;
		Aliens.y4 = Aliens.y3+Aliens.XY_VAR;

		Attack.score = 0;
		
		enemyLasers.clear();

		Movement.playerMovingLeft = false;
		Movement.playerMovingRight = false;

		firstRow.clear();
		secThirdRow.clear();
		fourthRow.clear();
		
		Attack.stopShootingTimers();
		Movement.stopMovementTimers();
		
		SoundEffects.stopBattle();
		SoundEffects.playBossMusic = true;

		
	}

}
