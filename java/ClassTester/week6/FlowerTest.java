package week6;

class Flower
{ 
	private int petalCount = 0;
	private String s = new String("null"); 
	Flower() 
	{  
		System.out.println("Constructor1"); 
		}  
	Flower(int petalsIn)
	{ 
		petalCount = petalsIn; System.out.println("Constructor2");
		}     
	Flower(String sIn)
	{ 
		s = sIn; System.out.println("Constructo3"); 
	}
	Flower(String sIn, int petalsIn) 
	{
		s = sIn; petalCount = petalsIn; 
		System.out.println("Constructor4"); 
		}  
	public String toString()
	{
		String result; result = "Flower: " + s + " Petal: " + petalCount; 
		return result; }  
	}
public class FlowerTest {  
	public static void main(String[] args)
	{
		Flower f = new Flower(); 
		System.out.println(f + "\n"); 
		f = new Flower(47);
		System.out.println(f + "\n"); 
		f = new Flower("sunflower");
		System.out.println(f + "\n"); 
		f = new Flower("sunflower", 47); 
		System.out.println(f + "\n"); 
	} 
} 