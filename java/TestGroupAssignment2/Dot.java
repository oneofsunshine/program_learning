

public class Dot {
	int y;
	int x;
	public Dot(int xln,int yln){
	 this.x=xln;
	 this.y=yln;
	}
	public boolean equ(Dot z,Dot x){
		return z.x==x.x&&z.y==x.y;
	}
	public int getx(){
		return x;
	}
	public int gety(){
		return y;
	}
	
	 
	public String toString(){
	String	result="x:"+x+"   "+"y:"+y; 
		return result;  
	}
}