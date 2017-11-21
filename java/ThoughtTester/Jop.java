import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Jop {

	public static void main(String[] args) {
		JFrame sinkFrame = new JFrame();
		sinkFrame.setTitle("Sink the DotCom");// 设置窗体标题
		sinkFrame.setBounds(20, 20, 500, 645);
		sinkFrame.getContentPane().setBackground(new Color(200, 200, 200));
		sinkFrame.setResizable(false);// 禁止调整窗体大小
		sinkFrame.getContentPane().setLayout(null);// 设置空布局
		sinkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sinkFrame.setVisible(true);
		
		JPanel j = new JPanel();
		j.setBounds(20, 200, 300, 200);
		sinkFrame.getContentPane().add(j);
		
		ImageIcon icon = new ImageIcon("D://1.jpg");
		Graphics g;
		
		
		int i = JOptionPane.showConfirmDialog(j, "choose", "set or no", JOptionPane.OK_OPTION );
		
		System.out.println(i);
	}

}
