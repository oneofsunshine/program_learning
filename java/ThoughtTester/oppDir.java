import java.util.Scanner;

public class oppDir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		
		int a,b,c;
		a = i % 10;
		b = ( i/ 10 ) % 10;
		c = i / 100;
		
		if(a != 0)
			i = a * 100 + b * 10 + c;
		else if(b !=0 )
			i = b * 10 + c;
		else
			i = c;
			
		System.out.println(i);
		sc.close();
	}

}
