package week6;

public class StudentBody {

	public static void main(String[] args) {
		Address liSchool=new Address("松岭路238号","青岛", 266000);
		Address liHome=new Address("东海路2号","青岛", 266001);
		Student s1=new Student("小李",liHome,liSchool);

		System.out.println(s1+"\n");
		
		Address jSchool=new Address("松岭路238号","青岛", 266000);
		Address jHome=new Address("东海路2号","青岛", 266001);
		Student s2=new Student("Joy",jHome,jSchool);

		System.out.println(s2+"\n");
	}

}
