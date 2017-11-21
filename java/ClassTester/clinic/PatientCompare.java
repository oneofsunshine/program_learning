package clinic;

import java.util.Comparator;

public class PatientCompare implements Comparator<Bill>
{
	public int compare(Bill b1, Bill b2) {
		return b1.getPatient().getName().compareTo(b2.getPatient().getName());
	}

}
