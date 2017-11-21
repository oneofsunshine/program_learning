package finalExam;
/*
 * 3 :;
 * @ Author: YuanHao;
 * Sno: 15130041045;
 * */
public class Goods implements Comparable<Goods>
{
	private String name;
	private double weight;
	private double value;
	
	public Goods(String nameln, double weightln, double valueln)
	{
		name = nameln;
		weight = weightln;
		value = valueln;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getWeight()
	{
		return weight;
	}
	
	public double getValue()
	{
		return value;
	}
	
	public int compareTo(Goods g) 
	{
		return this.name.compareTo(g.getName());
	}
	
	public String toString()
	{
		String result = "\r\nName: " + getName() + 
				"\r\nWeight: " + getWeight() + "\tValue: " + getValue();
		return result;
	}
}
