package week4;

public class Die {
	private int faceValue;
	
	Die() {
		faceValue = 1;
	}
	
	public void setFaceValue(int value) {
		faceValue = value;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public int roll() {
		faceValue = (int) ((Math.random())*6+1);
		return faceValue;
	}
	
	public String toString() {
		String result;
		result = String.valueOf(faceValue);
		return result;
	}
}
