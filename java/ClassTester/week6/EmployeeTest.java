package week6;

class Employee{
	private double employeeSalary = 1800; 
	private String employeeName = "����δ֪"; 
	private int employeeNo; 
	public Employee(){ 
		System.out.println("���������Ĺ��캯��������!");
	}  
	public Employee(String s){  
		employeeName = s;
		System.out.println("�������������Ĺ��캯��������!");      
	}      
	public Employee(int n,String nln,double s) { 
		employeeNo=n;
		employeeName=nln;
		employeeSalary=s;
		System.out.println("���б�š�������нˮ�����������Ĺ��캯��������!"); 
	}    
	public String toString() { 
	       String result;
	       result="���:"+employeeNo+" ����:"+employeeName
	    		   +" ����:"+employeeSalary;
	       return result;
	}
} 
public class EmployeeTest { 
	public static void main(String[] args) { 
		Employee e1 = new Employee(); 
		Employee e2 = new Employee("ǿ����");  
		Employee e3 = new Employee(1,"ϰ���", 1234567); 
		System.out.println("e1: " + e1); 
		System.out.println("e2: " + e2);
		System.out.println("e3: " + e3);
		} 
	}