import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 * Class where the sound effects were created.
 * @author programmingLuis
 * I did not create these sound effects, but downloaded them from the Internet.
 */

public class SoundEffects {

	public static boolean playBossMusic = true;
	
	private static final String INVADER_KILLED = "src\\Resource\\invaderkilled.wav";  
	private static final String PLAYER_DIED = "src\\Resource\\explosion.wav";  
	private static final String PLAYER_SHOT = "src\\Resource\\shoot.wav";  
	private static final String THEME = "src\\Resource\\spaceinvaders1.wav";  
	private static final String BOSS = "src\\Resource\\ufo_lowpitch.wav";  
	
	private static Clip invaderKilled;
	private static Clip playerKilled;
	private static Clip playerShot;
	private static Clip theme;
	private static Clip boss;
	
	public static void invaderKilled() {
	
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(INVADER_KILLED).getAbsoluteFile());
		invaderKilled = AudioSystem.getClip();
		invaderKilled.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) invaderKilled.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
		invaderKilled.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void playerKilled() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PLAYER_DIED).getAbsoluteFile());
		playerKilled = AudioSystem.getClip();
		playerKilled.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) playerKilled.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		playerKilled.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void playerShot() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PLAYER_SHOT).getAbsoluteFile());
		playerShot = AudioSystem.getClip();
		playerShot.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) playerShot.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); // Reduce volume by 20 decibels.
		playerShot.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void theme() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(THEME).getAbsoluteFile());
		theme = AudioSystem.getClip();
		theme.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) theme.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		theme.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void stopAudio() {
		
		theme.stop();
		
	}
	
	public static void boss() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(BOSS).getAbsoluteFile());
		boss = AudioSystem.getClip();
		boss.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) boss.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		boss.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
}
