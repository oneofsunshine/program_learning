package week11;
/*
 * Assignment1:本类能够存放 InventoryItem 类对象的数组（包括继承 InventoryItem 类而 产生的子类对象）;
 * 			方法包括：向数组添加InventoryItem 类对象，获取数组内各对象信息;
 * 				对ElectronicsItem类对象征收附加税并求数组内各对象的价格总和;
 * @Author YuanHao；
 * Sno: 15130041045
 * */
import java.text.DecimalFormat;

public class ItemsList
{
	protected InventoryItem[] inventory;// 代表存放InventoryItem 类对象的数组;
	protected int count;// 代表向数组添加的InventoryItem 类对象所在下标;
	
	ItemsList()
	{
	inventory = new InventoryItem[20];
	count = 0;
	}// 对数组和下标进行初始化;
	
	/*
	 * 以 InventoryItem 类对象为参数;
	 * 将参数赋值给 inventory 中下标为 count 值的元 素，然后 count 自增 1;
	 * 不考虑超出数组长度的情况;
	 */
	public void addItem(InventoryItem itemln)
	{
		inventory[count] = itemln;
		count++;
	}
	
	/*
	 * 以double 类型数为参数，参数代表对 ElectronicsItem 类征收的附加费;
	 * 要遍历 inventory 数组的每一个元素，求价格总和;
	 * 如果元素为 ElectronicsItem 类的引用变量，对元素增收附加费;
	 * */
	public double calculateTotal(double electronicsSurcharge)
	{
		double totalCost = 0;
		for(int i = 0; i < count; i++)
		{
			if(inventory[i] instanceof ElectronicsItem)
			{
				totalCost += inventory[i].calculateCost() + electronicsSurcharge;
			}
			else
				totalCost += inventory[i].calculateCost();
		}
		return totalCost;
	}
	
	/*
	 * 格式化输出数组内各对象信息;
	 * 输出总价格;
	 * */
	public String toString()
	{
		DecimalFormat output = new DecimalFormat("#,###0.00#");
		String result = "All inventory:\n\n";
		for(int i = 0; i < count; i++)
		{
			result += inventory[i].toString() + "\n"; 
		}
		result += "\nTotal: " + output.format(calculateTotal(2));
		return result;
	}
}
