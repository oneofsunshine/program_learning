package week4;

import java.util.Scanner;
/*
 * Assignment2:进行回文测试
 * 这是仿照优秀作品的方法写的
 * 本方法中定义了一个方法，通过此方法实现回文测试
 * */
public class PalindromeTester1 {

	public static void main(String[] args) {
		System.out.println("请输入一个字符串");
		texter();
		
		while(true)
		{
			System.out.println("要测试另一个字符串吗？(y或Y代表是的，n或N代表不再测试）");
			
			Scanner scan=new Scanner(System.in);	
			String yesOrNo=scan.next();

			if(yesOrNo.charAt(0)=='y'||yesOrNo.charAt(0)=='Y')
			{
				System.out.println("请输入一个字符串");
				texter();
			}
			else
				break;
		}
	}
	private static void texter()
		{
		Scanner scan=new Scanner(System.in);
		String str = scan.nextLine();
		int flag=1;
		int length=str.length();
		for(int i=0;i<length/2&&flag==1;i++)
            if(str.charAt(i)==str.charAt(length-i-1))
                flag=1;
            else flag=0;
        if(flag==1)
            System.out.println("这是回文");
        if(flag==0)
            System.out.println("这不是回文");
	}

}
