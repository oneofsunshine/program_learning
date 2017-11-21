package week16;
class CD
{
	public CD(int in) {
		countdown(in);
	}
	
	public void countdown(int i)
	{
		if(i > 0)
		{
			System.out.println(i);
			countdown(i-1);
		}
		else
		{
			System.out.println();
			
		}
			
		
	}
}
public class Countdown {

	public static void main(String[] args) {
		new CD(3);
	}

}
