package SinktheTank;

import java.awt.*;
import javax.swing.JButton;
public class JButtonShip extends JButton{
	private boolean clicked = false;

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	

}
