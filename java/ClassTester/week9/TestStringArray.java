package week9;

public class TestStringArray {

	public static void main(String[] args) {
		String[] stringArray; //1.��������
		stringArray = new String[2]; //2.�����ڴ�ռ䣬ȷ�����ù�ϵ 
		
		stringArray[0] = new String("�����"); 
		stringArray[1] = new String("�׹Ǿ�");
		
//		stringArray[1] = stringArray[0];
		
		for(String s : stringArray) 
		{//3.Ϊ����Ԫ��ָ��ֵ      
			System.out.println(s); 
		}
	}
}
