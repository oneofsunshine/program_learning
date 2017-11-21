package week16;

public class ArraySearcher {
	private int[] a;
	
	public ArraySearcher(int[] theArray)
	{
		a = theArray;
	}
	
	public int find(int target)
	{
		return binarySearch(target, 0, a.length - 1);
	}
		
	private int binarySearch(int target, int first, int last)
	{
		if()
		binarySearch(target, first, last);
		return 1;
	}
	
	public static void main(String[] args)
	{
		
	}

}
