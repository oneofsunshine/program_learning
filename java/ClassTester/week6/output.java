package week6;

class Rock
{
	Rock()
	{
		System.out.println("Creating Rock");
		
	}
}
public class output
{
	public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
			new Rock();
	}
}