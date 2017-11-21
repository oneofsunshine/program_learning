package week7;

public class Slogan {
	private String phrase;
	protected static int count;
	Slogan(String ph)
	{
		this.phrase = ph;
		count++;
	}
	
	public static int getCount()
	{
		return count;
	}
	
	public String toString()
	{
		return "Your input: "+phrase;
	}
}
