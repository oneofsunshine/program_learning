package week9;

public class StudentArray {

	public static void main(String[] args) {
       Student[] s; //����������� s
       s = new Student[10];
       
       for(int i=0;i<s.length;i++)//���������ÿһ��Ԫ�� 
       {
    	   s[i] = new Student("Student"+i, i);
       }
		//����һ��Student���󲢸�ֵ ������Ԫ�� 
       for(Student st :s)
    	   System.out.println(st);
		//���������Ԫ��  
	}

}
