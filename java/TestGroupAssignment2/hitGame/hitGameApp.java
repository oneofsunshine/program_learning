package hitGame;

import java.util.Scanner;

public class hitGameApp {

	/**
	 * ���������
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		//GUI�������
		new hitGameJFrame();
		 
		
		//����̨�������
		String[] label = { "Go2.com", "Pets.com", "AskMe.com" };
		ArrayTipleGrid webSite= new ArrayTipleGrid(label);
		int guessNum = 0;	
		System.out.println(webSite.toString());
		Scanner sc = new Scanner(System.in);
		String value;
		boolean flag = true;
		while(flag==true){
			System.out.print("Enter a guess :��");
			value=sc.nextLine();
			guessNum++;
			System.out.println(webSite.hitting(value));
			if(webSite.isStop())		
				flag=false;		
		}
		
		System.out.println("���ܹ��ķ�Ϊ:"+webSite.yourPrize(guessNum));
		System.out.println("���ܹ��²�Ĵ�����:"+guessNum);
		sc.close();

	}

}
