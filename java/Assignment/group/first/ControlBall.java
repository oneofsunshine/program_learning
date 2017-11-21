package group.first;

import java.awt.Color;
import java.util.ArrayList;

public class ControlBall
{
	private ArrayList<Ball> redBalls = new ArrayList<>(); // 红球
	private ArrayList<Ball> blueBalls = new ArrayList<>(); // 蓝球
	private ArrayList<Ball> selectedBalls = new ArrayList<>();// 已选球
	private static int[] selectStatus = { 0, 0 }; // 当前红球和蓝球的个数
	
	private static final int RADIUS = 20; // 球的半径
	private static final int GAP = 26; // 球之间的间隔
	private static final int GAPY = 70; // 上边距
	private static final int[] LINEY =
	{ GAPY, GAPY + GAP + RADIUS, GAPY + GAP * 2 + RADIUS * 2, GAPY + GAP * 3 + RADIUS * 5 }; // 四行球的
																								// y坐标

	private Ball ball = null;

	public ControlBall()
	{
		/**
		 * 分别初始化球对象 添加34个红球，第一个不用 添加16个蓝球，第一个不用 添加6个已选，第一个不用
		 */
		for (int i = 0; i <= 33; i++)
			redBalls.add(new Ball());
		for (int i = 0; i <= 16; i++)
			blueBalls.add(new Ball());
		for (int i = 0; i <= 7; i++)
			selectedBalls.add(new Ball());

		/**
		 * 分别设置所有球的 坐标 红球、蓝球：3行 选中球：1行
		 */
		int x = 0;
		for (int i = 1; i <= 3; i++)
		{
			/**
			 * 画红球,每行都是11个
			 */
			x = 0; // 左边距= x + X_CENTER + GAP;
			for (int j = 1; j <= 11; j++)
			{
				x = x + RADIUS + GAP;// 画红球：x增量

				// 获取第几个球？
				int index = (i - 1) * 11 + j;
				ball = redBalls.get(index);
				ball.setColor(Color.RED);
				ball.setBallType("redBall");

				if (index < 10)
					ball.setNumber("0" + index);
				else
					ball.setNumber("" + index);

				ball.setX(x);
				ball.setY(LINEY[i - 1]);
				redBalls.set(index, ball);
			}

			/**
			 * 画蓝球,三行对应的个数：5,5,6
			 */
			x += RADIUS + GAP; // 红球和篮球的间隔增量
			for (int j = 1; j <= 6; j++)
			{
				if (i != 3 && j == 6)
					continue; // 第6列非第3行忽略
				x = x + RADIUS + GAP; // 坐标增量

				// 获取第几个球？
				int index = (i - 1) * 5 + j;
				ball = blueBalls.get(index);
				ball.setColor(Color.blue);
				ball.setBallType("blueBall");

				if (index < 10)
					ball.setNumber("0" + index);
				else
					ball.setNumber("" + index);

				ball.setX(x);
				ball.setY(LINEY[i - 1]);
				blueBalls.set(index, ball);
			}
		}
		/**
		 * 画灰球
		 */
		x = RADIUS * 2 + GAP;
		for (int j = 1; j <= 7; j++)
		{

			x = x + (RADIUS + GAP * 2); // 坐标增量

			if (j == 7)
				x += (RADIUS + 6); // 红蓝球分隔
			// 获取第几个球？
			int index = j;
			ball = selectedBalls.get(index);
			ball.setColor(Color.LIGHT_GRAY);
			ball.setBallType("grayBall");

			ball.setX(x);
			ball.setY(LINEY[3]);
			selectedBalls.set(index, ball);
		}
	}

	public static int[] getSelectStatus()
	{
		return selectStatus;
	}

	public Ball getRedBall(int index)
	{
		return redBalls.get(index);
	}

	public Ball getBlueBall(int index)
	{
		return blueBalls.get(index);
	}

	public Ball getSelectedBall(int index)
	{
		return selectedBalls.get(index);
	}

	public ArrayList<Ball> getRedBalls()
	{
		return redBalls;
	}

	public ArrayList<Ball> getBlueBalls()
	{
		return blueBalls;
	}

	public ArrayList<Ball> getSelectedBalls()
	{
		return selectedBalls;
	}

