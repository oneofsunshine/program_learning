package week6;

public class StudentBody {

	public static void main(String[] args) {
		Address liSchool=new Address("����·238��","�ൺ", 266000);
		Address liHome=new Address("����·2��","�ൺ", 266001);
		Student s1=new Student("С��",liHome,liSchool);

		System.out.println(s1+"\n");
		
		Address jSchool=new Address("����·238��","�ൺ", 266000);
		Address jHome=new Address("����·2��","�ൺ", 266001);
		Student s2=new Student("Joy",jHome,jSchool);

		System.out.println(s2+"\n");
	}

}
