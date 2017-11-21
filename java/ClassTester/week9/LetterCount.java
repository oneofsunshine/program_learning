package week9;

import java.util.Scanner;

public class LetterCount {
/*
 * �����û������һ���ַ������жϴ�д�ַ���Сд�ַ�(�ֱ�����������������)���� ��ĸ�ĸ���;
 * */
	public static void main(String[] args) {
		System.out.println("Input a passage: ");
		
		Scanner sc = new Scanner(System.in);
		
		int[] upper; 
		int[] lower;
		
		String input = sc.nextLine();
		
		int num = 'z'-'a';
		int notLetter = 0;
		 
		upper = new int[num];
		lower = new int[num];
		
		for(int i = 0;i<input.length();i++)
		{
			if(input.charAt(i)>='a'&&input.charAt(i)<='z')
				lower[input.charAt(i)-'a']++;
			else if(input.charAt(i)>='A'&&input.charAt(i)<='Z')
				upper[input.charAt(i)-'A']++;
			else
				notLetter++;
		}
		
		for(int i = 0;i<num;i++)
		{

			System.out.println((char)('a'+i)+": "+lower[i]+"\t"+(char)('A'+i)+": "+upper[i]);
		}
		
		System.out.println("Non-alphabetic characters: "+notLetter);
		
	}

}
