package week6;

public class Address {
	private String streetAddress;
	private String city;
	private long zipCode;
	Address(String streetAddressln,String cityln,long zipCodeln)
	{
		streetAddress=streetAddressln;
		city=cityln;
		zipCode=zipCodeln;
	}

	public String toString()
	{
		String result;
		result = streetAddress+"."+city+"."+zipCode;
		
		return result;
	}
}
