package week9;

public class TestPrimitiveArray {

	public static void main(String[] args) {
		int[] numbers;
		numbers = new int[4];
		
		String[] str = new String[4];
		for(int i=0;i<4;i++)
		{
			System.out.println(numbers[i]);
			numbers[i] = i+1;
		}
		
		System.out.println(numbers[3]);
		for(int i=0;i<4;i++)
		{
			System.out.println(str[i]);
		}
	}

}
