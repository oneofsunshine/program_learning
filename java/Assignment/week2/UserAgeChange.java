package week2;

import java.util.Scanner;

class User
{
	String name;
	int age;
	int gender;
	public User(String nameln, int ageln, int genderln) {
		name=nameln;
		age=ageln;
		gender=genderln;
	}
	public String getName() {
		return name;
	}
	public void setName(String nameln) {
		name = nameln;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int ageln) {
		age=ageln;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int genderln) {
		gender = genderln;
	}
}
public class UserAgeChange {

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
		minute=p.age*525600;
		century=p.age/100.0;
		System.out.println("Enter your name:"+p.getName());
		System.out.println("Enter your age in years:"+p.getAge());
		System.out.println("Enter your gender(1 for female, 0 for male):"+p.getGender());
		System.out.println("                 Your age in minutes is: "+minute+" minutes.");
		System.out.println("                 Your age in centuries is: "+century+" centuries.");
	}

}
