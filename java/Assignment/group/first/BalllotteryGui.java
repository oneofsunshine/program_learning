package group.first;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BalllotteryGui
{

	private JFrame frame;
	private BallPanel ballPanel = null;
	//界面标签：中奖号码6+1;
	private int[] winningBalls = new int[7];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					BalllotteryGui window = new BalllotteryGui();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BalllotteryGui()
	{
		
		try
		{
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel); //设置当前系统风格
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initialize();
		
	}

	/**
	 * 从中间号码标签获取中奖 号码 6+1
	 */
	public void initializationWinningBalls()
	{
		JLabel label = (JLabel) getComponent(ballPanel, "winNumber");
		String labStr = label.getText();
		for (int i = 0; i < labStr.split(" ").length; i++)
		{
			winningBalls[i] = Integer.parseInt(labStr.split(" ")[i]);
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setTitle("\u6A21\u62DF\u53CC\u8272\u7403\u5F69\u7968");
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 785, 657);
		frame.setSize(882, 554);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//画图面板
		ballPanel = new BallPanel();
		ballPanel.setBackground(new Color(255, 218, 185));
		ballPanel.setBounds(0, 0, 874, 522);
		frame.getContentPane().add(ballPanel);
		frame.addMouseListener(ballPanel);
		ballPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7EA2  \u7403");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(243, 10, 100, 30);
		ballPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 17));
		
		JLabel label = new JLabel("\u84DD  \u7403");
		label.setForeground(Color.BLUE);
		label.setBounds(666, 10, 100, 30);
		ballPanel.add(label);
		label.setFont(new Font("宋体", Font.BOLD, 17));
		
		JButton btnTesx = new JButton("\u5F00  \u5956");
		btnTesx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * 开奖查询
				 * 条件：6+1
				 */
				ControlBall controlBalls = ballPanel.getcBall();
				JTextPane textPane = (JTextPane) getComponent(ballPanel, "textPane");
				
				if (ControlBall.getSelectStatus()[0] != 6)
				{
					textPane.setText("请选满6个 红球！\n");
					return;
				}
				else if (ControlBall.getSelectStatus()[1] == 0)
				{
					textPane.setText("请选择 蓝球！\n");
					return;
				}
				
				initializationWinningBalls(); // 更新中奖号码

				int[] betRedBall = new int[6];     //存放选择的6个红球
				int[] winningRedBall = new int[6];  //红球中奖号码
				int winningBlueBall = winningBalls[6];  //存放选择的1个蓝球
				 //蓝球中奖号码
				int betBlueBall = Integer.parseInt(
						controlBalls.getSelectedBall(7).getNumber());
				//选择的红球号码
				for (int i = 0; i < betRedBall.length; i++)
				{
					int number = Integer.parseInt(controlBalls.getSelectedBall(i+1).getNumber());
					betRedBall[i] = number;
				}
				//中奖的红球的号码
				for (int i = 0; i < winningRedBall.length; i++)
					winningRedBall[i] = winningBalls[i];
				
				BallLottery lottery = new BallLottery();
				lottery.setBetBlueBall(betBlueBall);
				lottery.setBetRedBall(betRedBall);
				lottery.setWinningBlueBall(winningBlueBall);
				lottery.setWinningRedBall(winningRedBall);
				
				textPane.setText(lottery.showResults(lottery.lotteryBetting()));
			}
		});
		btnTesx.setForeground(new Color(0, 0, 0));
		btnTesx.setBackground(new Color(192, 192, 192));
		btnTesx.setBounds(382, 291, 110, 30);
		ballPanel.add(btnTesx);
		btnTesx.setFont(new Font("宋体", Font.BOLD, 17));
		
		JButton clearButton = new JButton("\u6E05\u7A7A\u9009\u62E9");
		clearButton.setForeground(new Color(0, 0, 0));
		clearButton.setBackground(new Color(192, 192, 192));
		clearButton.setName("clearBtn");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 8 ; i++)
				{
					ballPanel.getcBall().clearSelectedBalls();
				}
				
				ballPanel.updateUI();
			}
		});
		clearButton.setBounds(502, 291, 110, 30);
		ballPanel.add(clearButton);
		clearButton.setFont(new Font("宋体", Font.BOLD, 17));
		
		JButton button_1 = new JButton("\u5F00\u5956\u53F7\u7801");
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setBackground(new Color(192, 192, 192));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = JOptionPane.showInputDialog(null,"请输入7个中奖号码，以空格分隔：\n",
						"设置中奖号码",JOptionPane.QUESTION_MESSAGE);
				if (input==null) return; //选择取消 不会产生string对象
				JTextPane textPane = (JTextPane) getComponent(ballPanel, "textPane");
				JLabel label = (JLabel) getComponent(ballPanel, "winNumber");
				
				try
				{
					int len = input.split(" ").length; //分隔长度
					String labStr = "";
					
					//判断长度
					if (len < 7) textPane.setText("输入太短...");
					else if (len > 7) textPane.setText("输入太长...");
					else
					{
						boolean checkRedBall = true;
						boolean checkBlueBall = true;
						for (int i = 0; i < len; i++)
						{
							//判断红球号码合法性
							if ((Integer.parseInt(input.split(" ")[i]) < 1 
									|| Integer.parseInt(input.split(" ")[i])
									> 33)&&i<=5) 
							{
								checkRedBall = false;
								break;
							}
							//判断蓝球号码合法性
							if (i==6 && (Integer.parseInt(input.split(" ")[i]) < 1 
									|| Integer.parseInt(input.split(" ")[i])
									> 16)) checkBlueBall = false;

							labStr += (input.split(" ")[i]+" ");
						}
						if (checkRedBall && checkBlueBall)
							label.setText(labStr);
						else textPane.setText("输入的号码不合法");
					}
					
				} catch (Exception e)
				{
					textPane.setText("输入有误，请重新输入！");
					//label.setText("");
				}
			}
		});
		button_1.setBounds(622, 291, 110, 30);
		ballPanel.add(button_1);
		button_1.setFont(new Font("宋体", Font.BOLD, 17));
		
		JButton button_2 = new JButton("\u5E2E  \u52A9");
		button_2.setForeground(new Color(0, 0, 0));
		button_2.setBackground(new Color(192, 192, 192));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String helpString = "规则说明：从33个红球号码中选出6个，再从16个蓝球号码中选择1个.\n"
						+ "单注选号：【 红球或者蓝球 ->点击(待选球)即可】\n"
						+ "取消选择：【以选择 ->  点击(已选球)即可取消】\n\n"
						+ "中奖号码默认为：【1 2 3 4 5 6 7   (前6个为红球号码，末尾一个为蓝球号码)】\n"
						+ "设置中奖号码：【格式为 6 + 1   (以空格分开)】\n"
						+ "";
				Component component = getComponent(ballPanel, "textPane");
				if (component != null)
				{
					JTextPane textPane = (JTextPane) getComponent(ballPanel, "textPane");
					textPane.setText(helpString);
				}
				
			}
		});
		button_2.setBounds(742, 291, 100, 30);
		ballPanel.add(button_2);
		button_2.setFont(new Font("宋体", Font.BOLD, 17));
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBackground(new Color(255, 235, 205));
		textPane.setBounds(21, 337, 821, 162);
		textPane.setName("textPane");
		ballPanel.add(textPane);
		textPane.setText("\u4E2D\u5956\u8BF4\u660E\uFF1A  \r\n            \u4E00\u7B49\u5956  \u4E2D 6+1\r\n            \u4E8C\u7B49\u5956  \u4E2D 6+0\r\n            \u4E09\u7B49\u5956  \u4E2D 5+1\r\n            \u56DB\u7B49\u5956  \u4E2D 5+0  \u4E2D 4+1\r\n            \u4E94\u7B49\u5956  \u4E2D 4+0  \u4E2D 3+1\r\n            \u516D\u7B49\u5956  \u4E2D 2+1  \u4E2D 0+1  \u4E2D 1+1");
		textPane.setFont(new Font("宋体", Font.BOLD, 16));
		
		JLabel label_1 = new JLabel("\u5DF2   \u9009");
		label_1.setBounds(21, 238, 83, 23);
		ballPanel.add(label_1);
		label_1.setFont(new Font("宋体", Font.BOLD, 17));
		
		JLabel label_2 = new JLabel("1 2 3 4 5 6 7");
		label_2.setForeground(new Color(255, 0, 204));
		label_2.setName("winNumber");
		label_2.setFont(new Font("宋体", Font.BOLD, 21));
		label_2.setBounds(107, 290, 265, 30);
		ballPanel.add(label_2);
		
		JLabel label_3 = new JLabel("\u5F00\u5956\u53F7\u7801");
		label_3.setFont(new Font("宋体", Font.BOLD, 17));
		label_3.setBounds(21, 291, 90, 30);
		ballPanel.add(label_3);
        
	}
	
	/**
	 * 获取JPanel上的组件
	 * @param jp  JPanel对象
	 * @param componentName  组件变量名称
	 * @return
	 */
	public Component getComponent(JPanel jp, String componentName)
	{
		Component component = null;
		for (int i = 0; i < jp.getComponentCount(); i++)
		{
			if (jp.getComponent(i).getName() == componentName)
			{
				component = jp.getComponent(i);
			}
		}
		return component;
	}
}
