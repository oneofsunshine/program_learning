package week9;

import java.util.Scanner;

/*
 * @Author: YuanHao;
 * ���� 5 �� double ���͵�ֵ���� double[] numbers �� ����;
 * �Ƚ���������������ַ�������Ȼ�����������;
 * */
public class ReverseOrder {

	public static void main(String[] args) {
		double[] numbers;
		numbers = new double[5];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input 5 double number:");
		for(int i=0;i<5;i++)
		{
			System.out.print("number"+(i+1)+": ");
			numbers[i] = sc.nextDouble();
		}
		
		System.out.println("����");
		for(int i = 0;i<5;i++)
		{
			System.out.println("num"+(i+1)+": "+numbers[i]);
		}
		
		System.out.println("����");
		for(int i=4;i>=0;i--)
		{
			System.out.println("num"+(i+1)+": "+numbers[i]);
		}
		
	}

}
