package week3;

import java.util.Scanner;
class NumberOperations
{
	private int number;
	public NumberOperations(int numberIn)
	{
		number = numberIn;
	}
	public int getNumber()
	{
		return number;
	}
	public void oddsUnder()
	{
		System.out.print("Odds under: ");
		for(int i=1;i<number;i++)
		{
			if(i%2!=0)
			{
				System.out.print("\t"+i);
			}
		}
		System.out.println();
	}
	public void powersTwoUnder()
	{
		System.out.print("Powers of 2 under: ");
		int k=1;
		for(int i=1;i<number;i++)
		{
			if(i%k==0)
			{
				System.out.print("\t"+i);
				k=k*2;
			}
		}
		System.out.println();
	}
	public int isGreater(int compareNumber)
	{
		if(number>compareNumber)
			return 1;
		else if(number<compareNumber)
			return -1;
		else
			return 0;
	}
}
public class NumberOpsDriver {

	public static void main(String[] args) {
		System.out.println("Enter a list of positive integers separated with a space followed by 0:");
		Scanner scan= new Scanner(System.in);
		int first=scan.nextInt();
		int secend=scan.nextInt();
		int third=scan.nextInt();
		NumberOperations num1 =new NumberOperations(first);
		System.out.println("For: "+first);
		num1.oddsUnder();
		num1.powersTwoUnder();
		num1.isGreater(first);
		NumberOperations num2 =new NumberOperations(secend);
		System.out.println("For: "+secend);
		num2.oddsUnder();
		num2.powersTwoUnder();
		num2.isGreater(secend);
		NumberOperations num3 =new NumberOperations(third);
		System.out.println("For: "+third);
		num3.oddsUnder();
		num3.powersTwoUnder();
		num3.isGreater(third);
	}

}
