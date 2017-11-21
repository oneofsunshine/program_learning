package hitGame;


/**
 * ����������
 *
 */
public class Grid {
	
	private int x;//x����ֵ
	private int y;//y����ֵ
	private String value;//ÿ������ֵ
	
	public Grid(String value,int xIn,int yIn) {
		this.value = value;
		x=xIn;
		y=yIn;
	}
	
	/* 
	 * ��д��������ж�
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
	 * @param x Ҫ���õ� x
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
	 * @param y Ҫ���õ� y
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
	 * @param value Ҫ���õ� value
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
			this.value="����";
			return "hit";		
		}
			
	    return "miss";
	}
	
	@Override
	public String toString() {
		return "Grid [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	
}
