package game;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import display.GameInfo;
import display.GameWindow;
import display.ScaleRes;
import entities.Aliens;
import entities.Player;
import game_sounds.SoundEffects;
import movement.Animate;
import movement.Movement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class where the application is launched from.
 * @author programmingLuis
 *
 */

public class ApplicationMain {

	private static ApplicationMain window;
	
	/**
	 * Only static variable because it needed to be closed from outside of this class.
	 */

	private static JFrame frmSpaceInvaders = new JFrame("Space Invaders");
	private static int frmXPos  = ScaleRes.getJFrmXPos(ScaleRes.INIT_FRM_POS);
	private static int frmYPos = ScaleRes.getJFrmYPos(ScaleRes.INIT_FRM_POS);

	/**
	 * Instance variables that will be initialized with other classes.
	 */

	private JLabel spaceship = new JLabel(Animate.spaceship);
	private JLabel infoLabel = new JLabel("Coded by Luis");
	private JLabel startLabel = new JLabel("Press SPACE to start.");
	
	private int startLabelXPos = ScaleRes.getXPos(ScaleRes.INIT_STRTLBL_POS);
	private int startLabelYPos = ScaleRes.getYPos(ScaleRes.INIT_STRTLBL_POS);

	private int startLabelWidth = ScaleRes.getScaledWidth(ScaleRes.INIT_STRT_LAB);
	private int startLabelHeight = ScaleRes.getScaledHeight(ScaleRes.INIT_STRT_LAB);
	
	private int strtLabFontSize = ScaleRes.getScaledWidth(ScaleRes.INIT_STRT_FONT);
	
	private JPanel infoPanel = new JPanel(null); 

	private List<JLabel> firstRow = new ArrayList<JLabel>();
	private List<JLabel> secThirdRow = new ArrayList<JLabel>();
	private List<JLabel> fourthRow = new ArrayList<JLabel>();

	private List<JLabel> lasers = new ArrayList<JLabel>();
	private List<JLabel> enemyLasers = new ArrayList<JLabel>();

	private JLayeredPane layeredPane = new JLayeredPane();
	private JLabel scoreLabel = new JLabel("Score: " + String.format("%04d", 0));
	private JLabel youWon = new JLabel("YOU WON");
	private JLabel gameOverLabel = new JLabel("YOU LOST");
	private JLabel background = new JLabel(Animate.background);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSpaceInvaders.setBounds(frmXPos, frmYPos, ScaleRes.getScaledWidth(ScaleRes.INIT_FRAME), ScaleRes.getScaledHeight(ScaleRes.INIT_FRAME));
					Animate.createImages();
					window = new ApplicationMain();
					window.createWindow();
					window.startMenu();
					window.enemyMovement();
					window.playerShot();
					window.enemyShot();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Default Constructor.
	 */
	public ApplicationMain() {


	}

	/**
	 * Initialize the contents of the game.
	 */
	private void initialize() {

		GameInfo.createInfoElements(infoPanel, infoLabel, scoreLabel, gameOverLabel, youWon, layeredPane);

		Aliens.createAliens(firstRow, secThirdRow, fourthRow, layeredPane);

		Player.createPlayer(spaceship, lasers, layeredPane);


	}

	private void createWindow() {
		GameWindow.createWindow(frmSpaceInvaders, layeredPane, background);
	}

	private void startMenu() {
		startGame(startLabel);
	}

	private void enemyMovement() {

		Movement.enemyMovement(firstRow, secThirdRow, fourthRow, enemyLasers);

	}

	private void playerShot() {

		Attack.playerShoot(lasers, firstRow, secThirdRow, fourthRow, layeredPane, scoreLabel, background, youWon, enemyLasers, spaceship);

	}

	private void enemyShot() {

		Attack.enemyShoot(enemyLasers, spaceship, layeredPane, background, gameOverLabel, firstRow, secThirdRow, fourthRow);

	}

	/**
	 * Starts game.
	 * @param startLabel Label needed to have start menu functionality.
	 */
	private void startGame(JLabel startLabel) {

		SoundEffects.theme();

		startLabel.setFont(new Font("Cambria Math", Font.PLAIN, strtLabFontSize));
		startLabel.setBounds(startLabelXPos, startLabelYPos, startLabelWidth, startLabelHeight);
		layeredPane.setLayer(startLabel, 4);
		startLabel.setEnabled(true);
		startLabel.setVisible(true);
		startLabel.setForeground(new Color(0, 255, 0));
		layeredPane.add(startLabel);

		startLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()== KeyEvent.VK_SPACE){

					SoundEffects.stopTheme();
					startLabel.setEnabled(false);
					startLabel.setVisible(false);
					initialize();
					SoundEffects.battle();
				}


			}
		});

		startLabel.requestFocus();

	}

	/**
	 * Resets the game by clearing the JFrame of all initialized components, so they can be reinitialized.
	 */
	public static void reset() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					frmSpaceInvaders.getContentPane().removeAll();
					window = new ApplicationMain();
					window.createWindow();
					window.startMenu();
					window.enemyMovement();
					window.playerShot();
					window.enemyShot();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
