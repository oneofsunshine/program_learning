package week16;

public class NumToChar {

	public static void main(String[] args) {
		numToChar("123456");
		
		System.out.println();
		
		intNumToChar(987654);
	}
	
	public static void numToChar(String s)
	{
		char[] c = s.toCharArray();
		String sl;
		int i = (c[0]-48);
//		System.out.print(i);
		switch (i) {
		case 0:
			System.out.print("zero ");
			break;
		case 1:
			System.out.print("one ");
			break;
		case 2:
			System.out.print("two ");
			break;
		case 3:
			System.out.print("three ");
			break;
		case 4:
			System.out.print("four ");
			break;
		case 5:
			System.out.print("five ");
			break;
		case 6:
			System.out.print("six ");
			break;
		case 7:
			System.out.print("seven ");
			break;
		case 8:
			System.out.print("eight ");
			break;
		case 9:
			System.out.print("nine ");
			break;
		default:
			System.out.print("wrong");
		}
		
		if(s.length() > 1)
		{
			sl = String.copyValueOf(c, 1, s.length() -1);
			numToChar(sl);
		}
	}
	
	public static void intNumToChar(int s)
	{
		char[] c = Integer.toString(s).toCharArray();
		String sl;
		int i = (c[0]-48);
//		System.out.print(i);
		switch (i) {
		case 0:
			System.out.print("zero ");
			break;
		case 1:
			System.out.print("one ");
			break;
		case 2:
			System.out.print("two ");
			break;
		case 3:
			System.out.print("three ");
			break;
		case 4:
			System.out.print("four ");
			break;
		case 5:
			System.out.print("five ");
			break;
		case 6:
			System.out.print("six ");
			break;
		case 7:
			System.out.print("seven ");
			break;
		case 8:
			System.out.print("eight ");
			break;
		case 9:
			System.out.print("nine ");
			break;
		default:
			System.out.print("wrong");
		}
		
		if(c.length > 1)
		{
			sl = String.copyValueOf(c, 1, c.length -1);
			
			intNumToChar(Integer.parseInt(sl));
		}
	}
}
