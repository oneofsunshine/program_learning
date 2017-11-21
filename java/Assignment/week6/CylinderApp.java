package week6;

import java.util.ArrayList;
import java.util.Scanner;

import week8.Cylinder;
	/*
	 * Assignment1:获取用户输入的标签、半径及高度，一旦这三个值被读入，创建Cylinder对象并输出;
	 * @Author YuanHao;
	 * Sno: 15130041045;
	 * */
public class CylinderApp {

	public static void main(String[] args) {

		ArrayList<Cylinder> cyd = new ArrayList<Cylinder>();//用于存放用户输入的Cylinder对象的信息;
		Scanner input = new Scanner(System.in);
		Cylinder c1;
		
		System.out.print("请输入您想创建的Cylinder对象个数: ");
		//定义num代表用户想输入的Cylinder对象个数;
		int num = Integer.parseInt(input.nextLine());
		
		//用户可以输入num个Cylinder对象的信息,也可以中途停止创建Cylinder对象;
		for(;Cylinder.count < num;)
		{
			c1 = new Cylinder("", 0, 0);
			System.out.println("Enter label, radius, and height for a cylinder.");
			System.out.print("\tlabel: ");
			
			while(!c1.setLabel(input.nextLine()))
			{
				System.out.println("输入标签值为空，请重新输入： ");
				System.out.print("\tlabel: ");
			}//设置标签，如果输入的是空值，则重新输入标签;
			
			System.out.print("\tradius: ");
			c1.setRadius(Double.parseDouble(input.nextLine()));//设置半径;
			
			System.out.print("\theight: ");
			c1.setHeight(Double.parseDouble(input.nextLine()));//设置高度;
			cyd.add(c1);
			
			System.out.println(c1);//输出当前获取的信息;
			
			//输出已创建的Cylinder对象个数;
			System.out.println("已创建: "+Cylinder.count+" 个Cylinder对象.");
			System.out.println();
			
			//询问用户是否继续创建Cylinder对象，如果用户输入'y'或'Y'继续，否则不再创建Cylinder对象;
			if(Cylinder.count < num)
			{
				System.out.print("continues?(Yes or No) :");
				char yOrY = input.nextLine().charAt(0);
				if(yOrY != 'y' && yOrY != 'Y')
					break;
			}
			
		}
		
		//输出所有获取的用户输入的信息;
		System.out.println("您输入的信息为： ");
		System.out.println("您创建了"+cyd.size()+"个Cylinder对象.");
		for(int i=1;i<=cyd.size();i++)
		{
			System.out.println("No: "+i);
			System.out.println(cyd.get(i-1));
		}
		
		input.close();
	}

}
