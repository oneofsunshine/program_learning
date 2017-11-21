package experimentCourse;

import java.awt.Graphics;

import javax.swing.JApplet;

public class HappyFace extends JApplet{

	public void paint(Graphics canvas) {
		canvas.drawOval(0, 0, 200, 200);
		canvas.fillOval(130, 50, 15, 30);
		canvas.fillOval(50, 50, 15, 30);
		canvas.drawArc(50, 100, 100, 60, 180, 180);
		canvas.drawLine(50, 130, 150, 130);
	}

}
