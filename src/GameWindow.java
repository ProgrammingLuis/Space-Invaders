import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class GameWindow {
	
	/**
	 * Creates the window where the game will be played.
	 * @param frmSpaceInvaders the frame where all the game components will go.
	 * @param layeredPane the layered pane needed to put game components in order.
	 * @param background the background of the game. In the form of a JLabel with an icon.
	 */
	
	public static void createWindow(JFrame frmSpaceInvaders, JLayeredPane layeredPane, JLabel background) {


		frmSpaceInvaders.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationMain.class.getResource("/Resource/bigSquid0.png")));
		frmSpaceInvaders.setTitle("Space Invaders");
		frmSpaceInvaders.setResizable(false);
		frmSpaceInvaders.getContentPane().setBackground(Color.BLACK);
		frmSpaceInvaders.getContentPane().setLayout(null);
		frmSpaceInvaders.setVisible(true);
		frmSpaceInvaders.setBounds(450, 150, 616, 474);
		frmSpaceInvaders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layeredPane.setBounds(0, 0, 611, 446);
		frmSpaceInvaders.getContentPane().add(layeredPane);
		
		background.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/Background.png")));
		layeredPane.setLayer(background, -1);
		background.setBounds(0, 0, 611, 446);
		layeredPane.add(background);
		
	}
	
}
