package week11;
/*
 * Assignment1:该类代表用户可购买的在线文本商品（如电子书或者电子杂志）;
	因为它只是概念级的、 代表物品的类，因此可以设置为抽象类;
	方法包括：除继承父类的所有方法外，重载 calculateCost 方法;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public abstract class OnlineTextItem extends InventoryItem {
	OnlineTextItem(String nameln,double priceln)
	{
		super(nameln, priceln);
	}//调用父类的构造方法;
	
	public double calculateCost()
	{
		return super.price;
	}//重载 calculateCost 方法，仅返回price（货物不含税价格）;
}
