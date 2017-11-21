package week9;

public class TestStringArray {

	public static void main(String[] args) {
		String[] stringArray; //1.定义数组
		stringArray = new String[2]; //2.分配内存空间，确定引用关系 
		
		stringArray[0] = new String("孙悟空"); 
		stringArray[1] = new String("白骨精");
		
//		stringArray[1] = stringArray[0];
		
		for(String s : stringArray) 
		{//3.为数组元素指定值      
			System.out.println(s); 
		}
	}
}
