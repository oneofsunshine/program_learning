package week13;
/*
 * Assignment1: 本类完成从数据文件中读取并生成报告的功能;
 * 				包含方法: 读取文件，向机票数组添加机票对象，添加无效记录;
 * 				生成报告，按航班号排序并生成报告，按行程排序并生成报告;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class AirTicketProcessor {
	private AirTicket[] tickets;// 代表机票数组，用于存放机票;
	private String[] invalidRecords;// 代表无效记录数组，用于储存无效记录;
	
	public AirTicketProcessor()
	{
		tickets = new AirTicket[0];
		invalidRecords = new String[0];
	}// 初始化两个数组的长度为 0;
	
	/*
	 * 传入一个代表文件名的String 类型的参数;
	 * 读取文件，对文件各行进行判断，每一行以“，”分割各项;
	 * 如果是开头字符是N，E，B，F（NonRefundable， Economy，Business，  Elite）则为合法机票类型;
	 * 判断对象类型创建对象并添加到对象数组;
	 * */
	public void readAirTicketFile(String fileName) throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(fileName));
		String line;
		String[] word = new String[0];
		Scanner scan;
		
		while(sc.hasNextLine())
		{
			word = new String[0];
			line = sc.nextLine();
			scan = new Scanner(line);
			scan.useDelimiter(",");
			
			while(scan.hasNext())
			{
				word = Arrays.copyOf(word, word.length + 1);
				word[word.length - 1] = scan.next();
			}
			
			Itinerary trip = new Itinerary(word[2], word[3], word[4], word[5], Integer.parseInt(word[6]));
			
			switch(Character.toUpperCase(word[0].charAt(0)))
			{
			case 'N': 
				NonRefundable n = new NonRefundable(word[1], trip,  Double.valueOf(word[7]),
						 Double.valueOf(word[8]),  Double.valueOf(word[9]));
				this.addAirTicket(n);
				break;
				
			case 'E':
				Economy e = new Economy(word[1], trip,  Double.valueOf(word[7]),  Double.valueOf(word[8]));
				this.addAirTicket(e);
				break;
				
			case 'B': 
				Business b = new Business(word[1], trip,  Double.valueOf(word[7]),  Double.valueOf(word[8]), 
						 Double.valueOf(word[9]),  Double.valueOf(word[10]));
				this.addAirTicket(b);
				break;
				
			case 'F': 
				Elite f =new Elite(word[1], trip, Double.valueOf(word[7]), Double.valueOf(word[8]), 
						 Double.valueOf(word[9]),  Double.valueOf(word[10]),  Double.valueOf(word[11]));
				this.addAirTicket(f);
				break;
				
			default: 
				System.out.println("机票类型不合法");
				this.addInvailRecord(line);
			}
		}
	}
	
	public void addAirTicket(AirTicket at)
	{
		tickets = Arrays.copyOf(tickets, tickets.length + 1);
		tickets[tickets.length - 1] = at;
	}// 传入一个机票对象为参数，将机票数组长度加1， 之后将传入的对象放入数组;
	
	public void addInvailRecord(String s)
	{
		invalidRecords = Arrays.copyOf(invalidRecords, invalidRecords.length + 1);
		invalidRecords[invalidRecords.length - 1] = s;
	}// 传入一个字符串为参数，将无效记录数组长度加1， 之后将传入的对象放入数组;
	
	public String generateReport()
	{
		String result = "";
		for(int i = 0; i < tickets.length; i++)
		{
			result += "\n" + tickets[i] + "\n";
		}
		return result;
	}// 返回代表AirTicket 报告的字符串，该报告将数组元素以原有顺序输出;
	
	public String generateReportByFlightNum()
	{
		Arrays.sort(tickets);
		return this.generateReport();
	}// 返回代表AirTicket 报告的字符串，该报告将数组元素以航班号升序输出;
	
	public String generateReportByltinerary()
	{
		Arrays.sort(tickets, new ItineraryCompare());
		return this.generateReport();
	}// 返回代表AirTicket 报告的字符串，该报告将数组元素以行程升序输出;
}
