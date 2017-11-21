package middleExam;

import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureInfo {
	/*
	 * topic5: 
	 * @Author: 苑浩;
	 * Sno: 15130041045;
	 * */
	public static void main(String[] args) {
		ArrayList<Integer> tem = new ArrayList<Integer>();
		
		System.out.print("Pleasr input the temperatures： ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while(!s.isEmpty())
		{
			tem.add(Integer.parseInt(s));
			System.out.print("Pleasr input the temperatures： ");
			s = sc.nextLine();

		}

		Temperatures temps = new Temperatures(tem);
		
		System.out.println("Enter choice - [L]ow temp, [H]eigh temp, [P]rint, [E]nd: ");
		char choice = sc.next().charAt(0);
		while(choice!='e'&&choice!='E')
		{
			if(choice=='l'||choice=='L')
				System.out.println("Low is: "+temps.getLowestTemp());
			else if(choice=='h'||choice=='H')
				System.out.println("Hign is: "+temps.getHighestTemp());
			else if(choice=='p'||choice=='P')
				System.out.println(temps);
			System.out.println("Enter choice - [L]ow temp, [H]eigh temp, [P]rint, [E]nd: ");
			choice = sc.next().charAt(0);
		}
	}

}
