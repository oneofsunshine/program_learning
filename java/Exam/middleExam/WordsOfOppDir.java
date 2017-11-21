package middleExam;

import java.util.ArrayList;
import java.util.Scanner;

public class WordsOfOppDir {
	/*
	 * topic4: 将用户输入的一行字符串分解到单词，加入ArrayList<String>类型的变量 inputList中;
	 * 输出inputList的各元素分正序和逆序输出;
	 * @Author: 苑浩;
	 * Sno: 15130041045;
	 * */
	public static void main(String[] args) {
		ArrayList<String> inputList = new ArrayList<String>();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a passage： ");
		
		String passage = scan.nextLine();
		
		Scanner sc = new Scanner(passage);
		
		while(sc.hasNext())
		{
			String sl = sc.next();
			inputList.add(sl);
		}

		
		for(int i = 0;i<inputList.size();i++)
		{
			System.out.print("正序： ");
			System.out.print(inputList.get(i)+"\t");
			
			System.out.print("倒序： ");
			StringBuffer str=new StringBuffer(inputList.get(i));
			str.reverse();
			System.out.println(str);
			
		}
	}

}
