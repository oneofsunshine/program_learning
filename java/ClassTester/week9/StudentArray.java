package week9;

public class StudentArray {

	public static void main(String[] args) {
       Student[] s; //定义对象数组 s
       s = new Student[10];
       
       for(int i=0;i<s.length;i++)//遍历数组的每一个元素 
       {
    	   s[i] = new Student("Student"+i, i);
       }
		//创建一个Student对象并赋值 给数组元素 
       for(Student st :s)
    	   System.out.println(st);
		//输出该数组元素  
	}

}
