package week11;

import java.text.DecimalFormat;

/*
 * Assignment1:创建InventoryItem类，代表货物;
 * 			方法包括：获取货物名，获取货物含税价格，设置货物税率，获取货物信息;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class InventoryItem {
	protected String name;//代表货物名;
	protected double price;//代表货物价格（不含税）;
	static double taxRate = 0;//代表税率;
	
	InventoryItem(String nln,double pln)
	{
		this.name = nln;
		this.price = pln;
	}//对货物名和货物价格进行初始化;
	
	public String getName()
	{
		return this.name;
	}//返回代表货物名的String 类型的值;
	
	public double calculateCost()
	{
		return this.price*(1 + taxRate);
	}//返回代表货物含税价格的double 类型的值;
	
	public static void setTaxRate(double tr)
	{
		taxRate =tr;
	}//设置税率;
	
	public String toString()
	{
		DecimalFormat output = new DecimalFormat("#,###0.00");
		return name + ": $" + output.format(calculateCost());
	}//返回代表货物名的String 类型的值和代表货物含税价格的double 类型的值;
}
