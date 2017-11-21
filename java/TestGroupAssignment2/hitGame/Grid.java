package hitGame;


/**
 * 单个格子类
 *
 */
public class Grid {
	
	private int x;//x坐标值
	private int y;//y坐标值
	private String value;//每个格子值
	
	public Grid(String value,int xIn,int yIn) {
		this.value = value;
		x=xIn;
		y=yIn;
	}
	
	/* 
	 * 重写格子相等判断
	 */
	@Override
	public boolean equals(Object obj) {
		Grid other = (Grid)obj;
		if(value==other.value||(x==other.x&&y==other.y))
			return true;
		return false;
		
	}
	/**
	 * @return x
	 */
	public int getx() {
		return x;
	}
	/**
	 * @param x 要设置的 x
	 */
	public void setx(int x) {
		this.x = x;
	}
	/**
	 * @return y
	 */
	public int gety() {
		return y;
	}
	/**
	 * @param y 要设置的 y
	 */
	public void sety(int y) {
		this.y = y;
	}
	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value 要设置的 value
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @param value
	 * @return
	 */
	public String isHit(String value){
		if(this.value.equals(value)){
			this.value="命中";
			return "hit";		
		}
			
	    return "miss";
	}
	
	@Override
	public String toString() {
		return "Grid [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	
}
