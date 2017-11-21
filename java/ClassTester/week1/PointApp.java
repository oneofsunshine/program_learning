package week1;
class Point { 
	private int x;
	private int y; 
	
	public Point(int xIn, int yIn) {
		x = xIn;      
		y = yIn; 
	} 
	
	public int getX() {  
		return x;
		}  
	
	public void setX(int xIn) {
		x = xIn;
	} 
	
	public int getY() {
		return y;
	} 
	
	public void setY(int yIn) {
		y = yIn;
	}
	
}
public class PointApp { 
	public static void main(String[] args) { 
		Point p = new Point(1, 3);  
		
		System.out.println("The point(x, y) is at (" + p.getX() + ", " + p.getY() + ")");  
	} 
} 