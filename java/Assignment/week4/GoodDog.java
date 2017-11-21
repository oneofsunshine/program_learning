package week4;

public class GoodDog {
	private int size;
	
	GoodDog(int sizeln) {
		size=sizeln;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int sizeln) {
		this.size=sizeln;
	}
	
	public void bark() {
		if(size<=14)
			System.out.println("Yip!Yip!");
		else if(size<=60)
			System.out.println("Ruff!Ruff!");
		else
			System.out.println("Wooof!Wooof!");
	}
	
	public String toString() {
		String result;
		result = String.valueOf(size);
		return result;
	}
}