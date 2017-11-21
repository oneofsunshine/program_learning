package week13;
/*
 * Assignment1: 本类实现了AirTicket 的Comparator 接口;
 * 				实现方式：通过compare(AirTicket t1, AirTicket t2)方法定义类tickets 数组元素的行程排序规则;
 * 					按照toString 值由低到高排序;
 * 				包含方法: 按行程比较机票;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
import java.util.Comparator;

public class ItineraryCompare implements Comparator<AirTicket>
{
	/*
	 * 传入两个机票类型对象为参数，按行程的toString比较大小;
	 * 如果第一个对象大于第二个，返回一个正数，如果小于，返回负数，如果等于返回0;
	 * */
	public int compare(AirTicket t1, AirTicket t2)
	{
		return t1.getItinerary().toString().compareTo(t2.getItinerary().toString());
	}
}
