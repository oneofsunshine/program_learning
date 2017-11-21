package week16;

class Bracket
{
	String bracket;
	
	public Bracket(String bra)
	{
		bracket = bra;
		
		for(int i = 0; i < bracket.length(); i++)
		{
			if(!isMatch(i))
			{
//				bracket.replace(')', '?');
//				bracket.replace('(', '$');
			}
		}
	}
	
	public boolean isMatch(int i)
	{
		
		return true; 
	}
}

public class BrcketMatch {

	public static void main(String[] args) {
		
	}

}
