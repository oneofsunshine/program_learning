package week13;
/*
 * Assignment1: 本类为测试类，包含main 方法;
 * 				创建AirTicketProcessor 对象;
 * 				判断命令行是否有参数，如果没有输出提示然后终止程序;
 * 				调用AirTicketProcessor 的方法读入数据文件，输出三个报告;
 * 				期间如果没有找到文件抛出异常;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
import java.io.FileNotFoundException;

public class AirTicketApp {

	public static void main(String[] args) {
		AirTicketProcessor atp = new AirTicketProcessor();// 创建AirTicketProcessor 对象;
		
		if(args.length == 0)
		{
			System.out.println("命令行中没有提供文件名，程序终止");
			System.exit(0);
		}// 判断命令行是否有参数，如果没有输出提示然后终止程序;
		else
		{
			try
			{
				/*
				 * 调用AirTicketProcessor 的方法读入数据文件，输出三个报告;
				 * */
				atp.readAirTicketFile(args[0]);

				System.out.printf("\t--------------------------------------------------\n");
				System.out.printf("\t%40s", "Air Ticket Report\n");
				System.out.printf("\t--------------------------------------------------\n");
				
				System.out.println(atp.generateReport());
				
				System.out.printf("\t--------------------------------------------------\n");
				System.out.printf("\t%44s", "Air Ticket Report (by Flight Number)\n");
				System.out.printf("\t--------------------------------------------------\n");
				
				System.out.println(atp.generateReportByFlightNum());
				
				System.out.printf("\t--------------------------------------------------\n");
				System.out.printf("\t%45s", "Air Ticket Report (by Itinerary)\n");
				System.out.printf("\t--------------------------------------------------\n");
				
				System.out.println(atp.generateReportByltinerary());
			} 
			catch (FileNotFoundException e) 
			{// 如果没有找到文件抛出异常;
				System.out.println("文件没有找到，程序终止");
				e.printStackTrace();
			}
		}
	}

}
