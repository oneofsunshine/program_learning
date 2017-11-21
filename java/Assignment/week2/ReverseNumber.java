package week2;

import java.util.Scanner;
public class ReverseNumber {

	public static void main(String[] args) {
		int number;
		Scanner scan = new Scanner(System.in); 
        System.out.print("请输入一个三位整数:");
        number = scan.nextInt(); 
        while(number%10!=0) {
        	int c;
        	c=number%10;
        	System.out.print(c);
        	number=(number-c)/10;
        }
	}
}
