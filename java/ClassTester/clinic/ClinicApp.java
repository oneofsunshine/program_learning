package clinic;

public class ClinicApp 
{

	public static void main(String[] args) 
	{
		BillList bl = new BillList("单身狗科");
		
		Doctor d1 = new Doctor("Doctor Li");
		Doctor d2 = new Doctor("Doctor Zhang");
		Doctor d3 = new Doctor("Doctor Ma");
		
		Patient p1 = new Patient("Mr.Wang");
		Patient p2 = new Patient("Mrs.zhao");
		Patient p3 = new Patient("Miss.Sun");
		
		Bill b1 = new Bill("1", d1, p1, 200);
		Bill b2 = new Bill("2", d1, p2, 300);
		Bill b3 = new Bill("3", d2, p1, 500);
		Bill b4 = new Bill("4", d2, p2, 1000);
		Bill b5 = new Bill("5", d3, p1, 600);
		Bill b6 = new Bill("6", d3, p3, 900);
		Bill b7 = new Bill("7", d3, p2, 700);
		Bill b8 = new Bill("8", d1, p3, 800);
		
		bl.addBill(b1);
		bl.addBill(b2);
		bl.addBill(b3);
		bl.addBill(b4);
		bl.addBill(b5);
		bl.addBill(b6);
		bl.addBill(b7);
		bl.addBill(b8);
		
		System.out.println(bl);
		System.out.println(bl.report());
		System.out.println(bl.reportByDoctor());
		System.out.println(bl.reportByPatient());
	}

}
