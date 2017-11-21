package clinic;

public class Patient
{
	private String patientName;
	
	public Patient(String name) 
	{
		patientName = name;
	}
	
	public String getName() {
		return patientName;
	}
	
	public String toString()
	{
		return "Patient Name" + patientName;
	}
}
