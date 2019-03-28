import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * Class where the window of the game is made.
 * @author programmingLuis
 *
 */

public class GameWindow {

	/**
	 * Creates the window where the game will be played.
	 * @param frmSpaceInvaders the frame where all the game components will go.
	 * @param layeredPane the layered pane needed to put game components in order.
	 * @param background the background of the game. In the form of a JLabel with an icon.
	 */
	
	public static int backgroundLeftBound = ScaleRes.getXPos(ScaleRes.INIT_BKGD_X1Y1);
	public static int backgroundUpBound = ScaleRes.getYPos(ScaleRes.INIT_BKGD_X1Y1);
	public static int backgroundRightBound = ScaleRes.getXPos(ScaleRes.INIT_BKGD_X2Y2);
	public static int backgroundDownBound = ScaleRes.getYPos(ScaleRes.INIT_BKGD_X2Y2);
	
	public static int backgroundWidth = ScaleRes.getScaledWidth(ScaleRes.INIT_BKGD);
	public static int backgroundHeight = ScaleRes.getScaledHeight(ScaleRes.INIT_BKGD);

	public static void createWindow(JFrame frmSpaceInvaders, JLayeredPane layeredPane, JLabel background) {


		frmSpaceInvaders.setIconImage(Toolkit.getDefaultToolkit().getImage(ApplicationMain.class.getResource("/Resource/bigSquid0.png")));
		frmSpaceInvaders.setTitle("Space Invaders");
		frmSpaceInvaders.setResizable(true);
		frmSpaceInvaders.getContentPane().setBackground(Color.BLACK);
		frmSpaceInvaders.getContentPane().setLayout(null);
		frmSpaceInvaders.setVisible(true);
		frmSpaceInvaders.setResizable(false);
		frmSpaceInvaders.setBounds(frmSpaceInvaders.getX(), frmSpaceInvaders.getY(), ScaleRes.getScaledWidth(ScaleRes.INIT_FRAME), ScaleRes.getScaledHeight(ScaleRes.INIT_FRAME));
		frmSpaceInvaders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layeredPane.setBounds(0, 0, backgroundWidth, backgroundHeight);
		frmSpaceInvaders.getContentPane().add(layeredPane);
		background.setIcon(Animate.background);
		layeredPane.setLayer(background, -1);
		background.setBounds(0, 0, backgroundWidth, backgroundHeight);
		layeredPane.add(background);

	}


}
