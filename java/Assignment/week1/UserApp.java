package week1;

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
public class UserApp {

	public static void main(String[] args) {
		User p=new User("Pat",71,1);
		p.name="Pat";
		p.age=71;
		p.gender=1;
		System.out.println("Enter your name:"+p.getName());
		System.out.println("Enter your age in years:"+p.getAge());
		System.out.println("Enter your gender(1 for female, 0 for male):"+p.getGender());	
	}
}
