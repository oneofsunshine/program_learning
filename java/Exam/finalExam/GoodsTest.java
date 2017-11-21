package finalExam;

import java.util.ArrayList;
import java.util.Collections;

public class GoodsTest {

	public static void main(String[] args) 
	{
		ArrayList<Goods> goodslist = new ArrayList<>();
		
		Goods g1 = new Goods("Pen", 0.5, 3.5);
		Goods g2 = new Goods("Paper", 0.1, 3.5);
		Goods g3 = new Goods("Book", 0.5, 25);
		Goods g4 = new Goods("Smartphone", 0.6, 2300);
		Goods g5 = new Goods("Watch", 0.4, 300);
		
		goodslist.add(g1);
		goodslist.add(g2);
		goodslist.add(g3);
		goodslist.add(g4);
		goodslist.add(g5);
		
		Collections.sort(goodslist);
		System.out.println("------------------ report ------------------");
		for(Goods g: goodslist)
			System.out.println(g);
		
		Collections.sort(goodslist, new WeightCompare());
		System.out.println("------------------ report by weight ------------------");
		for(Goods g: goodslist)
			System.out.println(g);
		
		Collections.sort(goodslist, new ValueCompare());
		System.out.println("------------------ report by value ------------------");
		for(Goods g: goodslist)
			System.out.println(g);
	}

}
