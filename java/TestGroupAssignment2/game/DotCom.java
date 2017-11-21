package game;

import java.util.ArrayList;
import java.util.Scanner;

public class DotCom {
	public static void main(String[] args){
		ArrayList<Integer> x=new ArrayList<Integer>();
		ArrayList<Integer> y=new ArrayList<Integer>();
		int a,b,c,d,e,f,g,h;
		boolean is=true;
		while(is){
			boolean coincide=false;
			int X=(int)(Math.random()*7+1);
			int Y=(int)(Math.random()*7+1);
			a=X+1;
			b=X-1;
			c=Y+1;
			d=Y-1;
			e=X+2;
			f=X-2;
			g=Y+2;
			h=Y-2;
					
			for(int i=0;i<x.size();i++){
				if(X==x.get(i)&&Y==y.get(i)){
					coincide=true;
					break;
				}
				
			}
			if(coincide){
				continue;
			}
			
			x.add(X);
			y.add(Y);
			while(is){
				int direction=(int)(Math.random()*4+1);
				coincide=false;
				switch(direction){
				case 1:
					for(int i=0;i<x.size();i++){
						if(X==x.get(i)&&(c==y.get(i)||g==y.get(i))){
							coincide=true;
						}
					}
					
					if(c>7||e>7||coincide==true){
						
						continue;
					}
					x.add(X);
				    y.add(c);
				    x.add(X);
				    y.add(g);
				    break;
				case 2:
					for(int i=0;i<x.size();i++){
						if(X==x.get(i)&&(d==y.get(i)||h==y.get(i))){
							coincide=true;
						}
					}
					if(d<0||h<0||coincide==true){
						continue;
					}
					x.add(X);
				    y.add(d);
				    x.add(X);
				    y.add(h);
					break;
				case 3:
					for(int i=0;i<x.size();i++){
						if(Y==y.get(i)&&(a==x.get(i)||e==x.get(i))){
							coincide=true;
						}
					}
					if(a>7||e>7||coincide==true){
						continue;
					}
					x.add(a);
				    y.add(Y);
				    x.add(e);
				    y.add(Y);
				    break;
				case 4:
					for(int i=0;i<x.size();i++){
						if(Y==y.get(i)&&(b==x.get(i)||f==x.get(i))){
							coincide=true;
						}
					}
					if(b<0||f<0||coincide==true){
						continue;
					}
					x.add(b);
				    y.add(Y);
				    x.add(f);
				    y.add(Y);
					break;
				}
				is=false;
		    }
			
			if(x.size()!=9)
			is=true;
			
		}
		for(int i=0;i<9;i++){
			System.out.println(x.get(i));
			System.out.println(y.get(i));
			System.out.println("");
		}
		Scanner scan=new Scanner(System.in);
		int n=1;
		ArrayList<Integer> in=new ArrayList<Integer>();
		while(n<9){
			boolean ifHit=false;
			System.out.println("Please enter the abscissa X(1~7)");
			int X=scan.nextInt();
			System.out.println("Please enter the ordinate Y(1~7)");
			int Y=scan.nextInt();
			for(int i=0;i<8;i++){
				if(X==x.get(i)&&Y==y.get(i)){
					System.out.println("hit!");
					n=n++;
					ifHit=true;
					in.add(i);
					if(in.contains(0)&&in.contains(1)&&in.contains(2)){
						System.out.println("Oh!You sunk Google.com!");
						in.remove(0);
					}
					if(in.contains(3)&&in.contains(4)&&in.contains(5)){
						System.out.println("Oh!You sunk Yotube.com!");
						in.remove(3);
					}
					if(in.contains(6)&&in.contains(7)&&in.contains(8)){
						System.out.println("Oh!You sunk Amazon.com!");
						in.remove(6);
					}
						
				}
			}
			if(ifHit==false)
				System.out.println("miss...");
		}
		System.out.println("Oh!You sunk all the dotcom!");
		
	}
}
