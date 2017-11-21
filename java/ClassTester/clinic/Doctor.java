package clinic;

import java.util.Comparator;

public class Doctor
{
	private String doctorName;
	
	public Doctor(String name)
	{
		doctorName = name;
	}
	
	public String getName()
	{
		return doctorName;
	}
	
	public String toString()
	{
		return "Doctor name: " + getName();
	}
}
