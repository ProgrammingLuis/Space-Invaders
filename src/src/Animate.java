import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class where the animation happens and where the ImageIcons are stored.
 * @author programmingLuis
 * I did not make these images, but downloaded them from the Internet.
 */

public class Animate {

	public static ImageIcon boss;
	
	public static ImageIcon squid_0;
	public static ImageIcon squid_1;
	
	public static ImageIcon bigsquid_0;
	public static ImageIcon bigsquid_1;
	
	public static ImageIcon alien_0;
	public static ImageIcon alien_1;
	
	public static ImageIcon laser;
	
	public static ImageIcon spaceship;
	
	public static ImageIcon enemy_Hit;
	public static ImageIcon player_Hit;
	
	public static void createImages() {
		
		try {
			boss = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/boss.png")), "boss");
			
			squid_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/squid0.png")), "squid0");
			squid_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/squid1.png")), "squid1");
			
			bigsquid_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/bigsquid0.png")), "bigsquid0");
			bigsquid_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/bigsquid1.png")), "bigsquid1");
			
			alien_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/alien0.png")), "alien0");
			alien_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/alien1.png")), "alien1");
			
			laser = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/laser.png")), "laser");
			
			spaceship = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/spaceShip.png")), "spaceship");
			
			enemy_Hit = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/enemyHit.png")), "enemyHit");
			player_Hit = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/spaceshipHit.png")), "playerHit");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Animates the alien by switching pictures.
	 * @param alien the alien that will be animated
	 */
	public static void animateAlien(JLabel alien) {
		
		if(alien.getIcon()==squid_0) alien.setIcon(squid_1);
		else if(alien.getIcon()==squid_1) alien.setIcon(squid_0);
		
		if(alien.getIcon()==bigsquid_0) alien.setIcon(bigsquid_1);
		else if(alien.getIcon()==bigsquid_1) alien.setIcon(bigsquid_0);
		
		if(alien.getIcon()==alien_0) alien.setIcon(alien_1);
		else if(alien.getIcon()==alien_1) alien.setIcon(alien_0);

	}
	
	/**
	 * Makes the enemy disappear after being shot.
	 * @param alienRow row of alien
	 * @param alien that exploded
	 */
	public static void enemyDisappear(List<JLabel> alienRow, JLabel alien) {
		ActionListener task2 = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            
	        	alien.setVisible(false);
	          
	        }};
	    Timer timer2 = new Timer(100, task2);
	    timer2.setRepeats(false);
	    timer2.start();
	}
	
}
