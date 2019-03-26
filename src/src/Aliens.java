import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Aliens {

	public static final int ALIEN_WIDTH = 20;
	public static final int ALIEN_HEIGHT = 19;
	
	public static final int INIT_X = 218;
	public static final int XY_VAR = 30;
	
	public static int x1 = INIT_X; 
	public static int y1 = 112;
	
	public static int x2 = INIT_X;
	public static int y2 = y1+XY_VAR;
	
	public static int x3 = INIT_X;
	public static int y3 = y2+XY_VAR;
	
	public static int x4 = INIT_X;
	public static int y4 = y3+XY_VAR;
	
	public static void createAliens(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane) {
		
		for(int r = 0; r < 4; r++) {
			
			if(r==0) {
				
				for(int c = 0; c < 6; c++) {
					JLabel alien = new JLabel("");
					alien.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/squid" + "0" + ".png")));
					alien.setBounds(x1+=XY_VAR, y1, ALIEN_WIDTH, ALIEN_HEIGHT);
					layeredPane.add(alien,0); 
					firstRow.add(alien);
				}
				
			} else if(r==1) {
				
				for(int c = 0; c < 6; c++) {
					JLabel alien = new JLabel("");
					alien.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/bigsquid" + "0" + ".png")));
					alien.setBounds(x2+=XY_VAR, y2, ALIEN_WIDTH, ALIEN_HEIGHT);
					layeredPane.add(alien,0); 
					secThirdRow.add(alien);	
				}
				
			} else if(r==2) {
				
				for(int c = 0; c < 6; c++) {
					JLabel alien = new JLabel("");
					alien.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/bigsquid" + "0" + ".png")));
					alien.setBounds(x3+=XY_VAR, y3, ALIEN_WIDTH, ALIEN_HEIGHT);
					layeredPane.add(alien,0); 
					secThirdRow.add(alien);
				}
				
			} else if(r==3) {
				
				for(int c = 0; c < 6; c++) {
					JLabel alien = new JLabel("");
					alien.setIcon(new ImageIcon(ApplicationMain.class.getResource("/Resource/alien" + "0" + ".png")));
					alien.setBounds(x4+=XY_VAR, y4, ALIEN_WIDTH, ALIEN_HEIGHT);
					layeredPane.add(alien,0); 
					secThirdRow.add(alien);
				}
			}
		}
		
	}
	
}
