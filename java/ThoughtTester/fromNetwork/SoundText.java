import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

import java.applet.Applet;
import java.io.File;

import javax.activity.InvalidActivityException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

class Sound extends Applet
{
	String path = new String("D:/groupAssignment2/");
	String file = new String("select.mid");
	Sequencer midi;
	boolean sign;

	void loadSound() throws MidiUnavailableException, InvalidMidiDataException, IOException 
	{

			midi = MidiSystem.getSequencer();
			midi.setSequence(MidiSystem.getSequence(new File(path + file)));
			midi.open();
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		
		sign = true;
	}

	void mystop() {
		midi.stop();
		midi.close();
		sign = false;
	}

	boolean isplay() {
		return sign;
	}

	void setMusic(String e) {
		file = e;
	}
}
public class SoundText {

	public static void main(String[] args) throws InvalidActivityException, MidiUnavailableException {
		try {
			new Sound().loadSound();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
			System.out.println();
	}

}
