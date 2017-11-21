package middleExam;

import java.util.ArrayList;

/*
 * topic5: 
 * @Author: 苑浩;
 * Sno: 15130041045;
 * */
public class Temperatures {
	private ArrayList<Integer> temp;
	Temperatures(ArrayList<Integer> temperaturesIn)
	{
		this.temp = temperaturesIn;
	}
	
//	求最低温度;
	public int getLowestTemp()
	{
		int LowestTemp = temp.get(0);
		for(int i=0;i<temp.size();i++)
		{
			if(LowestTemp>temp.get(i))
				LowestTemp = temp.get(i);
		}
		return LowestTemp;
	}
	
//	求最高温度;	
	public int getHighestTemp()
	{
		int HighestTemp = temp.get(0);
		for(int i=0;i<temp.size();i++)
		{
			if(HighestTemp < temp.get(i))
				HighestTemp = temp.get(i);
		}
		return HighestTemp;
	}
	
//	用来比较与之前输入的多个温度的最小值和最大值，从而输出两者之间的较小值;
	public int lowerMinimun(int lowIn)
	{
		if(lowIn<getLowestTemp())
			return lowIn;
		else
			return getLowestTemp();
	}
	
//	用来比较与之前输入的多个温度的最小值和最大值，从而输出两者之间的较大值;
	public int higherMaximum(int highIn)
	{
		if(highIn>getHighestTemp())
			return highIn;
		else
			return getHighestTemp();
	}
	
//	输出所有输入的温度及最大值、最小值;
	public String toString()
	{
		String result = "Temperatures： ";
		result += temp;
		result += "\nLow: "+getLowestTemp()+"\n";
		result += "High: "+getHighestTemp()+"\n";
		return result;
	}
}
