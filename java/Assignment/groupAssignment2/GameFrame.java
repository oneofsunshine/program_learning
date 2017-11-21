package groupAssignment2;

import java.awt.Color;
import java.awt.Font;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {
	private GameOperation go;
	private JFrame sinkFrame;// 代表游戏框架;
	private JPanel scoresPane;// 得分面板
	private JLabel textTimes;// 已用次数标签
	private JLabel textScores;// 获得分数标签
	private JPanel mainPane;// 主面板，放置坐标网格
	private JLabel[][] texts;// 坐标网格
	private JPanel selectPane;// 已选坐标面板
	private JLabel textSelect1;// 已选（前16）个坐标标签
	private JLabel textSelect2;// 已选（后16）个坐标标签
	private JLabel textSelectCorrect;// 正确的坐标标签
	private String choice;// 用来代表用户选择的坐标
	private int x,y;// 代表鼠标的横纵坐标
	private String[] url;
	private Color bgColor = new Color(250, 250, 250);// 设置背景颜色
	Font font = new Font("Chinese", Font.BOLD, 16);// 设置字体类型和大小
	Font font2 = new Font("Number", Font.LAYOUT_LEFT_TO_RIGHT, 20);
	
	public GameFrame() {
		super();
		
		go = new GameOperation();
		url = new String[3];
		createDotCom();
		
		int setOrNot = JOptionPane.showConfirmDialog(mainPane, "自定义正确坐标？", "开始游戏", JOptionPane.OK_OPTION );
		
		if(setOrNot == 0)
		{
			go.clearCorrectGrid();
			int time = 0;
			while(time < 3)
			{
				String input = JOptionPane.showInputDialog(null,
						"请输入三个坐标作为dotcom的坐标\n（格式：A1                  范围：A1-G6\n以空格隔开/取每词前两个字母为坐标）：\n",
						"设置正确坐标",JOptionPane.QUESTION_MESSAGE);
				if (input==null) break;
				try
				{
					int len = input.split(" ").length; //分隔长度
					//判断长度
					if (len < 3)
						JOptionPane.showMessageDialog(null,"输入太短...");
					else if (len > 3)
						JOptionPane.showMessageDialog(null,"输入太长...");
					else
					{
						if(go.setMakeSense(input))
						{
							if(!go.setBefore(input))
							{
								go.setCorrectGrid(input);
								time++;
							}
							else
								JOptionPane.showMessageDialog(null,"set before！");
						}
						else
							JOptionPane.showMessageDialog(null,"坐标格式不规范,请重新输入！");
					}
				}
				catch (NullPointerException e)
				{
					System.out.println(e.toString());
					JOptionPane.showMessageDialog(null,"游戏取消！");
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
					JOptionPane.showMessageDialog(null,"输入不规范,请重新输入！");
				}
			}
			if(time < 3)
			{
				JOptionPane.showMessageDialog(null,"设置坐标中止，随机生成坐标！");
				go = new GameOperation();
			}
		}
		
		sinkFrame = new JFrame();
		sinkFrame.setTitle("Sink the DotCom");// 设置窗体标题
		sinkFrame.setBounds(getWidth() + 400, getHeight() + 50, 500, 645);
		sinkFrame.getContentPane().setBackground(bgColor);
		sinkFrame.setResizable(false);// 禁止调整窗体大小
		sinkFrame.getContentPane().setLayout(null);// 设置空布局
		sinkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sinkFrame.setVisible(true);

		scoresPane = new JPanel();// 创建分数显示面板
		scoresPane.setBackground(new Color(245, 245, 245));// 设置分数显示面板的背景色
		scoresPane.setBounds(40, 20, 420, 40);// 设置分数显示面板的位置和大小
		scoresPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(188, 143, 143)));// 设置得分面板的边框
		scoresPane.setLayout(null);// 设置面板空布局

		JLabel labelTimes = new JLabel("已用次数:");// 次数标签
		labelTimes.setFont(font);// 设置字体类型和大小
		labelTimes.setBounds(30, 5, 80, 30);// 设置次数标签的位置尺寸
		scoresPane.add(labelTimes);// 将次数标签添加到得分容器中

		textTimes = new JLabel(String.valueOf(go.getTime()));// 次数标签
		textTimes.setBounds(110, 5, 30, 30);
		textTimes.setFont(font2);
		scoresPane.add(textTimes);// 将次数标签添加到分数面板中

		JLabel labelScores = new JLabel("分 数:");
		labelScores.setFont(font);// 设置字体类型和大小
		labelScores.setBounds(260, 5, 50, 30);
		scoresPane.add(labelScores);

		textScores = new JLabel(String.valueOf(go.getScore()));
		textScores.setFont(font2);
		textScores.setBounds(310, 5, 150, 30);
		scoresPane.add(textScores);
		sinkFrame.getContentPane().add(scoresPane);

		mainPane = new JPanel();// 创建游戏主面板
		mainPane.setBounds(20, 70, 460, 460);// 设置主面板位置尺寸
		mainPane.setBackground(bgColor);
		mainPane.setLayout(null);// 设置空布局

		createComGrid(mainPane);

		JLabel tips = new JLabel();
		tips.setHorizontalAlignment(JLabel.CENTER);
		tips.setText("<html> Tips：表格中有3个网址,分别放在三个坐标中 <br> 点击坐标图，猜测单词位置，你最多有32次机会！ <html>");
		tips.setFont(font);
		tips.setBounds(0, 410, 440, 40);
		mainPane.add(tips);
		
		mainPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{ // 鼠标完成点击事件
				if (e.getButton() == MouseEvent.BUTTON1) 
				{
					x = e.getX(); // 得到鼠标x坐标
					y = e.getY(); // 得到鼠标y坐标
					if (go.judgeSelect(x, y))
					{
						y = go.selectCharacter(y);
						x = go.selectNumber(x);
						changeColor(x, y);
						choice = (char) ('A' + y) + Integer.toString(x - 1);
						try
						{
							if(go.isSelected(choice))
							{
								go.soundSelect();
								System.out.println("select");
							} // 已选过的声音;
							else
							{
								if(go.gameOver() < 0)
								{
									go.soundLost();// game over - lost;
									System.out.println("\t------------------------------lost-----------------------");
									JOptionPane.showMessageDialog(null,"游戏结束，你输了");
									System.exit(0);
								}
								else
								{
									if(go.isHit(choice))
									{
										if(go.isSink())
										{
											if(go.gameOver() > 0)
											{
												changeText(x, y,choice);
												go.soundWin();// game over - win;
												System.out.println("\t------------------------------win-----------------------");
												JOptionPane.showMessageDialog(null,"游戏结束，你赢了");
												System.exit(0);
											}
											else
											{
												go.soundSink();// sink sound;
												changeText(x, y,choice);
												System.out.println("change sink");
											}
										}
										else
										{
											go.soundHit();// hit sound;
											changeText(x, y, choice);
											System.out.println("change hit");
										}
									}
									else
									{
										go.soundMiss();// miss sound;
										System.out.println("miss");
									}
								}
							}
						}
						catch (Exception e1) {
							System.out.println(e1.getMessage());
						}
						
						if(!go.isSelected(choice))
						{
							go.addChoice(choice);
							go.setChoiceCorrectList(choice);
						}
						
						System.out.println("Select Grid: " + go.getChoice());
						settextSelect(go.getChoice());
						setTextSelectCorrect();
						setTextTimes();
						setTextScores();
						
					}
					repaint();
				}
			}
		});

		sinkFrame.getContentPane().add(mainPane);

		selectPane = new JPanel();// 创建显示主面板
		selectPane.setBounds(20, 530, 460, 80);// 设置主面板位置尺寸
		selectPane.setBackground(bgColor);
		selectPane.setLayout(null);// 设置空布局
		selectPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(188, 143, 143)));

		JLabel labelSelect = new JLabel("已选:");// 标签
		labelSelect.setFont(font);// 设置字体类型和大小
		labelSelect.setBounds(10, 5, 40, 30);// 设置标签的位置尺寸
		selectPane.add(labelSelect);// 将标签添加到得分容器中

		textSelect1 = new JLabel();// 标签
		textSelect1.setFont(new Font("Character", Font.PLAIN, 16));
		textSelect1.setBounds(55, 5, 400, 30);
		selectPane.add(textSelect1);// 将标签添加到面板中
		
		textSelect2 = new JLabel();// 标签
		textSelect2.setFont(new Font("Character", Font.PLAIN, 16));
		textSelect2.setBounds(55, 27, 400, 30);
		selectPane.add(textSelect2);// 将标签添加到面板中
		
		JLabel labelSelectCorrect = new JLabel("正确:");// 标签
		labelSelectCorrect.setFont(font);// 设置字体类型和大小
		labelSelectCorrect.setBounds(10, 45, 40, 30);// 设置标签的位置尺寸
		selectPane.add(labelSelectCorrect);// 将标签添加到得分容器中

		textSelectCorrect = new JLabel();// 标签
		textSelectCorrect.setFont(new Font("Character", Font.PLAIN, 16));
		textSelectCorrect.setBounds(55, 45, 390, 30);
		selectPane.add(textSelectCorrect);// 将标签添加到面板中
		
		sinkFrame.getContentPane().add(selectPane);
	}
	
	private void createComGrid(JPanel jp)
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
				texts[i][j].setFont(new Font("Chinese", Font.BOLD, 18));
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
	
	private void createDotCom()
	{
		url[0] = new String("Go2.com");
		url[1] = new String("Pets.com");
		url[2] = new String("AskMe.com");
	}
	
	private void changeColor(int i, int j)
	{
		texts[i][j].setBackground(new Color(255, 163, 240));
	}
	
	private void changeText(int i, int j, String s)
	{
		texts[i][j].setText(getText(s));
	}
	
	/*
	 * 确定击沉的做表格的内容，
	 * */
	public String getText(String s)
	{
		int com = go.getCorrectNum(s) / 3;
		int part = go.getCorrectNum(s) - 3 * com;
		String dotCom = "";
		if(part == 0)
		{
			for(int i = 0; i < url[com].length() / 3; i++)
				dotCom += url[com].charAt(i);
		}
		else if(part == 1)
		{
			for(int i = url[com].length() / 3; i < 2 * url[com].length() / 3; i++)
				dotCom += url[com].charAt(i);
		}
		else if(part == 2)
		{
			for(int i = 2 * url[com].length() / 3; i < url[com].length(); i++)
				dotCom += url[com].charAt(i);
		}

		System.out.println("dot: "+ dotCom + "\tpart: " + part + "\tcom: " + com);
		return dotCom;
	}
	
	private void setTextTimes()
	{
		go.setTime();
		textTimes.setText(String.valueOf(go.getTime()));
	}
	
	private void setTextScores()
	{
		go.setScore();
		textScores.setText(String.valueOf(go.getScore()));
	}
	
	private void settextSelect(ArrayList<String> sgl)
	{
		String s1 = "";
		String s2 = "";
		if(sgl.size() < 16)
		{
			for(int i = 0; i < sgl.size(); i++)
				s1 += sgl.get(i) + " ";
			textSelect1.setText(s1);
		}
		else if(sgl.size() >= 32)
		{
			for(int i = 0; i < 16; i++)
				s1 += sgl.get(i) + " ";
			textSelect1.setText(s1);
			for(int i = 16; i < 32; i++)
				s2 += sgl.get(i) + " ";
			textSelect2.setText(s2);
		}
		else
		{
			for(int i = 0; i < 16; i++)
				s1 += sgl.get(i) + " ";
			textSelect1.setText(s1);
			for(int i = 16; i < sgl.size(); i++)
				s2 += sgl.get(i) + " ";
			textSelect2.setText(s2);
		}
	}

	private void setTextSelectCorrect()
	{
		textSelectCorrect.setText(go.getChoiceCorrectList());
		System.out.println(go.getCorrectGrid() + "\n");
	}
}