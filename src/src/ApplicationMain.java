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

	private static JFrame frmSpaceInvaders = new JFrame();
	
	private JLabel spaceship = new JLabel();
	private JLabel infoLabel = new JLabel("Coded by Luis");
	private JLabel startLabel = new JLabel("Press SPACE to start.");
	
	private JPanel infoPanel = new JPanel(); 
	
	private List<JLabel> firstRow = new ArrayList<JLabel>();
	private List<JLabel> secThirdRow = new ArrayList<JLabel>();
	private List<JLabel> fourthRow = new ArrayList<JLabel>();

	private List<JLabel> lasers = new ArrayList<JLabel>();
	private List<JLabel> enemyLasers = new ArrayList<JLabel>();
	
	private JLayeredPane layeredPane = new JLayeredPane();
	private JLabel scoreLabel = new JLabel("Score: 0");
	private JLabel youWon = new JLabel("YOU WON");
	private JLabel gameOverLabel = new JLabel("YOU LOST");
	private JLabel background = new JLabel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationMain window = new ApplicationMain();
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
	 * Create the application.
	 */
	public ApplicationMain() {
		
		//GameWindow.createWindow(frmSpaceInvaders, layeredPane, background, startLabel);

		//startGame(startLabel);
		
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
		GameWindow.createWindow(frmSpaceInvaders, layeredPane, background, startLabel);
	}
	
	private void startMenu() {
		startGame(startLabel);
	}
	
	private void enemyMovement() {
		
		Movement.enemyMovement(firstRow, secThirdRow, fourthRow, enemyLasers);
		
	}
	
	private void playerShot() {
		
		Attack.playerShoot(lasers, firstRow, secThirdRow, fourthRow, layeredPane, scoreLabel, background, youWon);

	}
	
	private void enemyShot() {
		
		Attack.enemyShoot(enemyLasers, spaceship, layeredPane, background, gameOverLabel);
		
	}
	
	private void startGame(JLabel startLabel) {
		
		startLabel.setFont(new Font("Cambria Math", Font.PLAIN, 27));
		startLabel.setBounds(190, 200, 245, 29);
		layeredPane.setLayer(startLabel, 4);
		startLabel.setEnabled(true);
		startLabel.setVisible(true);
		startLabel.setForeground(new Color(0, 255, 0));
		layeredPane.add(startLabel);
		
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frmSpaceInvaders.getContentPane().removeAll();
					frmSpaceInvaders.repaint();
					ApplicationMain window = new ApplicationMain();
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
