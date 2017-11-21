package week9;

public class Student {
	private String username;
	private int num;
	public Student(String username, int num)
	{  
		this.username = username; 
		this.num = num;
	} 
	public String getUsername()
	{  
		return username; 
	}
	public void setUsername(String username)
	{  
		this.username = username;
	} 
	public int getNum() 
	{  
		return num;
	} 
	public void setNum(int num)
	{  
		this.num = num; 
	}
	public String toString()
	{   
		return "Ñ§ºÅ£º" + this.num + " ĞÕÃû£º" + this.username; 
	}
}
