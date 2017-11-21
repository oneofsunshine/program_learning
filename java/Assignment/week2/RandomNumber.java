package week2;

import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		int N=1;
		Scanner scan = new Scanner(System.in); 
		System.out.print("请输入一个数字作为上限:");
        N = scan.nextInt(); 
        System.out.print("请猜一个数字:");
        int temp=scan.nextInt();
		int randomNumber=(int)(Math.random()*N+1);
		if(temp==randomNumber)
			System.out.println("你太有才啦");
		else
			System.out.println("抱歉啦");
		System.out.print("数字为"+randomNumber);
	}

}
