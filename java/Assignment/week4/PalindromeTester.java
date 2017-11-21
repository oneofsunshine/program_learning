package week4;

import java.util.Scanner;

public class PalindromeTester {
	/*
	 * Assignment2:进行回文测试;
	 * @ Author YuanHao;
	 */
	public static void main(String[] args) {
		
		while(true)
		{
			System.out.println("请输入一个字符串：");
			
			Scanner input=new Scanner(System.in);
			String s=new String(input.nextLine());
			
			StringBuffer str=new StringBuffer(s);
			StringBuffer newStr=new StringBuffer(str);

			str.reverse();

			boolean key = str.toString().equals(newStr.toString());
			if(key)
				System.out.println("这是回文。");
			else
				System.out.println("这不是回文。");

	/*	
	 * 	下边是另一种判断字符串的方法；
			int k =str.toString().compareTo(newStr.toString());
			if(k==0)
				System.out.println("这是回文");
			else
				System.out.println("这不是回文");
	*/		
			System.out.println("要测试另一个字符串吗？(y或Y代表是的，n或N代表不再测试）");
			String yesOrNo=input.next();
			if(yesOrNo.charAt(0)!='y'&&yesOrNo.charAt(0)!='Y')
				break;
		}
	}

}
