package display;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Class where the informative GUI elements of the game are made.
 * @author programmingLuis
 *
 */

public class GameInfo {

	private static int infoPanelWidth = ScaleRes.getScaledWidth(ScaleRes.INIT_INFO_PAN);
	private static int infoPanelHeight = ScaleRes.getScaledHeight(ScaleRes.INIT_INFO_PAN);
	
	private static int infoPanelXPos = ScaleRes.getXPos(ScaleRes.INIT_INFO_PAN_POS);
	private static int infoPanelYPos = ScaleRes.getYPos(ScaleRes.INIT_INFO_PAN_POS);
	
	private static int scoreLabelHeight = ScaleRes.getScaledWidth(ScaleRes.INIT_SCORE);
	private static int scoreLabelWidth = ScaleRes.getScaledHeight(ScaleRes.INIT_SCORE);
	
	private static int scoreInfoFontSize = ScaleRes.getScaledWidth(ScaleRes.INIT_SCRINFO_FONT);
	private static int gameFontSize = ScaleRes.getScaledWidth(ScaleRes.INIT_GAME_FONT);
	
	private static int scoreLabelXPos = ScaleRes.getXPos(ScaleRes.INIT_SCORE_POS);
	private static int scoreLabelYPos =  ScaleRes.getYPos(ScaleRes.INIT_SCORE_POS);
	
	private static int infoLabelXPos = ScaleRes.getXPos(ScaleRes.INIT_INFO_LAB_POS);
	private static int infoLabelYPos = ScaleRes.getYPos(ScaleRes.INIT_INFO_LAB_POS);
	
	private static int infoLabelWidth = ScaleRes.getScaledWidth(ScaleRes.INIT_INFO_LAB);
	
	private static int gameLabelHeight = (int) ((GameWindow.backgroundUpBound+GameWindow.backgroundDownBound)/1.5);
	
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
		infoPanel.setBounds(infoPanelXPos, infoPanelYPos, infoPanelWidth, infoPanelHeight);
		layeredPane.add(infoPanel);

		infoLabel.setFont(new Font("Tahoma", Font.PLAIN, scoreInfoFontSize));
		infoLabel.setForeground(new Color(0, 255, 0));
		infoLabel.setBounds(infoLabelXPos, infoLabelYPos, infoLabelWidth, infoPanelHeight);
		infoPanel.add(infoLabel);

		scoreLabel.setBounds(scoreLabelXPos, scoreLabelYPos, scoreLabelHeight, scoreLabelWidth);
		infoPanel.add(scoreLabel);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, scoreInfoFontSize));
		scoreLabel.setForeground(new Color(0, 255, 0));

		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setFont(new Font("Cambria Math", Font.PLAIN, gameFontSize));
		gameOverLabel.setEnabled(true);
		gameOverLabel.setVisible(true);
		gameOverLabel.setForeground(new Color(0, 255, 0));
		layeredPane.setLayer(gameOverLabel, -2);
		gameOverLabel.setBackground(Color.BLACK);
		gameOverLabel.setBounds(GameWindow.backgroundLeftBound, GameWindow.backgroundUpBound, infoPanelWidth, gameLabelHeight);
		layeredPane.add(gameOverLabel);

		youWon.setFont(new Font("Cambria Math", Font.PLAIN, gameFontSize));
		youWon.setHorizontalAlignment(SwingConstants.CENTER);
		youWon.setForeground(new Color(0, 255, 0));
		youWon.setEnabled(true);
		youWon.setVisible(true);
		layeredPane.setLayer(youWon, -2);
		youWon.setBounds(GameWindow.backgroundLeftBound, GameWindow.backgroundUpBound, infoPanelWidth, gameLabelHeight);
		layeredPane.add(youWon);

	}

}
