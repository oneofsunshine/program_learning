package week12;
/*
 * Assignment1: 含main 方法，为测试类;
 * 				实例化AirTicket[]类型数组，输出每一个元素;
 * 				按航班号排序，再次输出每一个元素;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
import java.util.Arrays;

public class AirTicketProcessor 
{

	public static void main(String[] args) 
	{
		AirTicket[] tickets = new AirTicket[4];// 定义 AirTicket[] 类型的数组，长度为 4;
		
		/*
		 * 生成四个Itinerary 类型的引用变量;
		 * */
		Itinerary trip1 = new Itinerary("ATL", "LGA", "2015/05/01 14:00", "2515/05/01 16:40", 800); 
		Itinerary trip2 = new Itinerary("ATL", "LGA", "2015/05/01 15:00", "2515/05/01 17:40", 800);
		Itinerary trip3 = new Itinerary("ATL", "LGA", "2015/05/01 09:00", "2515/05/01 11:40", 800);
		Itinerary trip4 = new Itinerary("ATL", "LGA", "2015/05/01 08:00", "2515/05/01 10:40", 800);
		
		/*
		 * 生成Economy ，Business ，Elite ，NonRefundable 4种类型的机票对象;
		 * 并将这4个对象添加到tickets 数组中;
		 * */
		tickets[0] = new Business("DL 1865", trip1, 450, 2, 50, 50);
		tickets[1] = new Economy("DL 1867", trip2, 450, 1);
		tickets[2] = new Elite("DL 1863", trip3, 450, 2.5, 50, 50, 100);
		tickets[3] = new NonRefundable("DL 1861", trip4, 450, 0.45, 0.9);
		
		for(int i = 0; i < tickets.length; i++)
			System.out.println(tickets[i] + "\n");
		// 输出数组的每一个元素;
		
		Arrays.sort(tickets);
		// 按航班号排序;
		
		for(int i = 0; i < tickets.length; i++)
		System.out.println(tickets[i] + "\n");
		// 输出数组的每一个元素;
	}

}
