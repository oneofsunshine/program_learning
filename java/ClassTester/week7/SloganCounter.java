package week7;

public class SloganCounter {

	public static void main(String[] args) {
		Slogan s1 = new Slogan("what");
		System.out.print(Slogan.count+"£º\t");
		System.out.println(s1.toString());
		
		Slogan s2 = new Slogan("should");
		System.out.print(Slogan.count+":\t");
		System.out.println(s2.toString());
		
		Slogan s3 = new Slogan("input");
		System.out.print(Slogan.count+"\t");
		System.out.println(s3.toString());
		
		s1=new Slogan("gdayosdg");
		System.out.println(s1.getCount());
	}

}
