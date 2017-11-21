package week8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Assignment1:：包含 main 方法，呈现有 7 个选项的菜单
 *		（1） 读入文件内容并创建 CylinderList对象
 *		（2） 打印输出 CylinderList对象
 *		（3） 打印输出 CylinderList对象的汇总信息
 *		（4） 增加一个 CylinderList对象至 CylinderList对象中
 *		（5） 从 CylinderList对象中删除一个 Cylinder对象
 *		（6） 在 CylinderList对象中找到一个 Cylinder对象
 *		（7） 退出程序
 * 设计：
 *		main方法中将先输出带有描述的 7 个选项信息;
 *		一旦用户输入了一个选项编号，则对应 的方法将被调用;
 *		之后再次呈现选项信息，提示用户进行选择;
 * @Author YuanHao;
 * Sno: 15130041045;
 * */
public class CylinderListMenuApp {

	public static void main(String[] args) throws IOException {
		
		String str = "***no list name assigned***";
		ArrayList<Cylinder> cy = new ArrayList<Cylinder>();
		CylinderList cl = new CylinderList(str,cy);

		char choice = 'a';//用来表示用户输入的选择;
		String fileName;
		String lab;
		double rad,hei;
		
		Scanner sc = new Scanner(System.in);
		
//		输出带有描述的 7 个选项信息;
		System.out.println("Cylinder List System Menu");
		System.out.println("R - ReadFile and Create Cylinder List");
		System.out.println("P - Print Cylinder List");
		System.out.println("S - Print Summary");
		System.out.println("A - Add Cylinder");
		System.out.println("D - Delete Cylinder");
		System.out.println("F - Find Cylinder");
		System.out.println("Q - Quit");
		
//		提示用户进行选择;
		System.out.print("Enter Code [R, P, S, A, D, F or Q]: ");
		
		sometag:while(sc.hasNext())
		{
			choice = sc.nextLine().charAt(0);
			
			switch(choice)
			{
//			当输入'r'或'R'时，读入文件内容并创建 CylinderList对象;
				case 'r':;
				case 'R':
					System.out.print("\tFile name:");
					fileName = sc.nextLine();
					cl = cl.readFile(fileName);
					System.out.println("\tFile read in and Cylinder List created");
					break;
					
//			当输入'p'或'P'时，打印输出 CylinderList对象;
				case 'p':;
				case 'P':
					System.out.println(cl);
					break;
					
//			当输入's'或'S'时,打印输出 CylinderList对象的汇总信息;
				case 's':;
				case 'S':
					System.out.println("\n"+cl.summaryInfo());
					break;
					
//			当输入'a'或'A'时,增加一个 CylinderList对象至 CylinderList对象中;
				case 'a':;
				case 'A':
					System.out.print("\tLabel: ");
					lab = sc.nextLine();
					System.out.print("\tRadius: ");
					rad = Double.parseDouble(sc.nextLine());
					System.out.print("\tHeight: ");
					hei =Double.parseDouble(sc.nextLine());
					cl.addCylinder(lab, rad, hei);
					System.out.println("\t*** Cylinder added ***");
					break;
					
//			当输入'd'或'D'时,从 CylinderList 对象中删除一个 Cylinder 对象;
				case 'd':;
				case 'D':
					System.out.print("\tLabel: ");
					lab = sc.nextLine();
					if(cl.findCylinder(lab)!=null)
					{
						cl.deleteCylinder(lab);
						System.out.println("\t\""+lab+"\" deleted");
					}
					else
						System.out.println("\t\""+lab+"\" not found");
					break;
					
//			当输入'f'或'F'时,在 CylinderList 对象中找到一个 Cylinder 对象;
				case 'f':;
				case 'F':
					System.out.print("\tLabel: ");
					lab = sc.nextLine();
					if(cl.findCylinder(lab)!=null)
						System.out.println(cl.findCylinder(lab));
					else
						System.out.println("\t\""+lab+"\" not found");
					break;
					
//			当输入'q'或'Q'时,退出程序;
				case 'q':;
				case 'Q':
					break sometag;
					
//			当输入不是以上几个字母时，输出提示语;
				default:System.out.println("\t*** invalid code ***");;
			}
			
//			再次呈现选项信息，提示用户进行选择;
			System.out.print("\nEnter Code [R, P, S, A, D, F or Q]: ");
		}
	}

}
