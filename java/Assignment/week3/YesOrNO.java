package week3;

import java.util.Scanner;
public class YesOrNO {

	public static void main(String[] args) {
		System.out.print("Continue（enter y or n）： ");
		int key = 1;
		do {
			Scanner scan=new Scanner(System.in);
			char s=scan.nextLine().charAt(0);
			switch(s) {
			case 'y':System.out.println();
			System.out.println("The selection was y for Yes.）： ");
			key=0;break;
			case'n':System.out.println();
			System.out.println("The selection was n for No.）： ");
			key=0;break;
			default:System.out.print("Continue（enter y or n）： ");
			}
		}while(key!=0);
	}

}
