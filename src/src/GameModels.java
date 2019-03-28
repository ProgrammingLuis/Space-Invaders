import java.awt.Dimension;

/**
 * Insert all game models here that need to be scaled.
 * All models are initially made in 1920x1080 but work fine with 800x600.
 * @author programmingLuis
 *
 */

public interface GameModels {
	
	/**
	 * Models that are scaled according to screen size.
	 */
	
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
	
	/**
	 * Game fonts that are scaled according to screen size.
	 */
	
	public static final Dimension INIT_STRT_FONT = new Dimension(27,0);
	public static final Dimension INIT_SCRINFO_FONT = new Dimension(15,0);
	public static final Dimension INIT_GAME_FONT = new Dimension(70,0);
	
	/**
	 * Game model positions.
	 */
	
	public static final Dimension INIT_SCORE_POS = new Dimension(297,8);
	public static final Dimension INIT_BKGD_X1Y1 = new Dimension(100,64);
	public static final Dimension INIT_BKGD_X2Y2 = new Dimension(513,331);
	public static final Dimension INIT_ALIEN_POS = new Dimension(188,112);
	public static final Dimension INIT_PLAYER_POS = new Dimension(278,320);
	public static final Dimension INIT_XY_VAR = new Dimension(30,30);
	public static final Dimension INIT_INFO_LAB_POS = new Dimension(10,0);
	public static final Dimension INIT_INFO_PAN_POS = new Dimension(100,339);
	public static final Dimension INIT_STRTLBL_POS = new Dimension(190,200);
	
}
