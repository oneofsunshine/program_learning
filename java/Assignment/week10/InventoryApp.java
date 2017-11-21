package week10;
/*
 * Assignment1:本类为测试类;
 * 			设置税率为 0.05;
 * 			初始化并输出 4 个对象（item1、item2、item3、item4）;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class InventoryApp {

	public static void main(String[] args) {
		
		InventoryItem.setTaxRate(0.05);//设置税率为 0.05;
		
		InventoryItem item1 = new InventoryItem("pen", 25);//初始化InventoryItem 类对象1;
		
		ElectronicsItem item2 = new ElectronicsItem("apple phone", 1000, 1.8);//初始化ElectronicsItem 类对象2;
		
		OnlineArticle item3 = new OnlineArticle("Java", 8.5);//初始化OnlineArticle 类对象3;
		item3.setWordCount(700);//调用OnlineArticle 类的方法，设置字数;
		
		OnlineBook item4 = new OnlineBook("Head first Java", 40);//初始化OnlineBook 类对象4;
		item4.setAuthor("Kathy&Bert");//调用OnlineBook 类的方法，设置作者;
		
		/*
		 * 输出四个对象;
		*/
		System.out.println("item1\n"+item1);
		System.out.println("item2\n"+item2);
		System.out.println("item3\n"+item3);
		System.out.println("item4\n"+item4);
	}

}
