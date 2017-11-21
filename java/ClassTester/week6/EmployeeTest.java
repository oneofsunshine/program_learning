package week6;

class Employee{
	private double employeeSalary = 1800; 
	private String employeeName = "姓名未知"; 
	private int employeeNo; 
	public Employee(){ 
		System.out.println("不带参数的构造函数被调用!");
	}  
	public Employee(String s){  
		employeeName = s;
		System.out.println("带有姓名参数的构造函数被调用!");      
	}      
	public Employee(int n,String nln,double s) { 
		employeeNo=n;
		employeeName=nln;
		employeeSalary=s;
		System.out.println("带有编号、姓名和薪水这三个参数的构造函数被调用!"); 
	}    
	public String toString() { 
	       String result;
	       result="编号:"+employeeNo+" 姓名:"+employeeName
	    		   +" 工资:"+employeeSalary;
	       return result;
	}
} 
public class EmployeeTest { 
	public static void main(String[] args) { 
		Employee e1 = new Employee(); 
		Employee e2 = new Employee("强总理");  
		Employee e3 = new Employee(1,"习大大", 1234567); 
		System.out.println("e1: " + e1); 
		System.out.println("e2: " + e2);
		System.out.println("e3: " + e3);
		} 
	}