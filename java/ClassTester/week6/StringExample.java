package week6;

public class StringExample {

	public static void main(String[] args) {
		String name1="Hello";
		String name2="Hello";
		
		System.out.println(name1==name2);
		System.out.println(name1.equals(name2));
		
		String name3 = new String("Hello");
		String name4 = new String("Hello");
		
		System.out.println(name3==name4);
		System.out.println(name3.equals(name4));
	}

}
