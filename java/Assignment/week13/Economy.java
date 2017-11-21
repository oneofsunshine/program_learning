package week13;
/*
 * Assignment1: 本类为AirTicket 类的子类，代表经济舱机票;
 * 				包含方法: 继承父类的的全部方法，实现AirTicket 类定义的抽象方法;
 * 				获取总费用，获取总距离，获取汇总信息;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class Economy extends AirTicket
{
	private static final double AWARDMILESFACTOR = 1.5;// 静态常量，代表距离判定因素;

	public Economy(String flightNum, Itinerary trip, double baseFare, double fareAdjustmentFactor)
	{
		super(flightNum, trip, baseFare, fareAdjustmentFactor);
	}// 传入4个参数，调用父类的构造器;

	public double totalFare()
	{
		return super.getBaseFare() * super.getFareAdjustmentFactor();
	}// 获取总费用，返回基本费用*费用调整因素;

	public int totalAwardMiles() 
	{
		return (int) (super.getItinerary().getMiles() * AWARDMILESFACTOR);
	}// 获取总距离，返回飞行距离*距离判定因素;

	public String toString() 
	{
		return super.toString() + " (class Economy) " + "\n\tIncludes Award Miles Factor: " + AWARDMILESFACTOR;
	}// 获取汇总信息，包括机票信息，距离判定因素;
}
