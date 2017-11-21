package week9;

class Person 
{
	public int age;
	public String name;
	public void setAge(int ageIn)
	{        
		age = ageIn;
	}
	public void setName(String nameIn)
	{
		name = nameIn;     
	}
	public void display() 
	{   
		System.out.println(name + "µƒƒÍ¡‰ «: " + age);   
	}
}
public class TestReferenceArray {

	public static void main(String[] args) {
        Person[] persons = new Person[2];
        Person p1 = new Person();
        p1.setAge(28);
        p1.setName("Miracle");
        Person p2 = new Person();
        p2.setAge(30);
        p2.setName("Miracle He");
        persons[0] = p1;
        persons[1] = p2;
        for(Person p : persons)
        {
        	p.display();
        }
	}

}
