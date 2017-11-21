package SinktheTank;

public class Game {
	private static Ship ship1;
	private static Ship ship2;
	private static Ship ship3;
	private static SquareCube sc = new SquareCube();

	public static void start(){
		
		ship1 = new Ship(Game.sc);
		
		do{
			ship2 = new Ship(Game.sc);
		}while(ship1.overlapped(ship2));
		
		do{
			ship3 = new Ship(sc);
		}while(ship1.overlapped(Game.ship3)|ship2.overlapped(ship3));
		
	}
		
	public static boolean hit(int abscissa,int ordinate){
		if(ship1.getShip().contains(sc.getSquare(abscissa, ordinate))){
			System.out.println("击中第一艘");
			ship1.count --;
			sunk();
			return true;
		}
		else if(ship2.getShip().contains(sc.getSquare(abscissa, ordinate))){
			System.out.println("击中第二艘");
			ship2.count --;
			sunk();
			return true;
		}
		else if(ship3.getShip().contains(sc.getSquare(abscissa, ordinate))){
			System.out.println("击中第三艘");
			ship3.count --;
			sunk();
			return true;
		}
		else{
			System.out.println("未击中");
			return false;
		}
	}
	
	public static String sunk(){
		if(ship1.count <= 0&ship2.count <= 0&ship3.count <= 0){
			return"战争结束 全部击沉 您赢了";
		}
		else{
		if(ship1.count == 0){
			System.out.println("击沉第一艘");
			return "黑珍珠号已被击沉";
		}
		else if(ship2.count == 0){
			System.out.println("击沉第二艘");
			return "Tatinic Sank";
		}
		else if(ship3.count == 0){
			System.out.println("击沉第三艘");
			return "高鼎龙号已被击沉";
		}
		else
			return "战争还在继续 请持续开火";
		}
	}
}
