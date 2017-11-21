package finalExam;
/*
 * 2 :;
 * @ Author: YuanHao;
 * Sno: 15130041045;
 * */
public class Species {
	private String name;
	private int population;
	private double growthRate;

	public void readInput(String n, int p, double g)
	{
		name = n;
		if(p >= 0)
			population = p;
		else
			System.out.println("population must > 0");
		growthRate = g;
	}
	
	public void setName(String nln)
	{
		name = nln;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPopulation(int pln)
	{
		if(pln >= 0)
			population = pln;
		else
			System.out.println("population must > 0");
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public void setGrowthRate(double gln)
	{
		growthRate = gln;
	}
	
	public double getGrowthRate()
	{
		return growthRate;
	}
	
	public int predictPopulation(int years)
	{
		int p = population;
		for(int i = 0; i < years; i++)
			p = (int)(p * (1 + growthRate));
		return p;
	}
	
	public boolean equals(Species anothers)
	{
		boolean b = (this.getName().equals(anothers.getName()) &&
				this.getPopulation() == anothers.getPopulation() && 
				this.getGrowthRate() == anothers.getGrowthRate());
		return b;
	}
	
	public String toString()
	{
		String result = "Name: " + getName() + 
				"\r\nPopulation: " + getPopulation() + "\tGrowthRate: " + getGrowthRate();
		return result;
	}
}
