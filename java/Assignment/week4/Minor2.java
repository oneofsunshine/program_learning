package week4;

import java.util.Scanner;

public class Minor2 {

	public static void main(String[] args) {
		/*
		 * Assignment1：求输入三个数的最小值
		 * @Author YuanHao
		 * */
	System.out.println("Enter there number: ");
	
	Scanner inputNumber=new Scanner(System.in);
	
	int first=inputNumber.nextInt();
	int second=inputNumber.nextInt();
	int third=inputNumber.nextInt();
	
	int min;
	
	if(first>second)
		min=second;
	
	else
		min=first;
	
	if(third<min)
		min=third;
	
	System.out.println("The minimum value is: "+min);
	}

}
