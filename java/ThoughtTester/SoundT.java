import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundT {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		int totalFramesRead = 0;
		File fileIn = new File("D://groupAssignment2/select.mid");

		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileIn);
		/*int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
		int numBytes = 1024 * bytesPerFrame;
		byte[] audioBytes = new byte[numBytes];

		int numBytesRead = 0;
		int numFramesRead = 0;
		while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
			numFramesRead = numBytesRead / bytesPerFrame;
			totalFramesRead += numFramesRead;
		}*/
		
		AudioFormat format = audioInputStream.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		TargetDataLine line = (TargetDataLine) AudioSystem.getLine(info);
		line.open(format);
		Clip c = (Clip) AudioSystem.getLine(info);
		c.open(audioInputStream);
		c.start();
	}
}
