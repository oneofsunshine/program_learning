package week11;

/*
 * Assignment1:本类为测试类;
 *	 			设置税率为 0.05;
 * 				初始化4 个货物并将其增加到 myItems 中,输出myItems;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class ItemListApp
{

	public static void main(String[] args) {
		ItemsList myItems = new ItemsList();// 创建ItemsList 对象myItems;
		
		InventoryItem.setTaxRate(0.05);// 设置税率为 0.05;
		
		ElectronicsItem item1 = new ElectronicsItem("笔记本", 1234.56, 10);// 创建ElectronicsItem 类对象1;
		
		InventoryItem item2 = new InventoryItem("机油 ", 9.8);// 创建InventoryItem 类对象2;
		
		OnlineBook item3 = new OnlineBook("疯狂 Java讲义 ", 12.3);// 创建OnlineBook 类对象3;
		item3.setAuthor("李刚 ");// 调用OnlineBook 类的方法，设置作者;
		
		OnlineArticle item4 = new OnlineArticle("如何学好 Java", 3.4);// 创建OnlineArticle 类对象4;
		item4.setWordCount(700);// 调用OnlineArticle 类的方法，设置字数;
		
		/*
		 * 调用myItems 类的方法，将4 个对象添加到 myItems 类中;
		*/
		myItems.addItem(item1);
		myItems.addItem(item2);
		myItems.addItem(item3);
		myItems.addItem(item4);
		
		System.out.println(myItems);// 输出myItems;
	}

}
