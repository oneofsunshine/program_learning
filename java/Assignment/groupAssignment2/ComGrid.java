package groupAssignment2;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ComGrid {
	private JLabel[][] texts;// 坐标网格
	Font font = new Font("Number", Font.LAYOUT_LEFT_TO_RIGHT, 20);
	
	ComGrid(JPanel jp)
	{

		// 创建字母坐标;
		texts = new JLabel[8][8];// 创建文本框二维数组
		char loa;
		for (int i = 0; i < 7; i++)
		{
			texts[0][i] = new JLabel();
			texts[0][i].setFont(new Font("Character", Font.PLAIN, 20));
			texts[0][i].setHorizontalAlignment(SwingConstants.CENTER);
			loa = (char) ('A' + i);
			texts[0][i].setText(Character.toString(loa));
			texts[0][i].setBounds(0, 50 * i + 10, 50, 50);
			texts[0][i].setOpaque(true);
			texts[0][i].setBackground(new Color(250, 250, 250));
			texts[0][i].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(245, 222, 179)));
			texts[0][i].setEnabled(false);
			jp.add(texts[0][i]);
		}

		for (int i = 1; i < 8; i++)
		{
			// 创建数字坐标;
			texts[7][i] = new JLabel();
			texts[7][i].setFont(font);
			texts[7][i].setHorizontalAlignment(SwingConstants.CENTER);
			texts[7][i].setText(Integer.toString(i - 1));
			texts[7][i].setBounds(50 * i, 360, 50, 50);
			texts[7][i].setOpaque(true);
			texts[7][i].setBackground(new Color(250, 250, 250));
			texts[7][i].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(245, 222, 179)));
			texts[7][i].setEnabled(false);
			jp.add(texts[7][i]);
		}

		for (int i = 1; i < 8; i++)
		{
			// 创建网站所在的7*7网格，并将其添加到面板中;
			for (int j = 0; j < 7; j++) {
				texts[i][j] = new JLabel();// 创建标签
				texts[i][j].setFont(font);
				texts[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				texts[i][j].setText("");
				texts[i][j].setBounds(50 * i, 50 * j + 10, 50, 50);// 设置方块的大小位置
				texts[i][j].setOpaque(true);
				texts[i][j].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, new Color(245, 222, 179)));// 设置方块边框颜色
				texts[i][j].setBackground(Color.white);
				jp.add(texts[i][j]);// 将创建的文本框放在画板中;
			}
		}
	}
	
	public void createDotCom()
	{
		String url1 = new String("Go2.com");
		String url2 = new String("Pets.com");
		String url3 = new String("AskMe.com");
		
	}
	
	public ArrayList<String> randomGrid()
	{
		ArrayList<String> ran = new ArrayList<>();
		String r;
		int character, number, dir;
		for(int i = 0; i < 3; i++)
		{
			character = (int)(Math.random() * 7);
			number = (int)(Math.random() * 7);
			dir = (int)(Math.random() * 4);
			r = (char)('A' + character) + Integer.toString(number);
			ran.add(r);
		}
		return ran;
	}
	
	public void changeColor(int i, int j)
	{
		texts[i][j].setBackground(new Color(255, 163, 240));
	}
	
	public void changeText(int i, int j)
	{
		texts[i][j].setText("l");
	}
	
	public String getText()
	{
		return "";
	}
	
}
