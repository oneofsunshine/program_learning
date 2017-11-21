package week9;

import java.util.Scanner;

/*
 * @Author: YuanHao;
 * 输入 5 个 double 类型的值放入 double[] numbers 数 组中;
 * 先将其正向输出（两种方法），然后将其逆向输出;
 * */
public class ReverseOrder {

	public static void main(String[] args) {
		double[] numbers;
		numbers = new double[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 5 double number:");
		for(int i=0;i<5;i++)
		{
			System.out.print("number"+(i+1)+": ");
			numbers[i] = sc.nextDouble();
		}
		
		System.out.println("正序：");
		for(int i = 0;i<5;i++)
		{
			System.out.println("num"+(i+1)+": "+numbers[i]);
		}
		
		System.out.println("逆序：");
		for(int i=4;i>=0;i--)
		{
			System.out.println("num"+(i+1)+": "+numbers[i]);
		}
		
	}

}
