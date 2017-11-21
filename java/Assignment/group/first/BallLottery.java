package group.first;

public class BallLottery
{
	private int[] betRedBall = new int[6];  //存放选择的6个红球
	private int betBlueBall;          //存放选择的1个蓝球
	private int[] winningRedBall = {1,2,3,4,5,6};//红球中奖号码
	private int winningBlueBall = 7;   //蓝球中奖号码
	
	public String showResults(int level)
	{
		String result = "----------------------------------------------";
		result += "\n\n您的投注：";
		for (int i = 0; i < betRedBall.length; i++)
			result += ("   " + betRedBall[i]);
		result += (",   " + betBlueBall);
		
		result += ("\n开奖号码：");
		for (int i = 0; i < winningRedBall.length; i++)
			result += ("   " + winningRedBall[i]);
		result += (",   " + winningBlueBall + "\n\n");
		
		//根据中奖等级分配奖品
		switch (level)
		{
		case 0: result += ("抱歉，您没中奖！"); break;
		case 1: result += ("一等奖，恭喜您获得自行车一辆！"); break;
		case 2: result += ("二等奖，恭喜您获得保温杯一个！"); break;
		case 3: result += ("三等奖，恭喜您获得新书包一个！"); break;
		case 4: result += ("四等奖，恭喜您获得记事本一个！"); break;
		case 5: result += ("五等奖，恭喜您获得签字笔一个！"); break;
		case 6: result += ("六等奖，恭喜您获得黑铅笔一个！"); break;
		}
		result += ("\n\n----------------------------------------------");
		return result;
	}
	public int lotteryBetting()
	{
		int correctRedCount = 0;          // 猜中的红球个数
		boolean correctBlueCount = false; // 是否猜中篮球

		//遍历选择的红球;对比开奖结果 算出中奖的红球个数
		for (int i = 0; i < betRedBall.length; i++)
		{
			for (int j = 0; j < winningRedBall.length; j++)
			{
				if (betRedBall[i] == winningRedBall[j])
				{
					 correctRedCount++;
					 continue;
				}
			}
		}

		// 判断是否猜中蓝球
		if (betBlueBall == winningBlueBall) correctBlueCount = true; 

		/**		没中奖  返回 0
		 *      一等奖  中 6+1
		 *  	二等奖  中 6+0
		 *  	三等奖  中 5+1
		 *  	四等奖  中 5+0  中 4+1
		 *  	五等奖  中 4+0  中 3+1
		 *  	六等奖  中 2+1  中 0+1  中 1+1
		 */
		System.out.println("Debug:"
				+ correctRedCount + "," + correctBlueCount);
		if (correctRedCount == 6)
		{
			if (correctBlueCount) return 1;
			else return 2;
		}
		if (correctRedCount == 5)
		{
			if (correctBlueCount) return 3;
			else return 4;
		}
		if (correctRedCount == 4)
		{
			if (correctBlueCount) return 4;
			else return 5;
		}
		if (correctBlueCount)
		{
			if (correctRedCount == 3) return 5;
			//else if (correctRedCount == 2) return 6;
			//else if (correctRedCount == 1) return 6;
			else  return 6;

		}
		return 0;
	}
	public int[] getBetRedBall()
	{
		return betRedBall;
	}
	public void setBetRedBall(int[] betRedBall)
	{
		this.betRedBall = betRedBall;
	}
	public int getBetBlueBall()
	{
		return betBlueBall;
	}
	public void setBetBlueBall(int betBlueBall)
	{
		this.betBlueBall = betBlueBall;
	}
	public int[] getWinningRedBall()
	{
		return winningRedBall;
	}
	public void setWinningRedBall(int[] winningRedBall)
	{
		this.winningRedBall = winningRedBall;
	}
	public int getWinningBlueBall()
	{
		return winningBlueBall;
	}
	public void setWinningBlueBall(int winningBlueBall)
	{
		this.winningBlueBall = winningBlueBall;
	}
	
}
