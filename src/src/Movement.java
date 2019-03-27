import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class where the enemy and player movement is made.
 * @author programmingLuis
 *
 */

public class Movement {

	private static boolean leftOrRight = true;
	
	private static final Random RAND = new Random();
	private static final int VAR_TO_SHOOT = 6; // edit this to change probability that aliens shoot
	
	/**
	 * Movement of the aliens.
	 * @param firstRow
	 * @param secThirdRow will animate the first, second, third, and fourth row of aliens.
	 * @param fourthRow
	 * @param enemyLasers the generated lasers will be stored here
	 */
	
	public static void enemyMovement(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, List<JLabel> enemyLasers) {
		
		 ActionListener task = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            
		         if(!GameLogic.oneEnemyLeft(firstRow, secThirdRow, fourthRow)){   
		        	 
		        	 	for(JLabel l : firstRow) {
		          
		            	Animate.animateAlien(l);
		            	
		            	if(firstRow.get(firstRow.size()-1).getX()+Aliens.ALIEN_WIDTH>=513) leftOrRight = false;
		            	if(firstRow.get(0).getX()<=100) {
		            		
		            		firstRow.get(0).setBounds(firstRow.get(0).getX()+12, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	} 
		            	
		            	if(RAND.nextInt(VAR_TO_SHOOT) == 3) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(Animate.LASER);
		        			laser.setBounds(l.getX()+(Aliens.ALIEN_WIDTH/2), l.getY()+6, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
		        			if(enemyLasers.size()<3) enemyLasers.add(laser);
		            		
		            	}
		            	
		            }
		            
		            for(JLabel l : secThirdRow){
		            	
		            	Animate.animateAlien(l);

		            	if(secThirdRow.get(secThirdRow.size()-1).getX()+Aliens.ALIEN_WIDTH>=513) leftOrRight = false;
		            	if(secThirdRow.get(0).getX()<=100) {
		            		
		            		secThirdRow.get(0).setBounds(secThirdRow.get(0).getX()+12, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	}
		            	
		            	if(RAND.nextInt(VAR_TO_SHOOT) == 3) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(Animate.LASER);
		        			laser.setBounds(l.getX()+(Aliens.ALIEN_WIDTH/2), l.getY()+6, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
		        			if(enemyLasers.size()<3) enemyLasers.add(laser);
		            		
		            	}
		            	
		            }
		            
		            for(JLabel l : fourthRow){
				          
		            	Animate.animateAlien(l);

		            	if(fourthRow.get(fourthRow.size()-1).getX()+Aliens.ALIEN_WIDTH>=513) leftOrRight = false;
		            	if(fourthRow.get(0).getX()<=100) {
		            		
		            		fourthRow.get(0).setBounds(fourthRow.get(0).getX()+12, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		            	}
		            	
		            	if(RAND.nextInt(VAR_TO_SHOOT) == 3) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(Animate.LASER);
		        			laser.setBounds(l.getX()+(Aliens.ALIEN_WIDTH/2), l.getY()+6, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
		        			if(enemyLasers.size()<3) enemyLasers.add(laser);
		            		
		            			}
		            	
		            		}
		            
		         		} else boss(GameLogic.lastAlien(firstRow, secThirdRow, fourthRow), enemyLasers);
		         
		        	} 
		        };
		    Timer timer = new Timer(400, task);
		    timer.setRepeats(true);
		    timer.start();
		
	}

	/**
	 * Adds a key listener to player spaceship to generate movement and laser shots
	 * @param spaceship where the key listener will be attached
	 * @param lasers where the shot lasers will be stored
	 */
	public static void playerMovement(JLabel spaceship, List<JLabel> lasers) {
		spaceship.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()== KeyEvent.VK_SPACE){
					
					JLabel laser = new JLabel("");
					laser.setIcon(Animate.LASER);
					laser.setBounds(spaceship.getX()+(Player.SPACESHIP_WIDTH/2), spaceship.getY()-11, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
					
					if(lasers.size()<2) {
						
						SoundEffects.playerShot();
						lasers.add(laser);
					}

				}
				
				if(e.getKeyCode()== KeyEvent.VK_LEFT){
					
					if(!(spaceship.getX()-4<=100))spaceship.setBounds(spaceship.getX()-6, 320, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);
						
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){
					
					if(!(spaceship.getX()+Player.SPACESHIP_WIDTH+4>=513))spaceship.setBounds(spaceship.getX()+6, 320, Player.SPACESHIP_WIDTH, Player.SPACESHIP_HEIGHT);
					
				}
			}
		});
	}
	
	/**
	 * Movement of boss alien.
	 * @param alien alien to be made boss
	 * @param enemyLasers the stored lasers of the boss
	 */
	private static void boss(JLabel alien, List<JLabel> enemyLasers) {
		
		if(SoundEffects.playBossMusic) {
			
			SoundEffects.boss();
			SoundEffects.playBossMusic = false;
			
		}
		
		alien.setIcon(Animate.BOSS);
		
		if(alien.getX()+Aliens.ALIEN_WIDTH>=513) leftOrRight = false;
			if(alien.getX()-20<=100) {
		            		
		        alien.setBounds(alien.getX()+40, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		        leftOrRight = true;
		            }
		            	
		if(leftOrRight) {
		    alien.setBounds(alien.getX()+20, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		     } else if(!leftOrRight) {
		     alien.setBounds(alien.getX()-20, alien.getY(), Aliens.ALIEN_WIDTH, Aliens.ALIEN_HEIGHT);
		     } 
		            	
		    if(RAND.nextInt(VAR_TO_SHOOT) > 2) {
		            		
		     JLabel laser = new JLabel("");
		     laser.setIcon(Animate.LASER);
		     laser.setBounds(alien.getX()+(Aliens.ALIEN_WIDTH/2), alien.getY()+6, Attack.LASER_WIDTH, Attack.LASER_HEIGHT);
		     if(!(enemyLasers.size()>6)) enemyLasers.add(laser);
		            		
		            	}
		            	
		            
		
	}
	
}
