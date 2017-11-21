package groupAssignment1;

import java.util.ArrayList;

/*
 * 用于生成并储存红球中奖数字，判断某数字是否属于生成的数字并返回猜中的数字个数。
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class RedBallCreater {
	private ArrayList<Integer> redRandom = new ArrayList<>();
	private int redNum;
	
	RedBallCreater()
	{

		redNum = (int)(Math.random()*33+1);
		redRandom.add(redNum);
		
		//如果生成的红球数字和之前生成的红球数字重复，重新生成红球数字;
		for(int i = 0; i < 5; i++)
		{
			redNum = (int)(Math.random()*33+1);
			while(redRandom.indexOf(redNum) != -1)
				redNum = (int)(Math.random()*33+1);
			redRandom.add(redNum);
		}
	}//生成红球中奖数字并储存;
	
	
	public int redRightNum(ArrayList<Integer> red)
	{
		int redRight = 0;
		for(int i = 0; i < 6; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				if(red.get(i)== redRandom.get(j))
					redRight++;
			}
		}
		return redRight;
	}//确定红球猜中个数并返回代表猜中个数的int 类型的值;
	
	public String toString()
	{
		String result;
		result = "Right red ball numbers are: " + redRandom;
		return result;
	}//返回代表红球中奖信息的String 类型的值;
}
