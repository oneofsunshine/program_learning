package week10;
/*
 * Assignment1:本类为 OnlineTextItem 的子类;
 * 			除了继承父类的属性外，需添加一个代表作者的字符串 ;
 * 			方法包括：除继承父类的所有方法外，设置作者，重构toString 方法以改变输出格式;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class OnlineBook extends OnlineTextItem {
	protected String author;//代表作者;
	
	OnlineBook(String nameln,double priceln) {
		super(nameln, priceln);
		author = "Author Not Listed";
	}//调用父类的构造方法，并将author 初始化为“未指定”;
	
	public void setAuthor(String authorln)
	{
		this.author = authorln;
	}//设置作者;
	
	public String toString ()
	{
		return super.name+" - " + author + ": $" + super.price; 
	}//重载该方法，将输出格式改为: book name – author’s name: $Price;
}
