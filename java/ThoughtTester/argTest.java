public class argTest {

	public static void main(String[] args) {
		try 
		{
		System.out.println(args[0]);
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.out.println("wrong");
		}

	}

}
