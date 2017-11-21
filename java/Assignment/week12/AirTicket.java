package week12;
/*
 * Assignment1: 本类为抽象类，实现Comparable借口;
 * 				包含方法: 获取航班号，获取基本费用，获取费用调整因素;
 * 				获得行程，比较航班号（忽略大小写），获取汇总信息;
 * 				定义两个抽象方法，由子类实现;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public abstract class AirTicket implements Comparable<AirTicket>
{
	protected String flightNum;// 代表航班号;
	protected Itinerary trip;// 代表行程;
	protected double baseFare;// 代表基本费用;
	protected double fareAdjustmentFactor;// 代表费用调整因素;
	
	public AirTicket(String flightNum, Itinerary trip, double baseFare, double fareAdjustmentFactor) 
	{
		this.flightNum = flightNum;
		this.trip = trip;
		this.baseFare = baseFare;
		this.fareAdjustmentFactor = fareAdjustmentFactor;
	}// 传入4个参数初始化成员变量;
	
	public String getFlightNum()
	{
		return flightNum;
	}// 获取航班号，返回成员变量flightNum;
	
	public double getBaseFare()
	{
		return baseFare;
	}// 获取基本费用，返回成员变量baseFare;
	
	public double getFareAdjustmentFactor()
	{
		return fareAdjustmentFactor;
	}// 获取费用调整因素，返回成员变量fareAdjustmentFactor;
	
	public Itinerary getItinerary()
	{
		return trip;
	}// 获取行程，返回成员变量trip;
	
	/* 
	 * 传入一个AirTicket 类的参数，比较航班号（忽略大小写）;
	 * 如果此机票航班号比传入的机票航班号大，返回1;
	 * 如果此机票航班号比传入的机票航班号小，返回-1;
	 * 如果此机票航班号与传入的机票航班号相等，返回0;
	 */
	public int compareTo(AirTicket t)
	{
		if(this.flightNum.compareToIgnoreCase(t.flightNum) > 0)
			return 1;
		else if(this.flightNum.compareToIgnoreCase(t.flightNum) < 0)
			return -1;
		else
			return 0;
	}
	
	public String toString()
	{
		String result = "";
		result += "Flight Number: " + flightNum;
		result += "\n" + trip;
		result += "\nBase Fare: $" + baseFare;
		result += "\nFare Adjustment Factor: " + fareAdjustmentFactor;
		return result;
	}// 获取汇总信息，包括航班号，航班信息，基本费用，费用调整因素;
	
	public abstract double totalFare();// 抽象方法，由子类实现;
	public abstract int totalAwardMiles();// 抽象方法，由子类实现;
}
