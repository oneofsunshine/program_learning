package week6;

class Clock
{
	String time;
	Clock(String timeln)
	{
		time =timeln;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String timeln)
	{
		time=new String(timeln);
	}
	public String toString()
	{
		String s="Time: "+time;
		return s;
	}
}
public class ClockApp {

	public static void main(String[] args) {
		Clock ci= new Clock("9:30");
		System.out.println(ci);
	}

}
