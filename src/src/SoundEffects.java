import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundEffects {

	private static final String INVADER_KILLED = "src\\Resource\\invaderkilled.wav";  
	private static final String PLAYER_DIED = "src\\Resource\\explosion.wav";  
	private static final String PLAYER_SHOT = "src\\Resource\\shoot.wav";  
	
	public static void invaderKilled() {
	
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(INVADER_KILLED).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
		clip.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void playerKilled() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PLAYER_DIED).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
		clip.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
	public static void playerShot() {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PLAYER_SHOT).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
		clip.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
}
