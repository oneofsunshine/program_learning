package week7;

public class Date {
	private int year;
	private int month;
	private int day;
	
	Date(int y,int m,int d)
	{
		this.year=y;
		this.month=m;
		this.day=d;
	}
	
	public void setDate(int yln,int mln,int dln)
	{
		this.year=yln;
		this.month=mln;
		this.day=dln;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public String toString()
	{
		String result;
		result="Year: "+year+"\n"+"Month:"+month+"\n"+"Day:"+day;
		return result;
	}
	
	public boolean isLeapYear()
	{
		boolean leapyear = year%4==0&&year%100!=0||year%400==0;
		return leapyear;
	}
}
