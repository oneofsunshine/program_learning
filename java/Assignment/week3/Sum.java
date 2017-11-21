package week3;

public class Sum {

	public static void main(String[] args) {
		int sum=0;
		for(int i=1;i<16;i++)
		{
			if(i%2!=0||i%3!=0)
				sum=sum+i;
		}
		System.out.print("1-15中所有不能被2或者3整除的数值和为: "+sum);
	}

}
