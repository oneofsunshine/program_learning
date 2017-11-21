package week10;
/*
 * Assignment1:本类为OnlineTextItem 类的子类，代 表电子类文本物品;
 * 			除继承 OnlineTextItem 及 InventoryItem 类的属性外，还要记录字数;
 * 			方法包括：除继承父类的所有方法外，设置字数，重构toString 方法以改变输出格式;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class OnlineArticle extends OnlineTextItem {
	private int wordCount;//代表字数;
	
	OnlineArticle(String nameln,double priceln)
	{
		super(nameln, priceln);
		this.wordCount = 0;
	}//调用父类的构造方法，并将字数初始化为0;
	
	public void setWordCount(int wcln)
	{
		this.wordCount = wcln;
	}//设置字数;
	
	public String toString()
	{
		return super.name + " - $" + super.price + " " + wordCount + " words";
	}//重载该方法，将输出格式改为:article name –$Price wordCount;
}
