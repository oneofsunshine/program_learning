package clinic;

import java.util.Arrays;

public class BillList
{
	private String billName;
	private Bill[] bl;
	private int billNumber;
	
	public BillList(String name) {
		bl  = new Bill[0];
		billNumber = 0;
		billName = name;
	}
	
	public String getName()
	{
		return billName;
	}
	
	public int getBillNumber()
	{
		return billNumber;
	}
		
	public void addBill(Bill b)
	{
		bl = Arrays.copyOf(bl, bl.length + 1);
		bl[bl.length - 1] = b;
		billNumber ++;
	}
	
	public int totalCost()
	{
		int total = 0;
		for(int i = 0; i < bl.length; i++)
			total += bl[i].getCost();
		return total;
	}
	
	public int patientTotalCost(String pname)
	{
		int total = 0;
		for(int i = 0; i < bl.length; i++)
		{
			if(pname.equals(bl[i].getPatient().getName()))
				total += bl[i].getCost();
		}
		return total;
	}
	
	public int doctorTotalEarn(String dname)
	{
		int total = 0;
		for(int i = 0; i < bl.length; i++)
		{
			if(dname.equals(bl[i].getDoctor().getName()))
				total += bl[i].getCost();
		}
		return total;
	}
		
	public String report()
	{
		String result = "\t--------------------------------------------------\n";
		result += "\t\t\t\tReport\n";
		result += "\t--------------------------------------------------";
		for(int i = 0; i < bl.length; i++)
			result += bl[i];
		return result;
	}
	
	public String reportByDoctor()
	{
		Arrays.sort(bl);
		String result = "\t--------------------------------------------------\n";
		result += "\t\t\tReport By Doctor\n";
		result += "\t--------------------------------------------------";
		for(int i = 0; i < bl.length; i++)
		{
			result += bl[i];
			if(i < bl.length - 1)
			{
				if(bl[i].compareTo(bl[i + 1]) < 0)
					result += "\n\t" + bl[i].getDoctor().getName() + " earns: " + doctorTotalEarn(bl[i].getDoctor().getName()) + "\n";	
			}
			if(i == bl.length - 1)
				result += "\n\t" + bl[i].getDoctor().getName() + " earns: " + doctorTotalEarn(bl[i].getDoctor().getName());
		}
		return result;
	}
	
	public String reportByPatient()
	{
		Arrays.sort(bl, new PatientCompare());
		String result = "\t--------------------------------------------------\n";
		result += "\t\t\tReport By Patient\n";
		result += "\t--------------------------------------------------";
		for(int i = 0; i < bl.length; i++)
		{
			result += bl[i];
			if(i < bl.length - 1)
			{
				if(bl[i].getPatient().getName().compareTo(bl[i + 1].getPatient().getName()) < 0)
					result += "\n\t" + bl[i].getPatient().getName() + " costs: " + patientTotalCost(bl[i].getPatient().getName()) + "\n";	
			}
			if(i == bl.length - 1)
				result += "\n\t" + bl[i].getPatient().getName() + " costs: " + patientTotalCost(bl[i].getPatient().getName());
		}
		return result;
	}
	
	public String toString()
	{
		String result;
		result = "\t\t\tBill Name:" + getName();
		result += "\n\t\ttotal bill: " + getBillNumber();
		result += "\ttotal earn: " + totalCost();
		return result;
	}

	
}
