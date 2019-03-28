import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Scales the game to a higher resolution than 1920x1080.
 * @author programmingLuis
 *
 */
public class ScaleRes {

	public static final Dimension INIT_FRAME = new Dimension(616,474);
	public static final Dimension INIT_BKGD = new Dimension(611, 446);
	public static final Dimension INIT_ALIEN = new Dimension(20,19);
	public static final Dimension INIT_LASER = new Dimension(4,11);
	public static final Dimension INIT_ENEMY_VEL = new Dimension(6,0);
	public static final Dimension INIT_PLAYER_VEL = new Dimension(2,0);
	public static final Dimension INIT_BOSS_VEL = new Dimension(20,0);
	public static final Dimension INIT_SPACESHIP = new Dimension(28,18);
	public static final Dimension INIT_INFO_PAN = new Dimension(415,34);
	public static final Dimension INIT_SCORE = new Dimension(118,19);
	public static final Dimension INIT_INFO_LAB = new Dimension(127,0);
	public static final Dimension INIT_STRT_LAB = new Dimension(245,29);
	public static final Dimension INIT_SCREEN = new Dimension(1920,1080);
	public static final Dimension INIT_FRM_POS = new Dimension(450,150);
	
	public static final Dimension INIT_STRT_FONT = new Dimension(27,0);
	public static final Dimension INIT_SCRINFO_FONT = new Dimension(15,0);
	public static final Dimension INIT_GAME_FONT = new Dimension(70,0);
	
	public static final Dimension INIT_SCORE_POS = new Dimension(297,8);
	public static final Dimension INIT_BKGD_X1Y1 = new Dimension(100,64);
	public static final Dimension INIT_BKGD_X2Y2 = new Dimension(513,331);
	public static final Dimension INIT_ALIEN_POS = new Dimension(188,112);
	public static final Dimension INIT_PLAYER_POS = new Dimension(278,320);
	public static final Dimension INIT_XY_VAR = new Dimension(30,30);
	public static final Dimension INIT_INFO_LAB_POS = new Dimension(10,0);
	public static final Dimension INIT_INFO_PAN_POS = new Dimension(100,339);
	public static final Dimension INIT_STRTLBL_POS = new Dimension(190,200);
	
	private static final Dimension CURRENT_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

	private static double widthRatio(Dimension d) {
		return d.getWidth()/INIT_SCREEN.getWidth();
	}
	
	private static double heightRatio(Dimension d) {
		return d.getHeight()/INIT_SCREEN.getHeight();
	}
	
	public static int getScaledWidth(Dimension d) {
		
		double widthRatio = widthRatio(d);
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (widthRatio*CURRENT_SCREEN.getWidth());} else return (int) d.getWidth();
	}
	
	public static int getScaledWidth(Dimension d, String frmPos) { // method is just for making the JFrame appear on the screen.
		
		double widthRatio = widthRatio(d);
		
		return (int) (widthRatio*CURRENT_SCREEN.getWidth());
	}
	
	public static int getScaledHeight(Dimension d) {
		
		double heightRatio = heightRatio(d);
		
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (heightRatio*CURRENT_SCREEN.getHeight());} else return (int) d.getHeight();
	}
	
	public static int getScaledHeight(Dimension d, String frmPos) { // method is just for making the JFrame appear on the screen.
		
		double heightRatio = heightRatio(d);
		
		return (int) (heightRatio*CURRENT_SCREEN.getHeight());
	}
	
	private static double getXRatio(Dimension d) {
		return d.getWidth()/INIT_FRAME.getWidth();
	}
	
	private static double getYRatio(Dimension d) {
		return d.getHeight()/INIT_FRAME.getHeight();
	}
	
	public static int getXPos(Dimension d) {
		
		double xRatio = getXRatio(d);
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (xRatio*getScaledWidth(INIT_FRAME));} else return (int) d.getWidth();
	}
	
	public static int getYPos(Dimension d) {
		
		double yRatio = getYRatio(d);
		
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (yRatio*getScaledHeight(INIT_FRAME));} else return (int) d.getHeight();
	}

}
