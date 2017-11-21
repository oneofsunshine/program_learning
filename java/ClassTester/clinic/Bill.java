package clinic;

public class Bill implements Comparable<Bill> 
{
	private String billNumber;
	private Doctor doctor;
	private Patient patient;
	private int cost;
	
	
	public Bill(String num, Doctor d, Patient p, int c) 
	{
		billNumber = num;
		doctor = d;
		patient = p;
		cost = c;
	}
	
	public String getNumber()
	{
		return this.billNumber;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public Doctor getDoctor()
	{
		return this.doctor;
	}
	
	public Patient getPatient()
	{
		return this.patient;
	}
	
	public int compareTo(Bill b) {
		return this.getDoctor().getName().compareTo(b.getDoctor().getName());
	}
		
	public String toString()
	{
		return "\n\tBill Number: " + billNumber + "\nDoctor Name: " 
				+ doctor.getName() + " - Patient Name: " + patient.getName() + "\tCost: " + cost;
	}
	
}
