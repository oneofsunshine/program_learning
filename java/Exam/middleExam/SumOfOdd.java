package middleExam;

public class SumOfOdd {
/*
 * topic1: 求15以内的正奇数之和,即求1+3+5+7+9+11+13+15的和；
 * @Author: 苑浩;
 * Sno: 15130041045;
 * */
	public static void main(String[] args) {
		int sum = 0;
		
		for(int i=1;i<=15;i++)
		{
			if(i%2!=0)
				sum += i;
		}
		
		System.out.println("15以内的正奇数之和为： "+sum);
	}

}
