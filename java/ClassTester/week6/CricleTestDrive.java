package week6;

class Point 
{
	private int x;
	private int y;
	Point(int xln,int yln)
	{
		x=xln;
		y=yln;
	}
	public String toString()
	{
		String result;
		result="("+x+","+y+")";
		return result;
	}
}
class Circle
{
	private int r;
	private Point point;
	Circle(int rln,Point pln)
	{
		r=rln;
		point=pln;
	}
	public String toString()
	{
		String result;
		result="圆是以"+point+"为圆心,以"+r+"为半径的圆";
		return result;
	}
}
class CricleTestDrive {

	public static void main(String[] args) {
		Point p=new Point(1,2);
		Circle c=new Circle(5,p);
		System.out.print(c);
	}

}
