package week5;

public class Account {
	/*
	 * Assignment2:超简化银行信息处理，存款，取款，加息，显示当前余额；
	 * @Author YuanHao;
	 * */
	private String acctNumber;
	protected String name;
	private double balance;
	private final double RATE = 0.035;
	
	Account(String acc,String nameln,double bal)
	{
		this.acctNumber = acc;
		this.name = nameln;
		this.balance = bal;
	}
	
	public double deposit(double amount)
	{
		balance = balance+amount;
		return balance;
	}
	
	public double withdraw(double amount)
	{
		balance = balance-amount;
		return balance;
	}
	
	public double addInterest()
	{
		balance=balance*(1+RATE);
		return balance;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String toString()
	{
		String result;
		result = "银行账号： "+acctNumber+"\t"+"姓名:"+name+"\t"+
				"余额"+balance;
		return result;
	}
}
