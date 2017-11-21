package week5;

public class UserInfo {
	/*
	 * Assignment1:获取用户的状态（姓、名、住址、年龄、状态）；
	 * @Author YuanHao；
	 * */
	private String firstName;
	private String lastName;
	private String location;
	private int age;
	private int status;
	private static final int OFFLINE = 0,ONLINE = 1;
	
	public UserInfo(String firstNameln,String lastNameln) {
		firstName = firstNameln;
		lastName = lastNameln;
		location = "Not specified";
		age = 0;
		status = OFFLINE;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public Boolean setAge(int ageln) {
		if(ageln>0)
		{
			age = ageln;
			return true;
		}
		else
			return false;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String loc) {
		location = loc;
	}
	
	public void logOff() {
		status = OFFLINE;
	}
	
	public void logOn() {
		status = ONLINE;
	}
	
	public String toString()
	{
		String sta;
		if(status == OFFLINE)
			sta = "Offline";
		else
			sta = "Online";
		String output = "Name: "+firstName+" "+lastName+"\n"
				+"Location: "+location+"\n"+"Age: "+age+"\n"+
				"Status: "+sta+"\n";
		return output;
	}
}
