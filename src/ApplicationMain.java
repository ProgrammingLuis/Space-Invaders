import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ApplicationMain {

	private JFrame frmSpaceInvaders = new JFrame();
	
	private JLabel spaceship = new JLabel();
	private JLabel infoLabel = new JLabel("Coded by Luis");
	private JLabel startLabel = new JLabel("Press SPACE to start.");
	
	private JPanel infoPanel = new JPanel(); 
	
	private List<JLabel> firstRow = new ArrayList<JLabel>();
	private List<JLabel> secThirdRow = new ArrayList<JLabel>();
	private List<JLabel> fourthRow = new ArrayList<JLabel>();

	private List<JLabel> lasers = new ArrayList<JLabel>();
	private List<JLabel> enemyLasers = new ArrayList<JLabel>();
	
	public static JLayeredPane layeredPane = new JLayeredPane();
	public static JLabel scoreLabel = new JLabel("Score: 0");
	public static JLabel youWon = new JLabel("YOU WON");
	public static JLabel gameOverLabel = new JLabel("YOU LOST");
	public static JLabel background = new JLabel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationMain window = new ApplicationMain();
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
	 * Create the application.
	 */
	public ApplicationMain() {
		
		GameWindow.createWindow(frmSpaceInvaders, layeredPane, background, startLabel);

		startGame(startLabel);
		
	}

	/**
	 * Initialize the contents of the game.
	 */
	private void initialize() {
		
		GameInfo.createInfoElements(infoPanel, infoLabel, scoreLabel, gameOverLabel, youWon);
		
		Aliens.createAliens(firstRow, secThirdRow, fourthRow);

		Player.createPlayer(spaceship, lasers);
	
		
	}
	
	private void enemyMovement() {
		
		Movement.enemyMovement(firstRow, secThirdRow, fourthRow, enemyLasers);
		
	}
	
	private void playerShot() {
		
		Attack.playerShoot(lasers, firstRow, secThirdRow, fourthRow);

	}
	
	private void enemyShot() {
		
		Attack.enemyShoot(enemyLasers, spaceship);
		
	}
	
	private void startGame(JLabel startLabel) {
		
		startLabel.setFont(new Font("Cambria Math", Font.PLAIN, 27));
		startLabel.setBounds(190, 200, 245, 29);
		ApplicationMain.layeredPane.setLayer(startLabel, 4);
		startLabel.setEnabled(true);
		startLabel.setVisible(true);
		startLabel.setForeground(new Color(0, 255, 0));
		ApplicationMain.layeredPane.add(startLabel);
		
		startLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()== KeyEvent.VK_SPACE){
					
					startLabel.setEnabled(false);
					startLabel.setVisible(false);
					initialize();
				
				}
				
				
			}
		});
		
		startLabel.requestFocus();
		
	}
	
	public static void reset() {
		
		
		
	}
}
