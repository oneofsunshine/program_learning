package week9;

public class DVD {
	private String title, director;
	private int year;
	protected double cost;
	private boolean bluRay;
	
	DVD(String tit,String dir,int y,double costln, boolean blu)
	{
		title = tit;
		director = dir;
		year = y;
		cost = costln;
		bluRay = blu;
	}
	
	public String toString()
	{
		String result;
		result = "гд"+cost+"\t"+year+"\t"+director+"\t";
		if(bluRay)
			result += "Blu-Ray";
		return result;
	}
	
}
