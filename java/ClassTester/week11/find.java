package week11;

import java.util.Scanner;

public class find {

	public static void main(String[] args) {

		int n;
		Scanner sc = new Scanner(System.in);
		

		System.out.println("input a n:");
		n = Integer.parseInt(sc.nextLine());
		
		int[] numbers = new int[n];
		for(int i = 0; i < n; i++)
		{
			numbers[i] = i+1;
		}
		
		System.out.println("input a number:");
		
		int test = Integer.parseInt(sc.nextLine());
		double ink = 1;
		
		int left = 0, right = n-1;
		
		while(!(left>right))
		{
			if(test == numbers[(left+right)/2])
			{
				System.out.println((left+right)/2);
				ink = 0;
				break;
			}
			else if(test > numbers[(left+right)/2])
				left = (left+right)/2 + 1;
			else
				right = (left+right)/2 - 1;
		}
		
	}

}
