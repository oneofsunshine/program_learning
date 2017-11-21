package week3;

import java.util.Scanner;
public class Guess {
	public static void main(String[] args) {
		int random,guess,count=1;
		random=(int)(Math.random()*10+1);
		System.out.println("请输入一个数字:");
		while(count<5)
		{
			Scanner scan=new Scanner(System.in);
			guess=scan.nextInt();
			if(guess>=1&&guess<=10)
			{
				if(guess==random)
				{
					System.out.println("你聪明绝顶啦！");
					System.out.println("你用了"+count+"次");break;
				}
				else if(count<4)
					System.out.println("请再次输入：");
				count++;
			}
			else
				System.out.println("无效输入，请重新输入：");
		}
		if(count>=5)
		{
			System.out.println("呵呵，你out啦。");
			System.out.println("随机数为"+random);
		}
	}

}
