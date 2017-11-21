package week4;

import java.util.Scanner;
public class MessageExchange {

	public static void main(String[] args) {
		System.out.println("Type in a message and press enter:");
		Scanner scan=new Scanner(System.in);
		String message = scan.nextLine();
		System.out.println("Output types:");
		System.out.println("1:As is");
		System.out.println("2:UPPER");
		System.out.println("3:lower ");
		System.out.println("4:");
		int number=scan.nextInt();
		scan.close();
		switch(number)
		{
		case 1:break;
		case 2:message=message.toUpperCase();break;
		case 3:message=message.toLowerCase();break;
		case 4:;break;
		}
		System.out.println(message);
	}

}
