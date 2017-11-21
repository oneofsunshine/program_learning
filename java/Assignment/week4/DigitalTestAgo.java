package week4;

import java.util.Scanner;

public class DigitalTestAgo {
/*
*这个程序只能用以比较加‘.’一共14位的double数字的小数点左右各有多少位
*@Author YuanHao
*/
	public static void main(String[] args) {
		System.out.println("请输入一个double类型的数字： ");
		
		Scanner input = new Scanner(System.in);
		double number = input.nextDouble();
		String num=Double.toString(number);
		
		int left=num.indexOf('.');
		int all=num.length();
		int right=all-left-1;
		
		System.out.println("小数点左侧有"+left+"位");
		System.out.println("小数点右侧有"+right+"位");
	}

}
