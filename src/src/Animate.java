import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class where the animation happens and where the ImageIcons are stored.
 * @author programmingLuis
 * I did not make these images, but downloaded them from the Internet.
 */

public class Animate {

	public static final ImageIcon SQUID_0 = new ImageIcon(ApplicationMain.class.getResource("/Resource/squid0.png"), "squid0");
	public static final ImageIcon SQUID_1 = new ImageIcon(ApplicationMain.class.getResource("/Resource/squid1.png"), "squid1");
	
	public static final ImageIcon BIGSQUID_0 = new ImageIcon(ApplicationMain.class.getResource("/Resource/bigsquid0.png"), "bigsquid0");
	public static final ImageIcon BIGSQUID_1 = new ImageIcon(ApplicationMain.class.getResource("/Resource/bigsquid1.png"), "bigsquid1");
	
	public static final ImageIcon ALIEN_0 = new ImageIcon(ApplicationMain.class.getResource("/Resource/alien0.png"), "alien0");
	public static final ImageIcon ALIEN_1 = new ImageIcon(ApplicationMain.class.getResource("/Resource/alien1.png"), "alien1");
	
	public static final ImageIcon LASER = new ImageIcon(ApplicationMain.class.getResource("/Resource/laser.png"), "laser");
	
	public static final ImageIcon SPACESHIP = new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceShip.png"), "spaceship");
	
	public static final ImageIcon ENEMY_HIT = new ImageIcon(ApplicationMain.class.getResource("/Resource/enemyHit.png"), "enemyHit");
	public static final ImageIcon PLAYER_HIT = new ImageIcon(ApplicationMain.class.getResource("/Resource/spaceshipHit.png"), "playerHit");
	
	/**
	 * Animates the alien by switching pictures.
	 * @param alien the alien that will be animated
	 */
	public static void animateAlien(JLabel alien) {
		
		if(alien.getIcon()==SQUID_0) alien.setIcon(SQUID_1);
		else if(alien.getIcon()==SQUID_1) alien.setIcon(SQUID_0);
		
		if(alien.getIcon()==BIGSQUID_0) alien.setIcon(BIGSQUID_1);
		else if(alien.getIcon()==BIGSQUID_1) alien.setIcon(BIGSQUID_0);
		
		if(alien.getIcon()==ALIEN_0) alien.setIcon(ALIEN_1);
		else if(alien.getIcon()==ALIEN_1) alien.setIcon(ALIEN_0);
		
	}
	
}
