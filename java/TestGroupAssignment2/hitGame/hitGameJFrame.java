package hitGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * ��Ϸ������
 *
 */
@SuppressWarnings("serial")
public class hitGameJFrame extends JFrame {

	private ArrayTipleGrid webSite;// ArrayTipleGrid����
	private Container c;// ��������
	private JPanel jt;// ����չʾ���
	private GridLayout grid = new GridLayout(7, 7);// ���񲼾�
	private JPanel panel0 = new JPanel();// ����չʾ���
	private int guessNum = 0;// �²����
	private JTextArea display;// �������չʾ���
	private JButton[][] label = new JButton[7][7];// 7*7��ť

	/**
	 * ���캯����ʼ�����忪ʼ����
	 *
	 */
	public hitGameJFrame() {
		inition();

	}

	/**
	 * ��ť��ɫ�ָ�����ʼ��ɫ
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
	 * �����ʼ������
	 *
	 */

	public void inition() {
		c = getContentPane();

		// �������� (north)
		JLabel b1 = new JLabel("\nWelcome to hitGameplay!!!\n");
		b1.setFont(new java.awt.Font("΢���ź�", 2, 40));
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setBackground(Color.blue);
		c.add(b1, BorderLayout.NORTH);

		// 7*7����(center)
		panel0.setLayout(grid);
		for (int i = 0; i < label.length; i++) {
			for (int j = 0; j < label[i].length; j++) {
				char c1 = (char) (65 + i);
				label[i][j] = new JButton(c1 + Integer.toString(j + 1));
				label[i][j].setFont(new java.awt.Font("΢���ź�", 0, 17));
				label[i][j].setBorder(new LineBorder(Color.WHITE));
				if ((i + j) % 2 == 0)
					label[i][j].setBackground(new Color(205, 140, 149));
				else
					label[i][j].setBackground(new Color(193, 205, 193));
				panel0.add(label[i][j]);
				label[i][j].addActionListener(new ActionListener() {
					// ������
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
						// ÿ����ťֻ�ܵ��һ��
						JB.setEnabled(false);
						if (webSite.isStop() || guessNum == 49) {
							display.append("\n" + "���ܹ��ķ�Ϊ:" + webSite.yourPrize(guessNum));
							display.append("\n" + "���ܹ��²�Ĵ�����:" + guessNum);
							int res = JOptionPane.showConfirmDialog(null, "����һ�� ?" + "\n" + "���ܹ��ķ�Ϊ:"
									+ webSite.yourPrize(guessNum) + "\n" + "���ܹ��²�Ĵ�����:" + guessNum, "����һ�� ?",
									JOptionPane.YES_NO_OPTION);
							if (res == JOptionPane.YES_OPTION) {
								guessNum = 0;
								String[] label = { "Go2.com", "Pets.com", "AskMe.com" };
								webSite = new ArrayTipleGrid(label);
								resetButtonColor();
								display.setText("�������������������������չʾ����������������");
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

		// �����������չʾ(west)
		display = new JTextArea();
		display.setFont(new java.awt.Font("΢���ź�", 0, 15));
		display.setForeground(Color.blue);
		display.setBorder(BorderFactory.createLineBorder(Color.green, 4));

		display.append("�������������������������չʾ����������������");
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(display);
		c.add(scrollPane, BorderLayout.WEST);

		// ��������չʾ(east)
		jt = new JPanel();
		Box box = Box.createVerticalBox();

		final JLabel backLabel = new JLabel();
		final JLabel backLabel1 = new JLabel("����������\n");
		backLabel1.setFont(new java.awt.Font("΢���ź�", 1, 25));
		backLabel1.setForeground(Color.blue);
		final JLabel backLabel2 = new JLabel("����������վ���Դ�����������ʤ ");
		final JLabel backLabel3 = new JLabel("�ܷ�����(100/�������)*9 ");
		backLabel2.setFont(new java.awt.Font("����", 2, 15));
		backLabel2.setForeground(Color.BLACK);
		backLabel3.setFont(new java.awt.Font("����", 2, 15));
		backLabel3.setForeground(Color.black);
		ImageIcon icon = new ImageIcon("hit.jpg"); // ��������ͼƬ����
		backLabel.setIcon(icon); // ���ǩ�����ʾ����ͼƬ
		backLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		backLabel.setVerticalTextPosition(JLabel.BOTTOM);
		backLabel.setHorizontalTextPosition(JLabel.CENTER);
		box.add(backLabel, new Integer(Integer.MIN_VALUE));
		box.add(backLabel1);
		box.add(backLabel2);
		box.add(backLabel3);

		jt.add(box);
		c.add(jt, BorderLayout.EAST);

		// ��ʼ��Ϸ��ť(south)
		JButton button1 = new JButton("��ʼ��Ϸ");
		button1.setFont(new java.awt.Font("΢���ź�", 1, 25));
		ImageIcon icon1 = new ImageIcon("game.jpg"); // ��������ͼƬ����
		button1.setIcon(icon1); // ���ǩ�����ʾ����ͼƬ
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

		// �˳���Ϸ��ť(south)
		JButton button2 = new JButton("�˳���Ϸ");
		button2.setFont(new java.awt.Font("΢���ź�", 1, 50));
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
