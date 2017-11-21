package week11;

public class animal {
	protected int height;
	protected int weight;
	
	animal(int h,int w)
	{
		this.height = h;
		this.weight = w;
	}
	
	public void eat()
	{
		System.out.println("eat");
	}
	
	public void sleep()
	{
		System.out.println("sleep");
	}
}
