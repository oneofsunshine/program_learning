package week7;

public class DateApp {

	public static void main(String[] args) {
		
		Date d1 = new Date(2016,11,2);
		System.out.println(d1);
		if(d1.isLeapYear())
			System.out.println("������");
		else
			System.out.println("��������");
		
		d1.setDate(1561, 5, 15);
		System.out.println(d1);
		if(d1.isLeapYear())
			System.out.println("������");
		else
			System.out.println("��������");
	}

}
