package week6;

public class StringMutation
{
	//----------------------------------------------
	//	Prints a string and various mutations of it.	
	//-------------------------------------------	
	public static void main(String[] args) {
		String phrase = "Change is inevitabke";
		String mutation1,mutation2,mutation3,mutation4;
		System.out.println("Original string:\""+phrase+"\"");
		System.out.println("Length of string:"+phrase.length());//�����ַ�������
		
		mutation1 = phrase.concat(",except fromvending machines.");//����phrase��������ӵĽ��
		mutation2 = mutation1.toUpperCase();//����mutation1�Ĵ�д��ʽ
		mutation3 = mutation2.replace('E', 'X');//��mutation2�е�'E'�滻Ϊ'X'
		mutation4 = mutation3.substring(3,30);//��ȡmutation3�ӵ�3���ַ���ʼ������30���ַ����ַ�������������30���ַ���
		
		System.out.println("Mutation #1:"+mutation1);
		System.out.println("Mutation #2:"+mutation2);
		System.out.println("Mutation #3��"+mutation3);
		System.out.println("Mutation #4:"+mutation4);
		
		System.out.println("Mutation length:"+mutation4.length());//���mutation4 �ĳ���
	}

}
