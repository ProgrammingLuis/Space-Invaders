import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Scales the game to a higher resolution than 1920x1080.
 * @author programmingLuis
 *
 */
public class ScaleRes implements GameModels{

	/**
	 * Change to change the scaling on screens with above 1920*1080 res.
	 */
	
	private static final double SCALE_1080_PLUS = 2;
	
	/**
	 * Change to change the scaling on screens with 1920*1080 res and below.
	 */
	
	private static final double SCALE_1080_BELOW = 1.5;
	
	/**
	 * Gets the current screen size of the user.
	 */
	
	private static final Dimension CURRENT_SCREEN = Toolkit.getDefaultToolkit().getScreenSize();

	/**
	 * Calculates the width ratio of the initial game model with the initial screen.
	 * @param d the initial game model's dimension 
	 * @return the ratio of the initial game model with the initial screen
	 */
	
	private static double widthRatio(Dimension d) {
		return d.getWidth()/INIT_SCREEN.getWidth();
	}
	
	/**
	 * Calculates the height ratio of the initial game model with the initial screen.
	 * @param d the initial game model's dimension 
	 * @return height ratio of the initial game model with the initial screen
	 */
	
	private static double heightRatio(Dimension d) {
		return d.getHeight()/INIT_SCREEN.getHeight();
	}
	
	/**
	 * Scales the game model width according to the current screen size.
	 * @param d the game model's dimension that needs to be scaled
	 * @return the width of the new scaled game model
	 */
	
	public static int getScaledWidth(Dimension d) {
		
		double widthRatio = widthRatio(d);
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) ((widthRatio*CURRENT_SCREEN.getWidth()) * SCALE_1080_PLUS);} else return (int) (d.getWidth()* SCALE_1080_BELOW);
	}
	
	/**
	 * Method that makes the JFrm appear on the screen.
	 * @param d the JFrm dimension 
	 * @return the jfrm's x position
	 */
	
	public static int getJFrmXPos(Dimension d) { 
		
		double widthRatio = widthRatio(d);
		
		return (int) (widthRatio*CURRENT_SCREEN.getWidth());
	}
	
	/**
	 * Scales the game model height according to the current screen size.
	 * @param d the game model's dimension that needs to be scaled
	 * @return the width of the new scaled game model
	 */
	
	public static int getScaledHeight(Dimension d) {
		
		double heightRatio = heightRatio(d);
		
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) ((heightRatio*CURRENT_SCREEN.getHeight()) * SCALE_1080_PLUS);} else return (int) (d.getHeight()* SCALE_1080_BELOW);
	}
	
	/**
	 * Method that makes the JFrm appear on the screen.
	 * @param d the JFrm dimension 
	 * @return the jfrm's y position
	 */
	
	public static int getJFrmYPos(Dimension d) {
		
		double heightRatio = heightRatio(d);
		
		return (int) (heightRatio*CURRENT_SCREEN.getHeight());
	}
	
	/**
	 * Finds the x position ratio according to the initial frame.
	 * @param d the game model's dimension who's xPos ratio is calculated.
	 * @return the ratio of the xPos to the initial frame.
	 */
	
	private static double getXRatio(Dimension d) {
		return d.getWidth()/INIT_FRAME.getWidth();
	}
	
	/**
	 * Finds the y position ratio according to the initial frame.
	 * @param d the game model's dimension who's yPos ratio is calculated.
	 * @return the ratio of the yPos to the initial frame.
	 */
	
	private static double getYRatio(Dimension d) {
		return d.getHeight()/INIT_FRAME.getHeight();
	}
	
	/**
	 * Gets the new x position of the game model according to the current screen size of the user.
	 * @param d the game model's dimension
	 * @return the new xPos of the game model
	 */
	
	public static int getXPos(Dimension d) {
		
		double xRatio = getXRatio(d);
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (xRatio*getScaledWidth(INIT_FRAME));} else return (int) (d.getWidth()* SCALE_1080_BELOW);
	}
	
	/**
	 * Gets the new y position of the game model according to the current screen size of the user.
	 * @param d the game model's dimension
	 * @return the new yPos of the game model
	 */
	
	public static int getYPos(Dimension d) {
		
		double yRatio = getYRatio(d);
		
		if(CURRENT_SCREEN.getWidth()>INIT_SCREEN.getWidth()&&CURRENT_SCREEN.getHeight()>INIT_SCREEN.getHeight()) {
		return (int) (yRatio*getScaledHeight(INIT_FRAME));} else return (int) (d.getHeight()* SCALE_1080_BELOW);
	}

}
