import java.awt.Image;
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
	
	public static ImageIcon background;

	/**
	 * Creates the images for the game.
	 */
	public static void createImages() {

		try {

			background = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/Background.png")));
			
			background = resizeImage(background, GameWindow.backgroundWidth, GameWindow.backgroundHeight);
			
			boss = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/boss.png")), "boss");

			boss = resizeImage(boss, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			squid_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/squid0.png")), "squid0");
			
			squid_0 = resizeImage(squid_0, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			squid_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/squid1.png")), "squid1");

			squid_1 = resizeImage(squid_1, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			bigsquid_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/bigSquid0.png")), "bigsquid0");
			
			bigsquid_0 = resizeImage(bigsquid_0, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			bigsquid_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/bigSquid1.png")), "bigsquid1");

			bigsquid_1 = resizeImage(bigsquid_1, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			alien_0 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/alien0.png")), "alien0");
			
			alien_0 = resizeImage(alien_0, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			alien_1 = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/alien1.png")), "alien1");
			
			alien_1 = resizeImage(alien_1, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);

			laser = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/laser.png")), "laser");
			
			laser = resizeImage(laser, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);

			spaceship = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/spaceShip.png")), "spaceship");
			
			spaceship = resizeImage(spaceship, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);

			enemy_Hit = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/enemyHit.png")), "enemyHit");
			
			enemy_Hit = resizeImage(enemy_Hit, Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
			
			player_Hit = new ImageIcon(ImageIO.read(ApplicationMain.class.getResource("/Resource/spaceshipHit.png")), "playerHit");
			
			player_Hit = resizeImage(player_Hit, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static ImageIcon resizeImage(ImageIcon i, int width, int height) {
		
		return new ImageIcon(i.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH), i.getDescription());
		
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
