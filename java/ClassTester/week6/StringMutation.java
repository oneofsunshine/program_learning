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
		System.out.println("Length of string:"+phrase.length());//返回字符串长度
		
		mutation1 = phrase.concat(",except fromvending machines.");//返回phrase与参数连接的结果
		mutation2 = mutation1.toUpperCase();//返回mutation1的大写形式
		mutation3 = mutation2.replace('E', 'X');//将mutation2中的'E'替换为'X'
		mutation4 = mutation3.substring(3,30);//获取mutation3从第3个字符开始、至第30个字符的字符串（不包含第30个字符）
		
		System.out.println("Mutation #1:"+mutation1);
		System.out.println("Mutation #2:"+mutation2);
		System.out.println("Mutation #3："+mutation3);
		System.out.println("Mutation #4:"+mutation4);
		
		System.out.println("Mutation length:"+mutation4.length());//输出mutation4 的长度
	}

}
