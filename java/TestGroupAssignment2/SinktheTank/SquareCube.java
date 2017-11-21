package SinktheTank;

public class SquareCube {
	private Square[][] squareCube = new Square[7][7];
	
	public  SquareCube(){
		this.creatSquareCube();
	}
	
	public void creatSquareCube(){
		for(int i = 0;i < 7;i ++){
			for(int j = 0;j < 7;j ++){
				squareCube[i][j] = new Square(i,j);
			}
		}
	}

	
	public Square[][] getSquareCube() {
		return squareCube;
	}
	
	public Square getSquare(int abscissa,int ordinate){
		return squareCube[abscissa][ordinate];
	}
}
