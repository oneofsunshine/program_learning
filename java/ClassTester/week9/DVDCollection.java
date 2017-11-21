package week9;

public class DVDCollection {
	private DVD[] collection;
	private int count;
	private double totalCost = 0;
	
	DVDCollection() {
		collection = new DVD[100];
	}
	
	public void addDVD(DVD d)
	{
		
	}
	
	public String toString()
	{
		for(int i = 0; i < collection.length; i++)
		{
			totalCost += collection[i].cost;
		}
		
		String result = "";
		result += "My DVD collection\n\n";
		result += "Numbers of DVDs: " + collection.length + "\n";
		result += "Total cost: " + totalCost +"\n";
		result += "Average cost: " + totalCost

		return 
	}
}
