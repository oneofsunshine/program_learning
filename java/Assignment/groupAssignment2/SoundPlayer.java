package groupAssignment2;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class SoundPlayer {
	private String fileName = null;

	public SoundPlayer(String fileName) {
		this.fileName = fileName;
	}

	public void play() throws Exception
	{
		File file = new File(fileName);

		AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		AudioFormat format = stream.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
		
		byte[] buf = new byte[160 * 1024];// 文件大小;
		
		line.open();
		line.start();
		
		int nbyte = 0;
		
		while (nbyte != -1) 
		{
			nbyte = stream.read(buf, 0, buf.length);
			
			if (nbyte >= 0)
				line.write(buf, 0, nbyte);
		}
		
		line.drain();
		line.close();
		}
}
