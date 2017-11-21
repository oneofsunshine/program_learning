package week13;
/*
 * Assignment1: 本类为AirTicket 类的子类，代表商务舱机票;
 * 				包含方法: 继承父类的的全部方法，实现AirTicket 类定义的抽象方法;
 * 				获取总费用，获取总距离，获取汇总信息;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class Business extends AirTicket
{
	private double foodAndBeverages;// 代表食物和饮料;
	private double entertainment;// 代表娱乐;
	private static final double AWARDMILESFACTOR = 2;// 静态常量，代表距离判定因素; 

	public Business(String flightNum, Itinerary trip, double baseFare, double fareAdjustmentFactor,
			double foodAndBeverages, double entertainment)
	{
		super(flightNum, trip, baseFare, fareAdjustmentFactor);
		this.foodAndBeverages = foodAndBeverages;
		this.entertainment = entertainment;
	}// 传入6个参数，调用父类的构造器，并初始化剩余的2个成员变量;

	public double totalFare() 
	{
		return super.getBaseFare() * super.getFareAdjustmentFactor() + foodAndBeverages + entertainment;
	}// 获取总费用，返回基本费用*费用调整因素;

	public int totalAwardMiles()
	{
		return (int) (super.getItinerary().getMiles() * AWARDMILESFACTOR);
	}// 获取总距离，返回飞行距离*距离判定因素;

	public String toString()
	{
		String result = "";
		result += super.toString();
		if(this instanceof Elite)
			result += " (class Elite) ";
		else
			result += " (class Business) ";
		result += "\n\tIncludes Food/Beverage: $" + foodAndBeverages + " Entertainment: $" 
				+ entertainment;
		return  result;
	}// 获取汇总信息，包括机票信息，食物饮料费，娱乐费;
}
