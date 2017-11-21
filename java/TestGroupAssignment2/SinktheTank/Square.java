package SinktheTank;

public class Square{
	private int abscissa;
	private int ordinate;
	private int usedState;
	
	public Square(int abscissa,int ordinate){
		this.abscissa = abscissa;
		this.ordinate = ordinate;
		this.usedState = 0;
	}

	public int getAbscissa() {
		return abscissa;
	}

	public void setAbscissa(int abscissa) {
		this.abscissa = abscissa;
	}

	public int getOrdinate() {
		return ordinate;
	}

	public void setOrdinate(int ordinate) {
		this.ordinate = ordinate;
	}

	public int getUsedState() {
		return usedState;
	}

	public void setUsedState(int usedState) {
		this.usedState = usedState;
	}
	
	public String toString(){
		String result;
		return result = "ÕâÊÇµÚ"+this.abscissa+"*"+this.ordinate;
	}
}
