package finalExam;

import java.util.Scanner;

/*
 * 1 :统计用户输入一行字符中（单词之间以一个空格间隔）;
 * @ Author: YuanHao;
 * Sno: 15130041045;
 * */
public class WordCount 
{

	public static void main(String[] args) 
	{
		int count = 0;
		String passage;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("请输入一行字符： ");
		
		passage = sc.nextLine();
		sc.close();
		
		Scanner s = new Scanner(passage);
		s.useDelimiter(" ");
		
		while(s.hasNext())
		{
			
			if(!s.next().equals(""))
				count ++;
//				System.out.println("tab");
		}
		
		System.out.println("本行共有： " + count + "个单词。");
	}

}
