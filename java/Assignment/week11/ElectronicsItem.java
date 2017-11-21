package week11;
/*
 * Assignment1:本类为InventoryItem 类的子类，代表电子类货物;
 * 			拥有父类的全部属性，除此之外还有重量及货运费用标准;
 * 			方法包括：除继承父类的所有方法外，重载 calculateCost 方法以计算货运费用;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class ElectronicsItem extends InventoryItem{
	
	protected double weight;//代表货物重量;
	public final double SHIPPING_COST = 1.5;//代表每磅的货运费用;
	
	ElectronicsItem(String nameln, double priceln,double weightln)
	{
		super(nameln,priceln);
		this.weight = weightln;
	}//对货物名，货物价格和货物重量进行初始化;
	
	public double calculateCost()
	{
		return super.calculateCost() + weight * SHIPPING_COST;
	}//重载 calculateCost 方法，返回代表含税含货运费用的double 类型的值;
}
