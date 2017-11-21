import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AudioPlay {

	public static void main(String[] args) {
		try 
		{
			AudioClip clip = Applet.newAudioClip( new URL("file://d:/lost.wav"));
			clip.play();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}

	}

}
