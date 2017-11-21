
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.sampled.AudioSystem;

public class ST {
	public static void main(String[] args) {
		ST sound = new ST();
		sound.setMusic("nor.mid");
		if (sound.isplay())
			sound.mystop();
		sound.loadSound();
		// btnmuc.setLabel("音乐关");
		// nor.setEnabled(true);
		// qin.setEnabled(false);
		// guang.setEnabled(true);
		// eye.setEnabled(true);
		// po.setEnabled(true);
		// panel.requestFocus();break;

	}

	String path = new String("src/");
	String file = new String("nor.mid");
	Sequence seq;
	Sequencer midi;
	boolean sign;

	void loadSound() {
		try {
			System.out.println(path + file);
			File f = new File(path + file);
			seq = MidiSystem.getSequence(f);

			midi = MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sign = true;
	}

	void mystop() 
	{
		midi.stop();
		midi.close();
		sign = false;
	}

	boolean isplay() 
	{
		return sign;
	}

	void setMusic(String e) 
	{
		file = e;
	}
}
