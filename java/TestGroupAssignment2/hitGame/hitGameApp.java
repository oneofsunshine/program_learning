package hitGame;

import java.util.Scanner;

public class hitGameApp {

	/**
	 * 主函数入口
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//GUI界面测试
		new hitGameJFrame();
		 
		
		//控制台界面测试
		String[] label = { "Go2.com", "Pets.com", "AskMe.com" };
		ArrayTipleGrid webSite= new ArrayTipleGrid(label);
		int guessNum = 0;	
		System.out.println(webSite.toString());
		Scanner sc = new Scanner(System.in);
		String value;
		boolean flag = true;
		while(flag==true){
			System.out.print("Enter a guess :　");
			value=sc.nextLine();
			guessNum++;
			System.out.println(webSite.hitting(value));
			if(webSite.isStop())		
				flag=false;		
		}
		
		System.out.println("你总共的分为:"+webSite.yourPrize(guessNum));
		System.out.println("你总共猜测的次数是:"+guessNum);
		sc.close();

	}

}
