package week12;
/*
 * Assignment1: 本类为AirTicket 类的子类，代表不可退的机票;
 * 				包含方法: 继承父类的的全部方法，实现AirTicket 类定义的抽象方法;
 * 				获取总费用，获取总距离，获取不可退因素，获取汇总信息;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class NonRefundable extends AirTicket 
{
	private double discountFactor;// 代表不可退因素;

	public NonRefundable(String flightNum, Itinerary trip, double baseFare,
			 double fareAdjustmentFactor,double discountFactor) 
	{
		super(flightNum, trip, baseFare, fareAdjustmentFactor);
		this.discountFactor = discountFactor;
	}// 传入5个参数，调用父类的构造器，病初始化剩余的1个成员变量;

	public double getDiscountFactor() 
	{
		return discountFactor;
	}// 获取不可退因素，返回成员变量discountFactor;

	public double totalFare() 
	{
		return super.getBaseFare() * super.getFareAdjustmentFactor() * discountFactor;
	}// 获取总费用，返回基本费用*费用调整因素*不可退因素;

	public int totalAwardMiles() 
	{
		return super.getItinerary().getMiles();
	}// 获取总距离，返回飞行距离;

	public String toString()
	{
		return super.toString() + "\nIncludes Discount Factor: " + discountFactor;
	}// 获取汇总信息，包括机票信息，不可退因素;

}
