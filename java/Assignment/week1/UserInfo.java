package week1;

import java.util.Scanner;
public class UserInfo {
	public static void main(String[] args) {
		String name;
		int age;
		double income;
		String marriage;
        Scanner scan = new Scanner(System.in); 
        System.out.print("请输入你的姓名:");
        name = scan.next(); 
        System.out.print("请输入你的年龄:");
        age = scan.nextInt();
        System.out.print("请输入你期望的工资:");
        income = scan.nextDouble();
        System.out.print("请你是否已婚（true代表已婚，false代表未婚）:");
        marriage = scan.next();
        System.out.println("你的信息如下:");
        System.out.println("姓名:" + name); 
        System.out.println("年龄:" + age); 
        System.out.println("期望的工资:" + income); 
        System.out.println("婚姻状态:" + marriage); 
	}
}
