package week9;

public class InitializerListExample {

	public static void main(String[] args) {
		 String[] list = {"Äã", "³Ô", "·¹", "ÁË", "Âð"};
		 
		 for (int index = 0; index < list.length; index++)
			 System.out.print (list[index] + " "); 
		 
		 System.out.println(); 
		 
		 for(String s : list) 
			 System.out.print (s + " ");   
		 
		 System.out.println();   
		 
		 System.out.println();  
		 for (int index = list.length - 1; index >= 0; index--)   
			 System.out.print (list[index] + " "); 
	}

}
