package hitGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * 游戏主界面
 *
 */
@SuppressWarnings("serial")
public class hitGameJFrame extends JFrame {

	private ArrayTipleGrid webSite;// ArrayTipleGrid对象
	private Container c;// 窗口容器
	private JPanel jt;// 功能展示面板
	private GridLayout grid = new GridLayout(7, 7);// 网格布局
	private JPanel panel0 = new JPanel();// 网格展示面板
	private int guessNum = 0;// 猜测次数
	private JTextArea display;// 打击详情展示面板
	private JButton[][] label = new JButton[7][7];// 7*7按钮

	/**
	 * 构造函数初始化窗体开始界面
	 *
	 */
	public hitGameJFrame() {
		inition();

	}

	/**
	 * 按钮颜色恢复到初始颜色
	 *
	 */
	public void resetButtonColor() {

		for (int i = 0; i < label.length; i++)

			for (int j = 0; j < label[i].length; j++) {
				label[i][j].setEnabled(true);
				if ((i + j) % 2 == 0)
					label[i][j].setBackground(new Color(205, 140, 149));
				else
					label[i][j].setBackground(new Color(193, 205, 193));
				
				
			}

	}

	/**
	 * 具体初始化功能
	 *
	 */

	public void inition() {
		c = getContentPane();

		// 标题设置 (north)
		JLabel b1 = new JLabel("\nWelcome to hitGameplay!!!\n");
		b1.setFont(new java.awt.Font("微软雅黑", 2, 40));
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setBackground(Color.blue);
		c.add(b1, BorderLayout.NORTH);

		// 7*7格子(center)
		panel0.setLayout(grid);
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				char c1 = (char) (65 + i);
				label[i][j] = new JButton(c1 + Integer.toString(j + 1));
				label[i][j].setFont(new java.awt.Font("微软雅黑", 0, 17));
				label[i][j].setBorder(new LineBorder(Color.WHITE));
				if ((i + j) % 2 == 0)
					label[i][j].setBackground(new Color(205, 140, 149));
				else
					label[i][j].setBackground(new Color(193, 205, 193));
				panel0.add(label[i][j]);
				label[i][j].addActionListener(new ActionListener() {
					// 鼠标监听
					public void actionPerformed(ActionEvent e) {
						JButton JB = (JButton) e.getSource();
						String getContent = JB.getText();
						String result = new String(webSite.hitting(getContent));
						guessNum++;
						display.append("\n" + result);
						if (result.equals("miss"))
							JB.setBackground(Color.blue);
						if (result.startsWith("hit"))
							JB.setBackground(Color.red);
						// 每个按钮只能点击一次
						JB.setEnabled(false);
						if (webSite.isStop() || guessNum == 49) {
							display.append("\n" + "你总共的分为:" + webSite.yourPrize(guessNum));
							display.append("\n" + "你总共猜测的次数是:" + guessNum);
							int res = JOptionPane.showConfirmDialog(null, "再来一盘 ?" + "\n" + "你总共的分为:"
									+ webSite.yourPrize(guessNum) + "\n" + "你总共猜测的次数是:" + guessNum, "再来一盘 ?",
									JOptionPane.YES_NO_OPTION);
							if (res == JOptionPane.YES_OPTION) {
								guessNum = 0;
								String[] label = { "Go2.com", "Pets.com", "AskMe.com" };
								webSite = new ArrayTipleGrid(label);
								resetButtonColor();
								display.setText("—————————打击详情展示————————");
								String inputValue = JOptionPane.showInputDialog("Please input your Game Name:");

								display.append("\n" + "Your Name: " + inputValue + "\n");

							} else {
								System.exit(0);
								return;
							}

						}

						

					}
				});

			}
		}

		c.add(panel0, BorderLayout.CENTER);

		// 打击功能详情展示(west)
		display = new JTextArea();
		display.setFont(new java.awt.Font("微软雅黑", 0, 15));
		display.setForeground(Color.blue);
		display.setBorder(BorderFactory.createLineBorder(Color.green, 4));

		display.append("—————————打击详情展示————————");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(display);
		c.add(scrollPane, BorderLayout.WEST);

		// 功能详情展示(east)
		jt = new JPanel();
		Box box = Box.createVerticalBox();

		final JLabel backLabel = new JLabel();
		final JLabel backLabel1 = new JLabel("功能描述：\n");
		backLabel1.setFont(new java.awt.Font("微软雅黑", 1, 25));
		backLabel1.setForeground(Color.blue);
		final JLabel backLabel2 = new JLabel("打中三个网站，以次数最少者优胜 ");
		final JLabel backLabel3 = new JLabel("总分数：(100/打击次数)*9 ");
		backLabel2.setFont(new java.awt.Font("黑体", 2, 15));
		backLabel2.setForeground(Color.BLACK);
		backLabel3.setFont(new java.awt.Font("黑体", 2, 15));
		backLabel3.setForeground(Color.black);
		ImageIcon icon = new ImageIcon("hit.jpg"); // 创建背景图片对象
		backLabel.setIcon(icon); // 令标签组件显示背景图片
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		backLabel.setVerticalTextPosition(JLabel.BOTTOM);
		backLabel.setHorizontalTextPosition(JLabel.CENTER);
		box.add(backLabel, new Integer(Integer.MIN_VALUE));
		box.add(backLabel1);
		box.add(backLabel2);
		box.add(backLabel3);

		jt.add(box);
		c.add(jt, BorderLayout.EAST);

		// 开始游戏按钮(south)
		JButton button1 = new JButton("开始游戏");
		button1.setFont(new java.awt.Font("微软雅黑", 1, 25));
		ImageIcon icon1 = new ImageIcon("game.jpg"); // 创建背景图片对象
		button1.setIcon(icon1); // 令标签组件显示背景图片
		button1.setBounds(0, 0, icon1.getIconWidth(), icon1.getIconHeight());
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] label = { "Go2.com", "Pets.com", "AskMe.com" };
				webSite = new ArrayTipleGrid(label);
				String inputValue = JOptionPane.showInputDialog("Please input your Game Name:");

				display.append("\n" + "Your Name: " + inputValue + "\n");

			}
		});
		button1.setBackground(Color.orange);
		button1.setForeground(Color.RED);

		// 退出游戏按钮(south)
		JButton button2 = new JButton("退出游戏");
		button2.setFont(new java.awt.Font("微软雅黑", 1, 50));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "choose exit ?", "choose exit ?",
						JOptionPane.YES_NO_OPTION);
				if (res == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					return;
				}

			}
		});
		button2.setBackground(Color.orange);
		button2.setForeground(Color.RED);

		FlowLayout flow2 = new FlowLayout();
		flow2.setAlignment(FlowLayout.CENTER);
		flow2.setHgap(30);
		JPanel panel = new JPanel(flow2);
		panel.setName("p1");
		panel.add(button1);
		panel.add(button2);
		c.add(panel, BorderLayout.SOUTH);

		setSize(350, 150);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

}
