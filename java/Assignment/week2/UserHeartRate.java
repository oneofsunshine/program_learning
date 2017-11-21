package week2;

import java.util.Scanner;

public class UserHeartRate {

	public static void main(String[] args) {
		User p=new User(null, 0, 0);
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your name: ");
		p.name = scan.next();
		System.out.print("Enter your age: ");
		p.age = scan.nextInt();
		System.out.print("Enter your gender(1 for female, 0 for male): ");
		p.gender = scan.nextInt();
		scan.close();		
		int minute;
		double century;
		double heartRate;
		minute=p.age*525600;
		century=p.age/100.0;
		if(p.gender==0)
			heartRate=214-(0.8*p.age);
		else
			heartRate=209-(0.7*p.age);
		System.out.println("Enter your name:"+p.getName());
		System.out.println("Enter your age in years:"+p.getAge());
		System.out.println("Enter your gender(1 for female, 0 for male):"+p.getGender());
		System.out.println("         Your age in minutes is: "+minute+" minutes.");
		System.out.println("         Your age in centuries is: "+century+" centuries.");
		System.out.println("Your max heart rate is "+heartRate+" beats per minutes.");
	}

}

