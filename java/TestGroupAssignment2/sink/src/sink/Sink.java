package sink;

import java.util.Scanner;

public class Sink {
	public static void main(String[] args) {
        Player p = new Player();
        Scanner scan = new Scanner(System.in);
        System.out.println("A1 A2 A3 A4 A5 A6 A7");
        System.out.println("B1 B2 B3 B4 B5 B6 B7");
        System.out.println("C1 C2 C3 C4 C5 C6 C7");
        System.out.println("D1 D2 D3 D4 D5 D6 D7");
        System.out.println("E1 E2 E3 E4 E5 E6 E7");
        System.out.println("F1 F2 F3 F4 F5 F6 F7");
        System.out.println("G1 G2 G3 G4 G5 G6 G7");
        System.out.println("");
      
        int coor,i,j = 0;
        String s;
        for(i=0;i<49;i++){
            do{
                System.out.print("Chose a coordinate:");
                s = scan.nextLine();
                coor = (s.charAt(0)-'A')*10+s.charAt(1)-'1';
            }while(!Dotcom.noborder(coor));
            if(p.hit(coor))
                if(p.sink()){
                    System.out.println("Sunk");
                    j++;
                }
                else
                    System.out.println("Hit");
            else    System.out.println("Miss");
            if(j==3){
                System.out.println("你的猜测次数为："+i+"次");
                break;
            }
        }
        scan.close();
	}
}
