import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
* Class where the informative elements of the game are made.
*/

public class GameInfo {

	/**
	 * Creates the informative elements of the game.
	 * @param infoPanel The panel where these info elements will go.
	 * @param infoLabel My credits. :)
	 * @param scoreLabel The player's score will be displayed here.
	 * @param gameOverLabel Generates the label that appears when the player loses.
	 * @param youWon Generates the label that appears when the player wins.
	 * @param layeredPane the layered pane where these elements will be stored until needed.
	 */
	public static void createInfoElements(JPanel infoPanel, JLabel infoLabel, JLabel scoreLabel, JLabel gameOverLabel, JLabel youWon, JLayeredPane layeredPane) {
		
		infoPanel.setBorder(new LineBorder(new Color(34, 139, 34)));
		infoPanel.setBackground(Color.BLACK);
		layeredPane.setLayer(infoPanel, 4);
		infoPanel.setBounds(100, 339, 415, 34);
		layeredPane.add(infoPanel);
		infoPanel.setLayout(null);
		
		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		infoLabel.setForeground(new Color(0, 255, 0));
		infoLabel.setBounds(10, 0, 127, 34);
		infoPanel.add(infoLabel);

		scoreLabel.setBounds(297, 8, 118, 19);
		infoPanel.add(scoreLabel);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scoreLabel.setForeground(new Color(0, 255, 0));
		
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setFont(new Font("Cambria Math", Font.PLAIN, 70));
		gameOverLabel.setEnabled(true);
		gameOverLabel.setVisible(true);
		gameOverLabel.setForeground(new Color(0, 255, 0));
		layeredPane.setLayer(gameOverLabel, -2);
		gameOverLabel.setBackground(Color.BLACK);
		gameOverLabel.setBounds(100, 72, 415, 244);
		layeredPane.add(gameOverLabel);

		youWon.setFont(new Font("Cambria Math", Font.PLAIN, 70));
		youWon.setHorizontalAlignment(SwingConstants.CENTER);
		youWon.setForeground(new Color(0, 255, 0));
		youWon.setEnabled(true);
		youWon.setVisible(true);
		layeredPane.setLayer(youWon, -2);
		youWon.setBounds(100, 72, 415, 244);
		layeredPane.add(youWon);
		
	}
	
}
