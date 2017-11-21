package week4;

import java.util.Scanner;
public class Minor1{

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
	
	int minimum1=StrictMath.min(first,second);
	int minimum2=StrictMath.min(second,third);
	int minimum=StrictMath.min(minimum1,minimum2);
	
	System.out.println("The minimum value is: "+minimum);
	}

}
