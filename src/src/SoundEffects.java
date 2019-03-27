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
	
	private static final String INVADER_KILLED = "/Resource/invaderkilled.wav";  
	private static final String PLAYER_DIED = "/Resource/explosion.wav";  
	private static final String PLAYER_SHOT = "/Resource/shoot.wav";  
	private static final String THEME = "/Resource/spaceinvaders1.wav";  
	private static final String BOSS = "/Resource/ufo_lowpitch.wav";  
	
	private static Clip invaderKilled;
	private static Clip playerKilled;
	private static Clip playerShot;
	private static Clip theme;
	private static Clip boss;
	
	public static void invaderKilled() {
		
		invaderKilled = createSoundTrack(invaderKilled, INVADER_KILLED, -20.0f);
		invaderKilled.start();
	}
	
	public static void playerKilled() {
		
		playerKilled = createSoundTrack(playerKilled, PLAYER_DIED, -10.0f);
		playerKilled.start();
	}
	
	public static void playerShot() {
		
		playerShot = createSoundTrack(playerShot, PLAYER_SHOT, -20.0f);
		playerShot.start();
		
	}
	
	public static void theme() {
		
		theme = createSoundTrack(theme, THEME, -10.0f);
		theme.start();
	}
	
	public static void stopAudio() {
		
		theme.stop();
		
	}
	
	public static void boss() {

		boss = createSoundTrack(boss, BOSS, -10.0f);
		boss.start();
	}
	
	/**
	 * Makes the sound track.
	 * @param clip the clip that will be made into sound effects
	 * @param url where the sound file is stored.
	 * @param decibels what you want to set the volume too. Negative = reduced volume.
	 * @return the new and improved clip.
	 */
	private static Clip createSoundTrack(Clip clip, String url, float decibels) {
		
		try{
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(
				ApplicationMain.class.getResource(url)));
		FloatControl gainControl = 
		(FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(decibels); // Set volume to decibels.
		}catch(Exception e) {e.printStackTrace();}
		
		return clip;
		
	}
	
}
