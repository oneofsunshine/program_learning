package week6;

public class Student {
	private String name;
	private Address homeAddress;
	private Address schoolAddress;
	Student(String nameln,Address homeAddressln,Address schoolAddressln)
	{
		name=nameln;
		homeAddress=homeAddressln;
		schoolAddress=schoolAddressln;
	}
	public String toString()
	{
		String result;
		result="name:"+name+"\n"+"Home Address:"+homeAddress+"\n"
				+"School Address:"+schoolAddress;
		return result;
	}
}
