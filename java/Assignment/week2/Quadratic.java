package week2;

import java.util.Scanner;
public class Quadratic {

	public static void main(String[] args) {
		int a,b,c;
		double discriminant,root,root1,root2;//ax^2+b*x+c
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the coefficient of x squared: ");
		a = scan.nextInt();
		System.out.println("Enter the coefficient of x: ");
		b = scan.nextInt();
		System.out.println("Enter the constant: ");
		c = scan.nextInt();
		discriminant = Math.pow(b,2) - (4*a*c);
		System.out.println("Let "+a+"*x^2+"+b+"*x+"+c+"=0(a!=0)");
		if(discriminant==0)
		{
			root=((-1)*b)/(2*a);
			System.out.println("x1=x2="+root);
		}
		else if(discriminant>0)
		{
			root1=((-1)*b+Math.sqrt(discriminant))/(2*a);
			root2=((-1)*b-Math.sqrt(discriminant))/(2*a);
			System.out.println("x1="+root1);
			System.out.println("x2="+root2);
		}
		else
			System.out.println("无根");
	}

}
