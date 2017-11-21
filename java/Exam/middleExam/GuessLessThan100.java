package middleExam;

import java.util.Scanner;

public class GuessLessThan100 {
	/*
	 * topic2: 猜数字新版，
	 * 规定：生成一个100以内的整数，只给提示猜大了或猜小了，直到猜对为止；并统计次数；
	 * @Author: 苑浩;
	 * Sno: 15130041045;
	 * */
	public static void main(String[] args) {
		int guess = (int)(Math.random()*100+1);
		int count = 1;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请猜一个数字： ");
		int s = scan.nextInt();
		
		while(s != guess)
		{
			if(s > guess)
				System.out.println("猜大了！");
			else
				System.out.println("猜小了！");
			s = scan.nextInt();
			count++;
		}
		
		scan.close();
		
		System.out.println("你猜对了！");
		System.out.println("你一共猜了："+count+"次。");
	}

}
