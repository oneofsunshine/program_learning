package audio;

import sun.audio.*; //import the sun.audio package

import java.applet.AudioClip;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.spi.AudioFileReader;

public class ac {

	public static void main(String[] args) {
		try {
			InputStream in =new FileInputStream(new File("D:/groupAssignment2/select.wav"));
			AudioInputStream cas = AudioSystem.getAudioInputStream(new File("D:/groupAssignment2/select.mid"));
			AudioClip ac = new 
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
