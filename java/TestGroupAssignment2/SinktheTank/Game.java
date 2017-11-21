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
			System.out.println("���е�һ��");
			ship1.count --;
			sunk();
			return true;
		}
		else if(ship2.getShip().contains(sc.getSquare(abscissa, ordinate))){
			System.out.println("���еڶ���");
			ship2.count --;
			sunk();
			return true;
		}
		else if(ship3.getShip().contains(sc.getSquare(abscissa, ordinate))){
			System.out.println("���е�����");
			ship3.count --;
			sunk();
			return true;
		}
		else{
			System.out.println("δ����");
			return false;
		}
	}
	
	public static String sunk(){
		if(ship1.count <= 0&ship2.count <= 0&ship3.count <= 0){
			return"ս������ ȫ������ ��Ӯ��";
		}
		else{
		if(ship1.count == 0){
			System.out.println("������һ��");
			return "��������ѱ�����";
		}
		else if(ship2.count == 0){
			System.out.println("�����ڶ���");
			return "Tatinic Sank";
		}
		else if(ship3.count == 0){
			System.out.println("����������");
			return "�߶������ѱ�����";
		}
		else
			return "ս�����ڼ��� ���������";
		}
	}
}
