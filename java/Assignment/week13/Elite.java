package week13;
/*
 * Assignment1: 本类为Business 类的子类，代表精华类机票;
 * 				包含方法: 继承父类的的全部方法，重写抽象方法;
 * 				获取总费用，获取总距离，获取汇总信息;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class Elite extends Business 
{
	private double cService;// 代表服务费;

	public Elite(String flightNum, Itinerary trip, double baseFare, double fareAdjustmentFactor,
			double foodAndBeverages, double entertainment, double cService) 
	{
		super(flightNum, trip, baseFare, fareAdjustmentFactor, foodAndBeverages, entertainment);
		this.cService = cService;
	}// 传入7个参数，调用父类的构造器，并初始化剩余的1个成员变量;

	public double totalFare() 
	{
		return super.totalFare() + cService;
	}// 获取总费用，返回基本费用*费用调整因素加服务费;

	public int totalAwardMiles()
	{
		return super.totalAwardMiles();
	}// 获取总距离，返回飞行距离*距离判定因素;

	public String toString()
	{
		return super.toString() + "\n\tComm Services: $" + cService;
	}// 获取汇总信息，包括机票信息，服务费;
}
