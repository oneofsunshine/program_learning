package week5;

public class AccountDrive {

	public static void main(String[] args) {
		/*
		 * Assignment2:测试超简化银行信息处理；
		 * @Author YuanHao
		 * */
		Account acct1 = new Account("101", "小李", 10000);
		Account acct2 = new Account("102", "小张", 10000);
		Account acct3 = new Account("103", "小王", 10000);
		
		System.out.println("初始信息： ");
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
		
		System.out.println("交易后"+acct1.name+"的余额为："+acct1.deposit(300));
		System.out.println("交易后"+acct2.name+"的余额为："+acct2.deposit(500));
		System.out.println("交易后"+acct2.name+"的余额为："+acct2.withdraw(400));
		
		System.out.println("加息后"+acct1.name+"的余额为："+acct1.addInterest());
		System.out.println("加息后"+acct2.name+"的余额为："+acct2.addInterest());
		System.out.println("加息后"+acct3.name+"的余额为："+acct3.addInterest());
		
		System.out.println("更改后信息：");
		System.out.println(acct1);
		System.out.println(acct2);
		System.out.println(acct3);
	}

}
