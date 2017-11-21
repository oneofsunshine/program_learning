package week7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import week8.Cylinder;
/*
 * Assignment1:包含 main 方法，打开用户输入的文件并读取第一行作为集合的名字;
 * 		之后读取其他行， 依次生成 Cylinder对象，最后生成 CylinderList对象;
 *  	输出 CylinderList对象（调用 toString 方法），之后空一行;
 *  	输出 CylinderList对象的汇总 信息（调用 summaryInfo 方法）;		
 * @Author YuanHao；
 * Sno: 15130041045
 * */
public class CylinderListApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		Cylinder cylinder;
		ArrayList<Cylinder> cyl = new ArrayList<Cylinder>();
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fileName = scan.nextLine();//获取文件名;
		
	    Scanner scanFile = new Scanner(new File(fileName));//扫描文件;
	    
		String listName = scanFile.nextLine();
		
		while(scanFile.hasNext())
		{
			String label = scanFile.nextLine();//获取标签值;
			double radius = Double.parseDouble(scanFile.nextLine());//获取半径值;
			double height = Double.parseDouble(scanFile.nextLine());//获取高度值;
			
			cylinder = new Cylinder(label, radius, height);//创建Cylinder对象;
			
			cyl.add(cylinder);//将创建的对象添加到cyl动态数组中;
		}
		
		CylinderList cl = new CylinderList(listName, cyl);//创建CylinderList对象;
		
		System.out.println(cl);//输出 CylinderList对象;
		System.out.println();
		System.out.println(cl.summaryInfo());//输出 CylinderList对象的汇总 信息;
	}

}