	/**
	 * 清空选中的球：初始化 选球信息
	 */
	public void clearSelectedBalls()
	{
		// 模拟单击灰球操作 依次取消
		judgeSelectBall(138,248);
		judgeSelectBall(210,248);
		judgeSelectBall(282,248);
		judgeSelectBall(354,248);
		judgeSelectBall(426,248);
		judgeSelectBall(498,248);
		judgeSelectBall(596,248);
//		selectStatus[0] = 0;
//		selectStatus[1] = 0;
	}

	/**
	 * 冒泡排序时间复杂度最好的情况为O(n),最坏的情况是O(n^2) 基本思想是:两两比较相邻记录的关键字,如果反序则交换
	 * 
	 * @param arr
	 * @param n
	 */
	public void bubbleSort(int arr[], int n)
	{
		for (int i = 0; i < n - 1; ++i)
		{
			for (int j = 0; j < n - i - 1; ++j)
			{
				if (arr[j] > arr[j + 1])
				{
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 只给选中的红球排序，主要解决随机取消红球的问题
	 */
	public void orderSelectRedBall()
	{
		int count = selectStatus[0]; // 统计选中红球个数
		if (count == 0)
			return;
		int[] numbers = new int[count]; // 已选号码数组
		int index = 0; // 已选号码下标

		for (int i = 1; i <= 6; i++)
		{
			if (!selectedBalls.get(i).getNumber().equals(""))
				numbers[index++] = Integer.parseInt(selectedBalls.get(i).getNumber());
		}
		// 抽象为选中的号码排序
		bubbleSort(numbers, count);

		// （间接）为选中的球排序
		for (int i = 1; i <= 6; i++)
		{
			if (i <= count)
			{
				if (numbers[i - 1] < 10)
					selectedBalls.get(i).setNumber("0" + numbers[i - 1]);
				else
					selectedBalls.get(i).setNumber("" + numbers[i - 1]);
				selectedBalls.get(i).setColor(Color.RED);
			} else
			{
				selectedBalls.get(i).setNumber("");
				selectedBalls.get(i).setColor(Color.LIGHT_GRAY);
			}
		}

	}

	/**
	 * 红、蓝球被点击操作：将球加入结果，颜色变也灰色 
	 * 灰球被点击的操作： 清除所点的球
	 * 
	 * @param ball
	 */
	public void modifyBall(Ball ball)
	{
		// 判断灰球
		if (ball.getBallType() == "grayBall"
				&& !(ball.getColor() == Color.lightGray || ball.getColor() == Color.LIGHT_GRAY))
		{
			// 根据 颜色操作
			if (ball.getColor() == Color.red || ball.getColor() == Color.RED)
			{
				int number = Integer.parseInt(ball.getNumber()); // 找到球号
				redBalls.get(number).setColor(Color.red);

				ball.setColor(Color.LIGHT_GRAY);
				ball.setNumber("");
				selectStatus[0]--;
				orderSelectRedBall(); // 排序，保持恒定的顺序放球
			} else if (ball.getColor() == Color.blue || ball.getColor() == Color.BLUE)
			{
				int number = Integer.parseInt(ball.getNumber()); // 找到球号
				blueBalls.get(number).setColor(Color.blue);

				ball.setColor(Color.LIGHT_GRAY);
				ball.setNumber("");
				selectStatus[1]--;
			}
		}

		// 先判断 红球 蓝球 是否选够 6+1
		if (selectStatus[0] >= 6 && selectStatus[1] >= 1)
			return;

		if (ball.getBallType() == "redBall" && selectStatus[0] < 6
				&& (ball.getColor() == Color.red || ball.getColor() == Color.RED))
		{
			ball.setColor(Color.LIGHT_GRAY);
			selectStatus[0] += 1; // 统计球的个数

			// 将球添加结果
			selectedBalls.get(selectStatus[0]).setNumber(ball.getNumber());
			selectedBalls.get(selectStatus[0]).setColor(Color.red);
			orderSelectRedBall(); // 灰排序，保持恒定的顺序放球
		}

		if (ball.getBallType() == "blueBall" && selectStatus[1] == 0
				&& (ball.getColor() == Color.blue || ball.getColor() == Color.BLUE))
		{
			ball.setColor(Color.LIGHT_GRAY);

			// 将球添加结果
			// selectedBalls.get(7).setBallType("blueBall");
			selectedBalls.get(7).setColor(Color.blue);
			selectedBalls.get(7).setNumber(ball.getNumber());
			selectStatus[1] = 1;
		}
	}

	/**
	 * 根据 两点坐标距离 （是否小于半径）求出选择的球
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @param ballX
	 * @param ballY
	 * @return
	 */
	public boolean judgeSelectBall(int mouseX, int mouseY)
	{
		boolean tf = false;
		if (mouseY > 300)
			return tf; // mouseY范围
		System.out.printf("mouseX,mouseY (%3d,%3d)\n", mouseX, mouseY);
		int ballX = 0, ballY = 0;
		double distance = 100; // 两点的距离

		/**
		 * 分别扫描红球、蓝球、已选（灰）球 先进行方格定位（定位圆的内切正方形），然后在球具体是否在圆上 记得初始下标为 1
		 */
		for (int i = 1; i <= 33; i++)
		{
			ballX = redBalls.get(i).getX();
			ballY = redBalls.get(i).getY();
			if (isAtSquare(mouseX, mouseY, ballX, ballY))
			{
				distance = getDistance(mouseX, mouseY, ballX, ballY);
				if (distance < 10.0) // 定位到具体的球，修改球的参数
				{
					modifyBall(redBalls.get(i));
					tf = true;
					System.out.println(mouseX + " , " + mouseY + " , " + ballX + " , " + ballY);
					System.out.println("redBall " + redBalls.get(i).getNumber());
				}

			}
		}
		for (int i = 1; i <= 16; i++)
		{
			ballX = blueBalls.get(i).getX();
			ballY = blueBalls.get(i).getY();
			if (isAtSquare(mouseX, mouseY, ballX, ballY))
			{
				distance = getDistance(mouseX, mouseY, ballX, ballY);
				if (distance < 10.0)
				{
					modifyBall(blueBalls.get(i));
					tf = true;
				}
				System.out.println(mouseX + " , " + mouseY + " , " + ballX + " , " + ballY + " ,blue:"
						+ blueBalls.get(i).getNumber());

			}

		}
		for (int i = 1; i <= 7; i++)
		{
			ballX = selectedBalls.get(i).getX();
			ballY = selectedBalls.get(i).getY();
			if (isAtSquare(mouseX, mouseY, ballX, ballY))
			{
				distance = getDistance(mouseX, mouseY, ballX, ballY);
				if (distance < 10.0)
				{
					modifyBall(selectedBalls.get(i));
					tf = true;
				}
				System.out.println(mouseX + " , " + mouseY + " , " + ballX + " , " + ballY + " ,select:"
						+ selectedBalls.get(i).getNumber());
			}
		}
		return tf;
	}

	/**
	 * 根据 两点坐标距离
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @param ballX
	 * @param ballY
	 * @return
	 */
	public double getDistance(int mouseX, int mouseY, int ballX, int ballY)
	{
		return Math.sqrt((mouseX - ballX) * (mouseX - ballX) + (mouseY - ballY) * (mouseY - ballY));
	}

	/**
	 * 定位圆的内切正方形：根据 两点坐标差 是否都小于（半径20）
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @param ballX
	 * @param ballY
	 * @return
	 */
	public boolean isAtSquare(int mouseX, int mouseY, int ballX, int ballY)
	{
		boolean tf = false;
		if (Math.abs(mouseX - ballX) <= 20 && Math.abs(mouseY - ballY) <= 20)
			tf = true;
		return tf;
	}

	public static void main(String[] args)
	{
		ControlBall c = new ControlBall();
		int x, y;
		String num, format = "(%3d,%3d)%3s-";
		for (int i = 1; i <= 33; i++)
		{
			x = c.getRedBall(i).getX();
			y = c.getRedBall(i).getY();
			num = c.getRedBall(i).getNumber();

			System.out.printf(format, x, y, num);
			if (i % 11 == 0)
				System.out.println("\n");
		}
		for (int i = 1; i <= 16; i++)
		{
			x = c.getBlueBall(i).getX();
			y = c.getBlueBall(i).getY();
			num = c.getBlueBall(i).getNumber();

			System.out.printf(format, x, y, num);
			if (i % 5 == 0)
				System.out.println("\n");
		}
		for (int i = 1; i <= 7; i++)
		{
			x = c.getSelectedBall(i).getX();
			y = c.getSelectedBall(i).getY();
			num = c.getSelectedBall(i).getNumber();

			//System.out.printf("(%3d,%3d)%3s-", x, y, num);
			System.out.printf("(%3d,%3d)\n", x, y);
		}
	}

}
