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
		
		createSoundTrack(invaderKilled, INVADER_KILLED, -20.0f);
		
	}
	
	public static void playerKilled() {
		
		createSoundTrack(playerKilled, PLAYER_DIED, -10.0f);
		
	}
	
	public static void playerShot() {
		
		createSoundTrack(playerShot, PLAYER_SHOT, -20.0f);
		
	}
	
	public static void theme() {
		
		createSoundTrack(theme, THEME, -10.0f);
	}
	
	public static void stopAudio() {
		
		theme.stop();
		
	}
	
	public static void boss() {

		createSoundTrack(boss, BOSS, -10.0f);
		
	}
	
	/**
	 * Creates the sound effect clips.
	 * @param clip the clip to be made
	 * @param url the url of the sound file
	 * @param decibels the decibels that you want to raise the volume by. Negative decibel = reduce volume.
	 */
	private static void createSoundTrack(Clip clip, String url, float decibels) {
		
		try{AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(decibels); // Set volume to decibels.
		clip.start();}catch(Exception e) {e.printStackTrace();}
		
	}
	
}
