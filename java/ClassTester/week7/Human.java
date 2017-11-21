package week7;

public class Human {
	private int height;
	
	Human(int h)
	{
		height = h;
		System.out.println("I'm born.");
	}
	
	public int getHeight()
	{
		return height;
	}
	

	public void growHeight(int grow)
	{
		this.height = height+grow;
	}
	
	public void breath()
	{
		System.out.println("ºô~ºô");
	}
	
	public void repeatBreath(int r)
	{
		for(int i = 0; i < r;i++)
			this.breath();
	}
	
}
