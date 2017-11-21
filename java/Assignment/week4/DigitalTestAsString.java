package week4;

import java.util.Scanner;

public class DigitalTestAsString {
	/*
	 *Assignment3：判断输入double数值小数点左侧及右侧各有多少位
	 *@Author YuanHao
	 *这个程序还是将double类型数字当作string类型数据处理  
	 * */
	public static void main(String[] args) {
		System.out.println("请输入一个double类型的数字： ");
		
		Scanner input = new Scanner(System.in);
		String num = input.nextLine();
		
		int left=num.indexOf('.');
		int all=num.length();
		int right=all-left-1;
		
		System.out.println("小数点左侧有"+left+"位");
		System.out.println("小数点右侧有"+right+"位");
	}

}
