package finalExam;

import java.util.Comparator;

public class ValueCompare implements Comparator<Goods>
{
	public int compare(Goods g1, Goods g2) {
		if(g1.getValue() < g2.getValue())
			return 1;
		else if(g1.getValue() > g2.getValue())
			return -1;
		else 
		{
			if(g1.getWeight() > g2.getWeight())
				return 1;
			else if(g1.getWeight() < g2.getWeight())
				return -1;
			else
				return 0;
		}
	}
	
}
