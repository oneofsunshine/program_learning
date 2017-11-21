package week13;
/*
 * Assignment1: 该类代表行程，是其他 5 个类的成员变量;
 * 				包含方法: 获取出发机场，获取起飞时间，获取飞行距离，获取汇总信息;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class Itinerary
{
	private String fromAirport;// 代表出发机场;
	private String toAirport;// 代表降落机场;
	private String depDateTime;// 代表起飞时间;
	private String arrDateTime;// 代表降落时间;
	private int miles;// 代表飞行距离;

	public Itinerary(String fromAirport, String toAirport, String depDateTime, String arrDateTime, int miles) 
	{
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.depDateTime = depDateTime;
		this.arrDateTime = arrDateTime;
		this.miles = miles;
	}// 传入5个参数已初始化成员变量;

	public String getFromAirport() 
	{
		return this.fromAirport;
	}// 获取出发机场，返回成员变量fromAirport;

	public String getDepDateTime() 
	{
		return this.depDateTime;
	}// 获得起飞时间，返回成员变量depDateTime;

	public int getMiles() 
	{
		return this.miles;
	}// 获取飞行距离，返回成员变量miles;

	public String toString() 
	{
		String result = "";
		result += fromAirport + "-" + toAirport;
		result += " (" + depDateTime + " - " + arrDateTime + ") ";
		result +=  miles +" miles";
		return result;
	}// 获取汇总信息，包括起降机场，起降时间，飞行距离;
}
