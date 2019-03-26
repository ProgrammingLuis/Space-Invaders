import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Movement {

	static int picNum = 0;
	static boolean leftOrRight = true;
	static Random rand = new Random();
	static int varToShoot = 32;
	
	public static void enemyMovement(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, List<JLabel> enemyLasers) {
		
		 ActionListener task = new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		            
		            if(picNum==0) picNum++;
		            else picNum = 0;
         
		            for(JLabel l : firstRow) {
		          
		            	l.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/squid" + picNum + ".png")));
		            	
		            	if(firstRow.get(firstRow.size()-1).getX()+l.getWidth()>=513) leftOrRight = false;
		            	if(firstRow.get(0).getX()<=100) {
		            		
		            		firstRow.get(0).setBounds(firstRow.get(0).getX()+12, l.getY(), 20, 19);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), 20, 19);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), 20, 19);
		            	} 
		            	
		            	if(rand.nextInt(varToShoot) == 10) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/laser.png")));
		        			laser.setBounds(l.getX()+(l.getWidth()/2), l.getY()+6, 4, 11);
		        			if(!(enemyLasers.size()>2)) enemyLasers.add(laser);
		            		
		            	}
		            	
		            }
		            
		            for(JLabel l : secThirdRow){
		            	
		            	l.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/bigSquid" + picNum + ".png")));

		            	if(secThirdRow.get(secThirdRow.size()-1).getX()+l.getWidth()>=513) leftOrRight = false;
		            	if(secThirdRow.get(0).getX()<=100) {
		            		
		            		secThirdRow.get(0).setBounds(secThirdRow.get(0).getX()+12, l.getY(), 20, 19);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), 20, 19);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), 20, 19);
		            	}
		            	
		            	if(rand.nextInt(varToShoot) == 10) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/laser.png")));
		        			laser.setBounds(l.getX()+(l.getWidth()/2), l.getY()+6, 4, 11);
		        			if(!(enemyLasers.size()>2)) enemyLasers.add(laser);
		            		
		            	}
		            	
		            }
		            
		            for(JLabel l : fourthRow){
				          
		            	l.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/alien" + picNum + ".png")));

		            	if(fourthRow.get(fourthRow.size()-1).getX()+l.getWidth()>=513) leftOrRight = false;
		            	if(fourthRow.get(0).getX()<=100) {
		            		
		            		fourthRow.get(0).setBounds(fourthRow.get(0).getX()+12, l.getY(), 20, 19);
		            		leftOrRight = true;
		            	}
		            	
		            	if(leftOrRight) {
		            		l.setBounds(l.getX()+6, l.getY(), 20, 19);
		            	} else if(!leftOrRight) {
		            		l.setBounds(l.getX()-6, l.getY(), 20, 19);
		            	}
		            	
		            	if(rand.nextInt(varToShoot) == 10) {
		            		
		            		JLabel laser = new JLabel("");
		        			laser.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/laser.png")));
		        			laser.setBounds(l.getX()+(l.getWidth()/2), l.getY()+6, 4, 11);
		        			if(!(enemyLasers.size()>2)) enemyLasers.add(laser);
		            		
		            	}
		            	
		            }
		            
		        }
		        };
		    Timer timer = new Timer(500, task);
		    timer.setRepeats(true);
		    timer.start();
		
	}

	public static void playerMovement(JLabel spaceship, List<JLabel> lasers) {
		spaceship.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()== KeyEvent.VK_SPACE){
					
					JLabel laser = new JLabel("");
					laser.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/laser.png")));
					laser.setBounds(spaceship.getX()+(spaceship.getWidth()/2), spaceship.getY()-11, 4, 11);
					
					if(lasers.size()<5) lasers.add(laser);

				}
				
				if(e.getKeyCode()== KeyEvent.VK_LEFT){
					
					if(!(spaceship.getX()-4<=100))spaceship.setBounds(spaceship.getX()-6, 320, 28, 18);
						
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){
					
					if(!(spaceship.getX()+spaceship.getWidth()+4>=513))spaceship.setBounds(spaceship.getX()+6, 320, 28, 18);
					
				}
			}
		});
	}
	
}