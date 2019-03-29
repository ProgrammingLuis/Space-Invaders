package entities;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import display.ScaleRes;
import movement.Animate;

/**
 * Class where the aliens are created.
 * @author programmingLuis
 *
 */

public class Aliens {

	public static final int ALIEN_WIDTH = ScaleRes.getScaledWidth(ScaleRes.INIT_ALIEN);
	public static final int ALIEN_HEIGHT = ScaleRes.getScaledHeight(ScaleRes.INIT_ALIEN);

	public static final int INIT_X = ScaleRes.getXPos(ScaleRes.INIT_ALIEN_POS);
	public static final int XY_VAR = ScaleRes.getScaledWidth(ScaleRes.INIT_XY_VAR);

	public static int x1 = INIT_X; 
	public static int y1 = ScaleRes.getYPos(ScaleRes.INIT_ALIEN_POS);

	public static int x2 = INIT_X;
	public static int y2 = y1+XY_VAR;

	public static int x3 = INIT_X;
	public static int y3 = y2+XY_VAR;

	public static int x4 = INIT_X;
	public static int y4 = y3+XY_VAR;
	
	private static JLabel alien;

	/**
	 * creates the aliens
	 * @param firstRow
	 * @param secThirdRow the rows of aliens that will be made.
	 * @param fourthRow
	 * @param layeredPane where the aliens will be stored.
	 */
	public static void createAliens(List<JLabel> firstRow, List<JLabel> secThirdRow, List<JLabel> fourthRow, JLayeredPane layeredPane) {

		for(int r = 1; r <= 4; r++) {

			if(r==1) {

				for(int c = 0; c <= 6; c++) {
					alien = new JLabel(Animate.squid_0);
					addAlien(x1+=XY_VAR, y1, layeredPane, firstRow);
				}

			} else if(r==2) {

				for(int c = 0; c <= 6; c++) {
					alien = new JLabel(Animate.bigsquid_0);
					addAlien(x2+=XY_VAR, y2, layeredPane, secThirdRow);
				}

			} else if(r==3) {

				for(int c = 0; c <= 6; c++) {
					alien = new JLabel(Animate.bigsquid_0);
					addAlien(x3+=XY_VAR, y3, layeredPane, secThirdRow);
				}

			} else if(r==4) {

				for(int c = 0; c <= 6; c++) {
					alien = new JLabel(Animate.alien_0);
					addAlien(x4+=XY_VAR, y4, layeredPane, fourthRow);
				}
			}
		}

	}
	
	/**
	 * Adds alien to their row and places them on the screen.
	 * @param xPos the x position of the alien
	 * @param yPos the y position of the alien
	 * @param layeredPane the layered pane of the alien
	 * @param row the row of the alien
	 */
	private static void addAlien(int xPos, int yPos, JLayeredPane layeredPane, List<JLabel> row) {
		
		alien.setBounds(xPos, yPos, ALIEN_WIDTH, ALIEN_HEIGHT);
		layeredPane.add(alien,0); 
		row.add(alien);
		
	}
	

}
