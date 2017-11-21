package week9;

public class TestArrayLength {

	public static void main(String[] args) {
		int[] numbers = { 3, 5, 12 };
		int[] digits = new int[4];
		
		System.out.println("digits 数组长度：" + digits.length);
		
		for(int number : numbers)
		{
			System.out.print(number + ",");
		}  
		
		System.out.println("");  
		
		for(int digit : digits)
		{                  
			System.out.print(digit + ","); 
		} 
		
		System.out.println("");  
		
		digits = numbers;
		
		System.out.println("digits 数组长度：" + digits.length);     
	}

}
