package week4;

import java.util.Scanner;

public class DigitalTestFromMaster {
	/*
	 *Assignment3：判断输入double数值小数点左侧及右侧各有多少位  
	 *Author YuanHao
	 * */

	public static void main(String[] args) {
		System.out.println("请输入一个double类型的数字");
		
		Scanner input =new Scanner(System.in);
		
		String s=input.nextLine();
		
		System.out.println("小数点左边有： "+s.indexOf('.')+"位");
		
		int index=s.indexOf('.');

		System.out.println("小数点右边有： "+s.substring(index+1,s.length()).length()+"位");
	}

}
