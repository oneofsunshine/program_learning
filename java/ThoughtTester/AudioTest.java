import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioTest {

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException {
		/*
		 * 1读取流
		 * 2处理流
		 * 3剪辑
		 * 4播放
		 * */
		
		int totalFramesRead = 0;
		File fileln = new File("src/nor.mid");
		
		System.out.println(fileln.getPath());
		
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileln);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			int numBytes = 1024 * bytesPerFrame;
			byte[] audioBytes = new byte[numBytes];

				int numBytesRead = 0;
				int numFramesRead = 0;
				while ((numBytesRead = audioInputStream.read(audioBytes)) != -1) {
					numFramesRead = numBytesRead / bytesPerFrame;
					totalFramesRead += numFramesRead;
				}
		
//		DataLine.Info info = new DataLine.Info(targetdataline, format);
		
	}

}
	
